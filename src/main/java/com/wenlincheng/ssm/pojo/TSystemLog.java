package com.wenlincheng.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class TSystemLog implements Serializable {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 方法描述
     */
    private String description;

    /**
     * 方法名
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 请求用户
     */
    private String requestUsername;

    /**
     * 请求ip
     */
    private String requestIp;

    /**
     * 请求路径
     */
    private String requestUri;

    /**
     * 异常code
     */
    private String exceptionCode;

    /**
     * 异常描述
     */
    private String exceptionDetail;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 创建日期
     */
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    public String getRequestUsername() {
        return requestUsername;
    }

    public void setRequestUsername(String requestUsername) {
        this.requestUsername = requestUsername == null ? null : requestUsername.trim();
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp == null ? null : requestIp.trim();
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode == null ? null : exceptionCode.trim();
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail == null ? null : exceptionDetail.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", method=").append(method);
        sb.append(", requestType=").append(requestType);
        sb.append(", requestUsername=").append(requestUsername);
        sb.append(", requestIp=").append(requestIp);
        sb.append(", requestUri=").append(requestUri);
        sb.append(", exceptionCode=").append(exceptionCode);
        sb.append(", exceptionDetail=").append(exceptionDetail);
        sb.append(", params=").append(params);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}