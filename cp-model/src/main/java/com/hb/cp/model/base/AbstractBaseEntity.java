package com.hb.cp.model.base;

import javax.persistence.Column;

/**
 * ========== 基本信息实体抽象类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.model.base.AbstractBaseEntity.java, v1.0
 * @date 2019年09月02日 10时09分
 */
public abstract class AbstractBaseEntity implements IBaseEntity {

    /**
     * 数据状态
     */
    @Column
    private String recordState;

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState;
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "recordState='" + recordState + '\'' +
                '}';
    }

}
