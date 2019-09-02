package com.hb.cp.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * ========== 时间戳抽象类，定义了创建用户、创建时间、更新用户、更新时间等字段 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.model.base.AbstractTimestampEntity.java, v1.0
 * @date 2019年09月02日 10时14分
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractTimestampEntity extends AbstractBaseEntity {

    /**
     * 创建用户id
     */
    @Column
    private String createUserId;

    /**
     * 创建日期
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    /**
     * 更新用户id
     */
    @Column
    private String updateUserId;

    /**
     * 更新日期
     */
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "AbstractTimestampEntity{" +
                "createUserId='" + createUserId + '\'' +
                ", createDate=" + createDate +
                ", updateUserId='" + updateUserId + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    @Override
    public void reset() {
        this.createUserId = null;
        this.createDate = null;
        this.updateUserId = null;
        this.updateDate = null;
    }

}
