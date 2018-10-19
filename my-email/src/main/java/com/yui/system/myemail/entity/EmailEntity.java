package com.yui.system.myemail.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 邮件实体类
 *
 * @author XuZhuohao
 * @date 2018/10/16
 */
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "email")
public class EmailEntity {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 发件人
     */
    @Column(nullable = false, length = 100)
    private String fromUser;
    /**
     * 收件人
     */
    @Column(nullable = false, length = 100)
    private String toUser;
    /**
     * 主题
     */
    @Column(nullable = false)
    private String subject;
    /**
     * 内容
     */
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    /**
     * 插入图片
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_id")
    private Set<ImageEntity> images;
    /**
     * TODO: FetchType.LAZY会有问题，请研究 org.hibernate.LazyInitializationException: failed to lazily initialize a col
     *
     * TODO:使用list会出现 cannot simultaneously fetch multiple bags
     * 附件
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_id")
    private Set<FileEntity> files;
    /**
     * 回调地址
     */
    private String callbackDomain;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 是否发送成功
     */
    private boolean isSend;
}
