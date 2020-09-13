package com.mall.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    @ApiModelProperty(value = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "客户名称")
    private String cusName;

    @ApiModelProperty(value = "客户简称")
    private String cusShortened;

    @ApiModelProperty(value = "客户属性")
    private String cusProperty;

    @ApiModelProperty(value = "客户级别")
    private Integer cusLevel;

    @ApiModelProperty(value = "关联联系人")
    private String cusLinkman;

    @ApiModelProperty(value = "新老客户")
    private String cusNewOld;

    @ApiModelProperty(value = "行业")
    private String cusBusiness;

    @ApiModelProperty(value = "客户来源")
    private Integer cusSource;

    @ApiModelProperty(value = "省")
    private Integer cusProvince;

    @ApiModelProperty(value = "市")
    private Integer cusCity;

    @ApiModelProperty(value = "区")
    private Integer cusRegion;

    @ApiModelProperty(value = "详细地址")
    private String cusAddress;

    @ApiModelProperty(value = "备注")
    private String cusRemark;

    @ApiModelProperty(value = "营业执照")
    private String cusBusinessLicense;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusShortened() {
        return cusShortened;
    }

    public void setCusShortened(String cusShortened) {
        this.cusShortened = cusShortened;
    }

    public String getCusProperty() {
        return cusProperty;
    }

    public void setCusProperty(String cusProperty) {
        this.cusProperty = cusProperty;
    }

    public Integer getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(Integer cusLevel) {
        this.cusLevel = cusLevel;
    }

    public String getCusLinkman() {
        return cusLinkman;
    }

    public void setCusLinkman(String cusLinkman) {
        this.cusLinkman = cusLinkman;
    }

    public String getCusNewOld() {
        return cusNewOld;
    }

    public void setCusNewOld(String cusNewOld) {
        this.cusNewOld = cusNewOld;
    }

    public String getCusBusiness() {
        return cusBusiness;
    }

    public void setCusBusiness(String cusBusiness) {
        this.cusBusiness = cusBusiness;
    }

    public Integer getCusSource() {
        return cusSource;
    }

    public void setCusSource(Integer cusSource) {
        this.cusSource = cusSource;
    }

    public Integer getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(Integer cusProvince) {
        this.cusProvince = cusProvince;
    }

    public Integer getCusCity() {
        return cusCity;
    }

    public void setCusCity(Integer cusCity) {
        this.cusCity = cusCity;
    }

    public Integer getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(Integer cusRegion) {
        this.cusRegion = cusRegion;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusRemark() {
        return cusRemark;
    }

    public void setCusRemark(String cusRemark) {
        this.cusRemark = cusRemark;
    }

    public String getCusBusinessLicense() {
        return cusBusinessLicense;
    }

    public void setCusBusinessLicense(String cusBusinessLicense) {
        this.cusBusinessLicense = cusBusinessLicense;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cusName=").append(cusName);
        sb.append(", cusShortened=").append(cusShortened);
        sb.append(", cusProperty=").append(cusProperty);
        sb.append(", cusLevel=").append(cusLevel);
        sb.append(", cusLinkman=").append(cusLinkman);
        sb.append(", cusNewOld=").append(cusNewOld);
        sb.append(", cusBusiness=").append(cusBusiness);
        sb.append(", cusSource=").append(cusSource);
        sb.append(", cusProvince=").append(cusProvince);
        sb.append(", cusCity=").append(cusCity);
        sb.append(", cusRegion=").append(cusRegion);
        sb.append(", cusAddress=").append(cusAddress);
        sb.append(", cusRemark=").append(cusRemark);
        sb.append(", cusBusinessLicense=").append(cusBusinessLicense);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}