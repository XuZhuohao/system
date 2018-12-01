package com.yui.system.library.repository;

import com.yui.system.library.entity.BookEntity;
import com.yui.system.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Repository
 *
 * @author XuZhuohao
 * @date 2018-12-01 14:43
 */
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    /**
     * 通过书名查找
     * @param name 名字
     * @return 书籍列表
     */
    List<BookEntity> findByName(String name);
    /**
     * 通过作者查找
     * @param author 作者
     * @return 书籍列表
     */
    List<BookEntity> findByAuthor(String author);
    /**
     * 通过用户查找
     * @param userEntity 用户
     * @return 书籍列表
     */
    List<BookEntity> findByUserEntity(UserEntity userEntity);

    /**
     * 根据创建时间进行删除
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    void deleteByCreateTimeIsBetween(Date startTime, Date endTime);

}
