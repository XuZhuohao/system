package com.yui.system.library.repository;

import com.yui.system.library.entity.BookEntity;
import com.yui.system.library.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository
 *
 * @author XuZhuohao
 * @date 2018-12-01 14:43
 */
public interface RecordRepository extends JpaRepository<RecordEntity, Integer> {

}
