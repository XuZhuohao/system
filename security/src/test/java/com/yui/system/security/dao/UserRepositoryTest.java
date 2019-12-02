package com.yui.system.security.dao;

import com.yui.system.security.SecurityApplicationTests;
import com.yui.system.security.dto.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends SecurityApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void insert(){
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("密码");
        userEntity.setLoginId(510);
        userEntity.setStatus((byte)1);
        userEntity.setPasswordIsvaild((byte)1);
        UserEntity save = userRepository.save(userEntity);
        System.out.println(save.getLoginId());
    }
}