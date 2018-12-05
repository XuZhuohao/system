package com.yui.system.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 组
 *
 * @author XuZhuohao
 * @date 2018/12/5
 */
@Setter
@Getter
@Entity
@Table(name = "team", indexes = {@Index(name = "index_team_name",columnList = "name")})
public class TeamEntity extends BaseEntity {
    @Column(length = 100, nullable = false)
    private String name;
    @Column(columnDefinition = "tinyint")
    private int level;
    @ManyToOne
    @JoinColumn(name = "captain")
    private UserEntity captain;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<TeamToUserEntity> users;
}
