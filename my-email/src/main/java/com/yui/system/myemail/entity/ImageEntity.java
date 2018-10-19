package com.yui.system.myemail.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author XuZhuohao
 * @date 2018/10/19
 */
@Setter
@Getter
@Entity(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String cid;
    @Column(nullable = false, length = 100)
    private String src;
/*    @JoinColumn(name = "email_id")
    private Long emailId;*/
}
