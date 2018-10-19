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
@Entity(name = "File")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fileName;
    @Column(nullable = false, length = 100)
    private String path;

//    private Long emailId;
}
