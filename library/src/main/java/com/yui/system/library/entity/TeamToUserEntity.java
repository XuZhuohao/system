package com.yui.system.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 组 到 用户 映射关系
 *
 * @author XuZhuohao
 * @date 2018/12/5
 */
@Setter
@Getter
@Entity
@Table(name = "team_to_user",indexes = {@Index(name="index_team2user_tid",columnList = "team_id")})
public class TeamToUserEntity extends BaseEntity  {
    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
