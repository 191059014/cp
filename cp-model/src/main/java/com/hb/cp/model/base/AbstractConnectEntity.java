package com.hb.cp.model.base;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * ========== 关联关系抽象类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.model.base.AbstractConnectEntity.java, v1.0
 * @date 2019年09月02日 10时54分
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractConnectEntity extends AbstractTimestampEntity {

    /**
     * 父级ID
     */
    @Column
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "AbstractConnectEntity{" +
                "parentId='" + parentId + '\'' +
                "} " + super.toString();
    }

}
