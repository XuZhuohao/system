package com.yui.system.myemail.controller;

import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.repository.EmailRepository;
import com.yui.system.myemail.repository.FileRepository;
import com.yui.system.myemail.repository.ImageRepository;
import com.yui.system.myemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 邮件请求controller
 *
 * @author XuZhuohao
 * @date 2018/10/22
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ImageRepository imageRepository;

    /**
     * 例子：
     * {
     * 	"content": "<html><body><h1>图片发送</h1><p></p><img src='cid:t1'></img><img src='cid:t2'></img></body></html>",
     * 	"files": [{
     * 		"fileName": "t1.jpg",
     * 		"path": "D:\\data\\t1.jpg"
     *        }, {
     * 		"fileName": "t2.jpg",
     * 		"path": "D:\\data\\t1.jpg"
     *    }],
     * 	"fromUser": "786725551@qq.com",
     * 	"images": [{
     * 		"cid": "t1",
     * 		"src": "D:\\data\\t1.jpg"
     *    }, {
     * 		"cid": "t2",
     * 		"src": "D:\\data\\t2.gif"
     *    }],
     * 	"send": false,
     * 	"subject": "邮件发送测试",
     * 	"toUser": "786725551@qq.com"
     * }
     * @param email
     * @return
     */
    @PostMapping("/send")
    public Map<String, Object> send(@RequestBody EmailEntity email) {
        Map<String, Object> result = new HashMap<>(16);
        if (email.getFiles() != null && email.getFiles().size() > 0) {
            fileRepository.saveAll(email.getFiles());
        }
        if (email.getImages() != null && email.getImages().size() > 0) {
            imageRepository.saveAll(email.getImages());
        }
        emailRepository.save(email);
        emailService.sendEmail(email);
        result.put("isSuccess", true);
        result.put("Msg", "");
        result.put("code", 1);
        return result;
    }

}
