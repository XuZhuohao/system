package com.yui.system.library.service;

import com.yui.system.library.entity.BookEntity;
import com.yui.system.library.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 书籍服务
 *
 * @author XuZhuohao
 * @date 2018-12-01 16:04
 */
public interface BookService {
    /**
     * 通过条形码图片添加书籍
     * @param barCode 条形码
     * @return boolean
     */
    boolean addBook(Long barCode);
    /**
     * 通过条形码图片添加书籍
     * @param imageFile 条形码
     * @return boolean
     */
    boolean addBook(MultipartFile imageFile);
    /**
     * 添加图书
     * @param bookEntity book
     * @return boolean
     */
    boolean addBook(BookEntity bookEntity);
    /**
     * 删除图书
     * @param bookEntity book
     * @return boolean
     */
    boolean deleteBook(BookEntity bookEntity);
    /**
     * 批量添加图书
     * @param bookEntities book
     * @return boolean
     */
    boolean addBooks(List<BookEntity> bookEntities);
    /**
     * 批量删除图书
     * @param bookEntities book
     * @return boolean
     */
    boolean deleteBooks(List<BookEntity> bookEntities);
    /**
     * 修改图书图书
     * @param bookEntity book
     * @return boolean
     */
    boolean updateBook(BookEntity bookEntity);

    /**
     * 通过书名寻找图书
     * @param bookName book
     * @return 图书
     */
    List<BookEntity> findBooksByName(String bookName);
    /**
     * 通过作者寻找图书
     * @param author 作者
     * @return 图书
     */
    List<BookEntity> findBooksByAuthor(String author);
    /**
     * 寻找图书
     * @param bookEntity bookEntity
     * @return 图书
     */
    List<BookEntity> findBooks(BookEntity bookEntity);

    /**
     * 通过作者寻找图书
     * @param userEntity 拥有者
     * @return 图书
     */
    List<BookEntity> findBooks(UserEntity userEntity);
}
