package com.hb.cp.model.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hb.cp.model.enumutil.RecordStateEnum;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * ========== 基本信息实体抽象类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.model.base.AbstractBaseEntity.java, v1.0
 * @date 2019年09月02日 10时09分
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractBaseEntity implements IBaseEntity {

    /**
     * 数据状态
     */
    @Column
    private Integer recordState;

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "recordState='" + recordState + '\'' +
                '}';
    }

    public void setDefault() {
        this.recordState = RecordStateEnum.valid.getValue();
    }

}
