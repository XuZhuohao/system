package com.yui.system.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 用户
 *
 * @author XuZhuohao
 * @date 2018-12-01 14:22
 */
@Setter
@Getter
@Entity
@Table(name = "user",indexes = {@Index(unique = true, name = "unique_user_loginId", columnList = "loginId")})
public class UserEntity extends BaseEntity {
    /**
     * 名字
     */
    @Column(length = 100, nullable = false)
    private String name;
    /**
     * loginId
     */
    @Column(length = 20, nullable = false)
    private String loginId;

    /**
     * 密码
     */
    @Column(length = 32, nullable = false)
    private String passWord;


    /**
     * 懒加载数据的使用，需要保证主查询session(数据库连接会话)的生命周期没有结束，
     * 在使用方法上添加注解@Transactional
     * OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<BookEntity> books;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "captain")
    private List<TeamEntity> myTeams;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<TeamToUserEntity> innerTeams;

}
