package com.yui.system.myemail.repository;

import com.yui.system.myemail.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * email repository
 *
 * @author XuZhuohao
 * @date 2018/10/19
 */
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
