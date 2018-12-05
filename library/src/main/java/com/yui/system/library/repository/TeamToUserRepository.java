package com.yui.system.library.repository;

import antlr.collections.impl.LList;
import com.yui.system.library.entity.TeamEntity;
import com.yui.system.library.entity.TeamToUserEntity;
import com.yui.system.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository
 *
 * @author XuZhuohao
 * @date 2018-12-01 14:43
 */
public interface TeamToUserRepository extends JpaRepository<TeamToUserEntity, Integer> {
    /**
     * 根据队伍id，查找映射关系
     * @param teamEntity teamEntity
     * @return teamToUser
     */
    List<TeamToUserEntity> findByTeamEntity(TeamEntity teamEntity);

    /**
     * 根据用户，查找映射关系
     * @param userEntity userEntity
     * @return teamToUser
     */
    List<TeamToUserEntity> findByUserEntity(UserEntity userEntity);
}
