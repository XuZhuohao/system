package com.yui.system.myemail.repository;

import com.yui.system.myemail.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * file repository
 *
 * @author XuZhuohao
 * @date 2018/10/19
 */
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
