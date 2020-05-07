package com.hb.cp.model.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 全局配置表
 *
 * @author Mr.huang
 * @since 2020/4/26 13:54
 */
public class WfpGlobalConfigDO implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 1164798410838167306L;

    // 记录修改时间
    private Date gmt_modified;
    // 记录创建时间
    private Date gmt_create;
    // 数据记录逻辑删除标识 0 正常 1 已删除
    private Object record_status;
    // 主键id
    private Integer id;
    // 配置项标识
    private String key;
    // 配置项名称
    private String name;
    // 配置项的值
    private String value;
    // 配置项的描述
    private String desc;
    // 生效时间
    private String effect_time;
    // 失效时间
    private String expire_time;
    /**
     * 预留字段
     */
    private String ext0;
    private String ext1;
    private String ext2;

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Object getRecord_status() {
        return record_status;
    }

    public void setRecord_status(Object record_status) {
        this.record_status = record_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEffect_time() {
        return effect_time;
    }

    public void setEffect_time(String effect_time) {
        this.effect_time = effect_time;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getExt0() {
        return ext0;
    }

    public void setExt0(String ext0) {
        this.ext0 = ext0;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    @Override
    public String toString() {
        return "WfpGlobalConfigDO{" +
                "gmt_modified=" + gmt_modified +
                ", gmt_create=" + gmt_create +
                ", record_status=" + record_status +
                ", id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", desc='" + desc + '\'' +
                ", effect_time='" + effect_time + '\'' +
                ", expire_time='" + expire_time + '\'' +
                ", ext0='" + ext0 + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                '}';
    }
}
