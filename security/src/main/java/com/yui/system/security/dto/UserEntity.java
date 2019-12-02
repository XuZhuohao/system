package com.yui.system.security.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author XuZhuohao
 * @date 2019-12-02 22:07
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "user", schema = "system", catalog = "")
public class UserEntity extends BaseEntity {
    @Basic
    @Column(name = "login_id")
    private int loginId;
    @Basic
    @Column(name = "wx_openid")
    private String wxOpenid;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "password_isvaild")
    private byte passwordIsvaild;
    @Basic
    @Column(name = "status")
    private byte status;
    @Basic
    @Column(name = "user_info_id")
    private byte userInfoId;



}
