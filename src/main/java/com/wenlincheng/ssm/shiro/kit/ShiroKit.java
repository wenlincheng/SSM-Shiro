package com.wenlincheng.ssm.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Liwei on 2016/9/19.
 */
public class ShiroKit {

    // MD5 加密
    public static String md5(String originPassword, String salt) {
        return new Md5Hash(originPassword, salt).toString();
    }


    public static void main(String[] args) {
        System.out.println(md5("123456", "admin"));
        System.out.println(md5("123456", "xiaoxiao"));
        System.out.println(md5("123456", "xiaowang"));
    }
}
