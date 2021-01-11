package com.example.start.service;

import com.example.start.mapper.BookMapper;
import com.example.start.pojo.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @createDate: 2020/11/24
 * @author:
 */
@Service
public class BookServiceImpl {
  @Resource
  private BookMapper bookMapper;

  public List<Book> getAllBooks(int offset, int limit){
    List<Book> allBooks = bookMapper.getAllBooks(offset, limit);
    return allBooks;
  }

  public Book selectOneBookbyId(Integer id){
    Book book = bookMapper.selectOneBookbyId(id);
    return book;
  }

  public boolean addBook(Book book){
    boolean result = bookMapper.addBook(book);
    return result;
  };

  public boolean updateBook(Book book){
    boolean result = false;
    if(book.getId()!=null) {
      result= bookMapper.updateBook(book);
    }
    return result;
  };

  public boolean deleteBook(Integer id,String name){
    boolean result = bookMapper.deleteBook(id, name);
    return result;
  };
}
