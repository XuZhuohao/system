package com.yui.system.library.util;

import com.yui.system.library.LibraryApplicationTests;
import com.yui.system.library.param.SystemParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookInfoUtilTest extends LibraryApplicationTests {
    @Autowired
    SystemParam systemParam;
    @Test
    public void getBookInfoFromDouban() {
        System.out.println(BookInfoUtil.getBookInfoFromDouban(systemParam.getDoubanUrl(),9787538756371L));
    }
}