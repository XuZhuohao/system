package com.yui.system.security.dao;

import com.yui.system.security.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XuZhuohao
 * @date 2019-12-02 22:12
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
