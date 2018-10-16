///*
//package com.yui.system.myemail.entity;
//
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.util.Date;
//
//*/
///**
// * 邮件实体类
// *
// * @author XuZhuohao
// * @date 2018/10/16
// *//*
//
//@Table(name = "Email")
//public class EmailEntityTemp {
//    */
///**
//     * 主键id
//     *//*
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    */
///**
//     * 发件人
//     *//*
//
//    @Basic
//    @Column(name = "from")
//    private String from;
//    */
///**
//     * 收件人
//     *//*
//
//    @Basic
//    @Column(name = "to")
//    private String to;
//    */
///**
//     * 主题
//     *//*
//
//    @Basic
//    @Column(name = "subject")
//    private String subject;
//    */
///**
//     * 内容
//     *//*
//
//    @Basic
//    @Column(name = "content")
//    private String content;
//    */
///**
//     * 插入图片，[srcId:patch,srcId:patch....]
//     *//*
//
//    @Basic
//    @Column(name = "images")
//    private String images;
//    */
///**
//     * 附件，[fileName:filePatch,...]
//     *//*
//
//    @Basic
//    @Column(name = "images")
//    private String files;
//    */
///**
//     * 回调地址
//     *//*
//
//    @Basic
//    @Column(name = "domain")
//    private String callbackDomain;
//
//
//    @CreatedDate
//    @Column(name = "create_time")
//    private Date createTime;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getImages() {
//        return images;
//    }
//
//    public void setImages(String images) {
//        this.images = images;
//    }
//
//    public String getFiles() {
//        return files;
//    }
//
//    public void setFiles(String files) {
//        this.files = files;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getCallbackDomain() {
//        return callbackDomain;
//    }
//
//    public void setCallbackDomain(String callbackDomain) {
//        this.callbackDomain = callbackDomain;
//    }
//}
//*/
