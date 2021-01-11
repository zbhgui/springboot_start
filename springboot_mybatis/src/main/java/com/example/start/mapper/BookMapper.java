package com.example.start.mapper;

import com.example.start.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @createDate: 2020/11/24
 * @author:
 */
@Mapper
public interface BookMapper {

  public List<Book> getAllBooks(@Param("offset") int offset, @Param("limit") int limit);

  public Book selectOneBookbyId(Integer bookId);

  public boolean addBook(Book book);

  public boolean updateBook(Book book);

  public boolean deleteBook(@Param("id") Integer id, @Param("name") String name);
}
