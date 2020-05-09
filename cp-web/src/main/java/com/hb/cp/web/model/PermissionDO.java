package com.hb.cp.web.model;

import java.util.Date;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.web.model.PermissionDO.java, v1.0
 * @date 2020年05月08日 20时23分
 */
public class PermissionDO {

    private Integer permissionId;

    private String permissionName;

    private String permissionValue;

    private Date createTime;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PermissionDO{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionValue='" + permissionValue + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
