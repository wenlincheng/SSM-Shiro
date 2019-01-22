package com.wenlincheng.ssm.shiro.realm;

import com.wenlincheng.ssm.pojo.*;
import com.wenlincheng.ssm.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: MyRealm
 * @Description: 自定义的授权认证
 * @Author: Cheng
 * @Date: 2018/11/1 22:38
 */
public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private TUserService userService;

    @Autowired
    private TUserRoleService userRoleService;

    @Autowired
    private TRoleService roleService;

    @Autowired
    private TPermissionService permissionService;

    @Autowired
    private TRolePermissionService rolePermissionService;

    /**
     * @MethodName: doGetAuthorizationInfo
     * @Description: 授权的方法
     * @Params: [principalCollection]
     * @Return: org.apache.shiro.authz.AuthorizationInfo 
     * @Author: Cheng
     * @Date: 2018/11/1 22:39
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("--- MyRealm doGetAuthorizationInfo (授权)---");

        // 获得经过认证的用户信息
        TUser user = (TUser)principalCollection.getPrimaryPrincipal();
        Integer userId = user.getUserId();

        // 查询该用户所有的角色列表
        List<TUserRole> userRoleList = userRoleService.getByUid(userId);
        List<TRole> roleList = new ArrayList<>();
        List<String> roleStrList = new ArrayList<>();

        for (TUserRole userRole: userRoleList){
            TRole role = roleService.getById(userRole.getRoleId());
            roleList.add(role);
            roleStrList.add(role.getRoleStr());
        }

        // 根据角色列表查询该用户的所有资源权限列表
        List<TRolePermission> rolePermissionList = new ArrayList<>();
        List<String> permissionStrList = new ArrayList<>();
        for(TRole role: roleList){
            List<TRolePermission> rolePermissionList2 = rolePermissionService.getByRid(role.getRoleId());

            if(rolePermissionList2.size() > 0){
                rolePermissionList.addAll(rolePermissionList2);
            }
        }

        // 权限
        for(TRolePermission rolePermission : rolePermissionList){
            TPermission permission = permissionService.getById(rolePermission.getId());
            permissionStrList.add(permission.getPermissionStr());
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 向 info 中设置角色、权限信息，去重
        info.setRoles(new HashSet<>(roleStrList));
        info.setStringPermissions(new HashSet<>(permissionStrList));

        // 完成了动态地对用户授权
        logger.debug("用户角色 => " + roleStrList);
        logger.debug("用户权限 => " + permissionStrList);

        return info;
    }

    /**
     * @MethodName: doGetAuthenticationInfo
     * @Description: 认证（登录）的方法
     * @Params: [authenticationToken]
     * @Return: org.apache.shiro.authc.AuthenticationInfo 
     * @Author: Cheng
     * @Date: 2018/11/1 22:39
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("--- MyRealm doGetAuthenticationInfo (认证)---");
        // 从 token 中获取到用户名即可，用于在数据库查询用户
        String username = authenticationToken.getPrincipal().toString();

        // 从 token 中获取密码
        //String password = new String((char[])authenticationToken.getCredentials());

        // 根据用户名到数据库查询用户
        TUser user = userService.getByName(username);

        logger.debug("数据库查到的用户：" + user);

        if(user!=null){
            // 第 1 个参数可以传一个实体对象，然后在认证的环节可以取出
            // 第 2 个参数应该传递在数据库中的密码，然后和 token 中的数据进行匹配
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
            // 设置盐值
            info.setCredentialsSalt(ByteSource.Util.bytes(username.getBytes()));

            // 认证成功 返回 info
            return info;
        }

        return null;
    }


    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        Cache c = getAuthenticationCache();
        logger.info("清除【认证】缓存之前");
        for(Object o : c.keys()){
            logger.info( o + " , " + c.get(o));
        }
        super.clearCachedAuthenticationInfo(principals);
        logger.info("调用父类清除【认证】缓存之后");
        for(Object o : c.keys()){
            logger.info( o + " , " + c.get(o));
        }

        // 添加下面的代码清空【认证】的缓存
        TUser user = (TUser) principals.getPrimaryPrincipal();
        SimplePrincipalCollection spc = new SimplePrincipalCollection(user.getUserName(),getName());
        super.clearCachedAuthenticationInfo(spc);
        logger.info("添加了代码清除【认证】缓存之后");
        int cacheSize = c.keys().size();
        logger.info("【认证】缓存的大小:" + c.keys().size());
        if (cacheSize == 0){
            logger.info("说明【认证】缓存被清空了。");
        }
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        logger.info("清除【授权】缓存之前");
        Cache c = getAuthorizationCache();
        for(Object o : c.keys()){
            logger.info( o + " , " + c.get(o));
        }
        super.clearCachedAuthorizationInfo(principals);
        logger.info("清除【授权】缓存之后");
        int cacheSize = c.keys().size();
        logger.info("【授权】缓存的大小:" + cacheSize);

        for(Object o : c.keys()){
            logger.info( o + " , " + c.get(o));
        }
        if(cacheSize == 0){
            logger.info("说明【授权】缓存被清空了。");
        }

    }
}
