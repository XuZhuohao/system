package com.yui.system.image.common.util;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class Md5UtilTest {

    @Test
    public void encodeByMD5() throws IOException {
        boolean result;
        ClassPathResource cpr = new ClassPathResource("test/t1.jpg");
        File file = new File(cpr.getURL().getPath());
        result =  "900150983cd24fb0d6963f7d28e17f72".equals(Md5Util.encodeByMD5("abc").toLowerCase());
        result &= "AC2EF7E5F7FB4CF2B3AE2E82822BBEB5".equals(Md5Util.encodeByMD5(file));
        if (!result){
            throw new RuntimeException("测试不通过！！");
        }
    }

}