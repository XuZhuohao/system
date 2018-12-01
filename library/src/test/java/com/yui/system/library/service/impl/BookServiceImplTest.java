package com.yui.system.library.service.impl;

import com.alibaba.fastjson.JSON;
import com.yui.system.library.LibraryApplicationTests;
import com.yui.system.library.entity.BookEntity;
import com.yui.system.library.repository.BookRepository;
import com.yui.system.library.repository.UserRepository;
import com.yui.system.library.service.BookService;
import com.yui.system.library.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest extends LibraryApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

/*    @Test
    @Transactional
    @Rollback(false)
    public void clearTestDate(){
        bookRepository.deleteByCreateTimeIsBetween(DateUtil.getDate("2018-12-02 07:03:11","yyyy-MM-dd hh:mm:ss"),
                DateUtil.getDate("2018-12-02 07:03:20","yyyy-MM-dd hh:mm:ss"));
    }*/

    @Test
    public void addBookByBarcode() {
        /**
         * 了不起的盖茨比
         */
        JSON.toJSONString(bookService.addBook(9787538756371L));
    }


    @Test
    public void addBookByBookEntity() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("xuzhuohao");
        bookEntity.setIntro("简介");
        bookEntity.setName("t1");
        bookEntity.setPublisher("出版社1");
        bookEntity.setTranslator("");
        bookService.addBook(bookEntity);
    }

    @Test
    public void deleteBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("删除");
        bookEntity.setIntro("删除");
        bookEntity.setName("删除");
        bookEntity.setPublisher("删除");
        bookEntity.setTranslator("");
        bookService.addBook(bookEntity);
        bookEntity.setAuthor("");
        bookService.deleteBook(bookEntity);
    }

    @Test
    public void addBooks() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("xuzhuohao");
        bookEntity.setIntro("简介01");
        bookEntity.setName("t01");
        bookEntity.setPublisher("出版社01");
        bookEntity.setTranslator("");
        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setAuthor("xuzhuohao");
        bookEntity2.setIntro("简介02");
        bookEntity2.setName("t02");
        bookEntity2.setPublisher("出版社02");
        bookEntity2.setTranslator("");
        List<BookEntity> bookEntities = new ArrayList<>(16);
        bookEntities.add(bookEntity);
        bookEntities.add(bookEntity2);
        bookService.addBooks(bookEntities);
    }

    @Test
    public void deleteBooks() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor("删除01");
        bookEntity.setIntro("删除01");
        bookEntity.setName("删除01");
        bookEntity.setPublisher("删除01");
        bookEntity.setTranslator("");
        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setAuthor("删除02");
        bookEntity2.setIntro("删除02");
        bookEntity2.setName("删除02");
        bookEntity2.setPublisher("删除02");
        bookEntity2.setTranslator("");
        List<BookEntity> bookEntities = new ArrayList<>(16);
        bookEntities.add(bookEntity);
        bookEntities.add(bookEntity2);
        bookService.deleteBooks(bookEntities);
    }

    @Test
    public void updateBook() {
        BookEntity book = bookService.findBooksByName("书").get(0);
        book.setBarcode(110L);
        bookService.updateBook(book);
    }

    @Test
    public void findBooksByName() {
        bookService.findBooksByName("书").forEach(bookEntity -> System.out.println(bookEntity.getName()));
    }

    @Test
    public void findBooksByAuthor() {
        bookService.findBooksByAuthor("zz").forEach(bookEntity -> System.out.println(bookEntity.getName()));
    }

    @Test
    public void findBooksByUserEntity() {
        bookService.findBooks(userRepository.findById(1).get()).forEach(bookEntity -> System.out.println(bookEntity.getName()));
    }

    @Test
    public void findBooksByBookEntity() {
        bookService.findBooks(bookService.findBooksByName("书").get(0)).forEach(bookEntity -> System.out.println(bookEntity.getName()));
    }
}