package com.yui.system.library.entity;

import com.alibaba.fastjson.JSON;
import com.yui.system.library.LibraryApplicationTests;
import com.yui.system.library.repository.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class EntityTest extends LibraryApplicationTests {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamToUserRepository teamToUserRepository;
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
    @Test
    public void testInsert(){
        TeamEntity teamEntity = new TeamEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setLoginId("test001");
        userEntity.setName("xxx");
        userEntity.setPassWord("mm");

        teamEntity.setName("test");
        teamEntity.setCaptain(userEntity);
        teamEntity.setLevel(1);

        this.userRepository.save(userEntity);
        this.teamRepository.save(teamEntity);
    }

    @Test
    @Transactional
    public void teamSelect(){
        System.out.println(this.userRepository.findAll().get(0).getMyTeams().get(0).getName());
    }

    @Test
    public void insertTeamToUser(){
        final UserEntity userEntity = this.userRepository.findAll().get(0);
        final TeamEntity teamEntity = this.teamRepository.findAll().get(0);
        TeamToUserEntity teamToUserEntity = new TeamToUserEntity();
        teamToUserEntity.setTeamEntity(teamEntity);
        teamToUserEntity.setUserEntity(userEntity);
        this.teamToUserRepository.save(teamToUserEntity);
    }

    @Test
    public void findTeamToUser(){
        final UserEntity userEntity = this.userRepository.findAll().get(0);
        final TeamEntity teamEntity = this.teamRepository.findAll().get(0);
        //findByUserEntity
        System.out.println(this.teamToUserRepository.findByTeamEntity(teamEntity).get(0).getTeamEntity().getName());
        System.out.println(this.teamToUserRepository.findByUserEntity(userEntity).get(0).getTeamEntity().getName());
    }
    @Test
    @Transactional
    public void findTeamAndUser(){
        final UserEntity userEntity = this.userRepository.findAll().get(0);
        System.out.println(userEntity.getInnerTeams().size());
        final TeamEntity teamEntity = this.teamRepository.findAll().get(0);
        teamEntity.getUsers().forEach(user -> System.out.println(JSON.toJSONString(user)));
    }
}