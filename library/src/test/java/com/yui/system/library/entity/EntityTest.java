package com.yui.system.library.entity;

import com.alibaba.fastjson.JSON;
import com.yui.system.library.LibraryApplicationTests;
import com.yui.system.library.repository.BookRepository;
import com.yui.system.library.repository.RecordRepository;
import com.yui.system.library.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EntityTest extends LibraryApplicationTests {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecordRepository recordRepository;
    @Test
    public void testBookAndUser(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("zz");
        bookEntity.setIntro("intro");
        bookEntity.setName("书");
        bookEntity.setPublisher("出版社");
        bookEntity.setTranslator("null");

        UserEntity userEntity = new UserEntity();
        userEntity.setLoginId("test1");
        userEntity.setName("admin");
        userEntity.setPassWord("password");
        List<BookEntity> books = new ArrayList<>();
        books.add(bookEntity);
        userEntity.setBooks(books);

        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setBookEntity(bookEntity);
        recordEntity.setUserEntity(userEntity);

        this.bookRepository.save(bookEntity);
        this.userRepository.save(userEntity);
        this.recordRepository.save(recordEntity);

        System.out.println(JSON.toJSONString(userEntity));
        System.out.println(JSON.toJSONString(bookEntity));
        System.out.println(JSON.toJSONString(bookEntity.getUserEntity()));
    }
    @Test
    public void testFind(){
        BookEntity book = this.bookRepository.findByName("书").get(0);
        System.out.println(book.getUserEntity());
    }
}