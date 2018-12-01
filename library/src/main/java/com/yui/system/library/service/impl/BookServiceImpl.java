package com.yui.system.library.service.impl;

import com.yui.system.library.entity.BookEntity;
import com.yui.system.library.entity.UserEntity;
import com.yui.system.library.exception.BaseRuntimeException;
import com.yui.system.library.param.SystemParam;
import com.yui.system.library.repository.BookRepository;
import com.yui.system.library.result.BaseResult;
import com.yui.system.library.service.BookService;
import com.yui.system.library.util.BarcodeScan;
import com.yui.system.library.util.BookInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * BookService 实现类
 *
 * @author XuZhuohao
 * @date 2018-12-01 16:28
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    SystemParam systemParam;

    @Autowired
    BookRepository bookRepository;

    @Override
    public boolean addBook(Long barcode) {
        BookEntity bookEntity;
        try{
            bookEntity = BookInfoUtil.getBookEntityFromDouban(systemParam.getDoubanUrl(), barcode);
        } catch (Exception e){
            throw new BaseRuntimeException(new BaseResult().getFailResult("获取文本信息失败").setDate("barcode",barcode));
        }
        this.bookRepository.save(bookEntity);
        return true;
    }

    @Override
    public boolean addBook(MultipartFile imageFile) {
        try {
            String barcode = BarcodeScan.getQRresult(imageFile.getInputStream());
            this.addBook(Long.valueOf(barcode));
        } catch (IOException e) {
            throw new BaseRuntimeException(new BaseResult().getFailResult("获取条形码失败"));
        }
        return false;
    }

    @Override
    public boolean addBook(BookEntity bookEntity) {
        this.bookRepository.save(bookEntity);
        return true;
    }

    @Override
    public boolean deleteBook(BookEntity bookEntity) {
        bookEntity.setDelete(true);
        this.bookRepository.save(bookEntity);
        return true;
    }

    @Override
    public boolean addBooks(List<BookEntity> bookEntities) {
        this.bookRepository.saveAll(bookEntities);
        return true;
    }

    @Override
    public boolean deleteBooks(List<BookEntity> bookEntities) {
        bookEntities.forEach(bookEntity -> bookEntity.setDelete(true));
        this.bookRepository.saveAll(bookEntities);
        return false;
    }

    @Override
    public boolean updateBook(BookEntity bookEntity) {
        this.bookRepository.save(bookEntity);
        return false;
    }

    @Override
    public List<BookEntity> findBooksByName(String bookName) {
        return this.bookRepository.findByName(bookName);
    }

    @Override
    public List<BookEntity> findBooksByAuthor(String author) {
        return this.bookRepository.findByAuthor(author);
    }

    @Override
    public List<BookEntity> findBooks(BookEntity bookEntity) {
        Example<BookEntity> example = Example.of(bookEntity);
        return this.bookRepository.findAll(example);
    }

    @Override
    public List<BookEntity> findBooks(UserEntity userEntity) {
        return this.bookRepository.findByUserEntity(userEntity);
    }
}
