package com.yui.system.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 书籍实体
 *
 * @author XuZhuohao
 * @date 2018-12-01 13:56
 */
@Setter
@Getter
@Entity
@Table(name = "book",
        indexes = {@Index(name = "index_book_name", columnList = "name"),
                @Index(name = "index_book_author", columnList = "author")})
public class BookEntity extends BaseEntity {
    /**
     * 名字
     */
    @Column(length = 100, nullable = false)
    private String name;
    /**
     * 作者
     */
    @Column(length = 100, nullable = false)
    private String author;
    /**
     * 出版社
     */
    @Column(length = 100, nullable = false)
    private String publisher;
    /**
     * 译者
     */
    @Column(length = 100)
    private String translator;
    /**
     * 简介
     */
    @Column(columnDefinition = "text")
    private String intro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    private Long barcode;
    /**
     * isbn-10
     */
    @Column(length = 20)
    private String isbn10;
    /**
     * isbn-13
     */
    @Column(length = 20)
    private String isbn13;
}
