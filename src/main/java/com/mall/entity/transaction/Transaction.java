package com.mall.entity.transaction;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Transaction implements Serializable {
    @ApiModelProperty(value = "ID主键")
    private Integer id;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "报价金额")
    private BigDecimal quotationMoney;

    @ApiModelProperty(value = "接单")
    private String receivingOrder;

    @ApiModelProperty(value = "报价人")
    private String offerer;

    @ApiModelProperty(value = "接收人")
    private String received;

    @ApiModelProperty(value = "报价时间")
    private Date quotationTime;

    @ApiModelProperty(value = "0删除1未删除")
    private Integer ifDelete=0;

    private static final long serialVersionUID = 1L;

    public Transaction() {
    }

    public Transaction( String customerName, BigDecimal quotationMoney, String receivingOrder, String offerer, String received, Date quotationTime, int ifDelete) {
        this.customerName = customerName;
        this.quotationMoney = quotationMoney;
        this.receivingOrder = receivingOrder;
        this.offerer = offerer;
        this.received = received;
        this.quotationTime = quotationTime;
        this.ifDelete = ifDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getQuotationMoney() {
        return quotationMoney;
    }

    public void setQuotationMoney(BigDecimal quotationMoney) {
        this.quotationMoney = quotationMoney;
    }

    public String getReceivingOrder() {
        return receivingOrder;
    }

    public void setReceivingOrder(String receivingOrder) {
        this.receivingOrder = receivingOrder;
    }

    public String getOfferer() {
        return offerer;
    }

    public void setOfferer(String offerer) {
        this.offerer = offerer;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public Date getQuotationTime() {
        return quotationTime;
    }

    public void setQuotationTime(Date quotationTime) {
        this.quotationTime = quotationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerName=").append(customerName);
        sb.append(", quotationMoney=").append(quotationMoney);
        sb.append(", receivingOrder=").append(receivingOrder);
        sb.append(", offerer=").append(offerer);
        sb.append(", received=").append(received);
        sb.append(", quotationTime=").append(quotationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}