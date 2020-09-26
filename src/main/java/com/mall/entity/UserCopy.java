package com.mall.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "user_copy")
public class UserCopy implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;
    private static final long serialVersionUID = 1L;

}
