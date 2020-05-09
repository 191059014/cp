package com.hb.cp.web.test;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券配置表
 *
 * @author Mr.huang
 * @since 2020/4/9 10:23
 */
public class CouponConfigDO implements Serializable {
    // the serial ID
    private static final long serialVersionUID = 8076838782242940019L;
    // 记录修改时间
    private Date gmtModified;
    // 记录创建时间
    private Date gmtCreate;
    // 数据记录逻辑删除标识 0 正常 1 已删除
    private Object recordStatus;
    // 主键id
    private Integer id;
    // 弹框标识
    private String boxId;
    // 优惠券名称
    private String couponName;
    // 优惠类型
    private Integer discountType;
    // 优惠金额
    private String discountValue;
    // 生效时间
    private String effectTime;
    // 失效时间
    private String expireTime;
    // 优惠券领取长链接
    private String couponLedUrl;
    // 优惠券图片地址
    private String couponImgUrl;
    /**
     * 预留字段
     */
    private String ext0;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Object getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Object recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getCouponLedUrl() {
        return couponLedUrl;
    }

    public void setCouponLedUrl(String couponLedUrl) {
        this.couponLedUrl = couponLedUrl;
    }

    public String getCouponImgUrl() {
        return couponImgUrl;
    }

    public void setCouponImgUrl(String couponImgUrl) {
        this.couponImgUrl = couponImgUrl;
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

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    @Override
    public String toString() {
        return "CouponConfigDO{" +
                "gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                ", recordStatus=" + recordStatus +
                ", id=" + id +
                ", boxId='" + boxId + '\'' +
                ", couponName='" + couponName + '\'' +
                ", discountType=" + discountType +
                ", discountValue='" + discountValue + '\'' +
                ", effectTime='" + effectTime + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", couponLedUrl='" + couponLedUrl + '\'' +
                ", couponImgUrl='" + couponImgUrl + '\'' +
                ", ext0='" + ext0 + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", ext4='" + ext4 + '\'' +
                '}';
    }
}
