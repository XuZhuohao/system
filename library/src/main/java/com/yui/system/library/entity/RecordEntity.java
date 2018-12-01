package com.yui.system.library.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 记录实体
 *
 * @author XuZhuohao
 * @date 2018-12-01 15:50
 */
@Setter
@Getter
@Entity
@Table(name = "record", indexes = {@Index(name="index_record_user",columnList = "user_id"),
        @Index(name="index_record_book",columnList = "book_id")})
@EntityListeners({AuditingEntityListener.class})
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(columnDefinition = "tinyint default 1")
    private boolean isValid = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

}
