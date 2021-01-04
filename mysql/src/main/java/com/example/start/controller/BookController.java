package com.example.start.controller;

import com.example.start.pojo.Book;
import com.example.start.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @createDate: 2020/11/24
 * @author:
 */
@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookServiceImpl bookService;

  @GetMapping("/getAllBooks")
  public List<Book> getAllBooks(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
    List<Book> allBooks = bookService.getAllBooks(offset, limit);
    return allBooks;
  }

  @GetMapping("/selectOne/{id}")
  public Book selectOneBookbyId(@PathVariable Integer id){
    Book book = bookService.selectOneBookbyId(id);
    return book;
  }

  @RequestMapping(value = "/addBook",method = RequestMethod.POST)
  public boolean addBook(Book book){
    boolean result = bookService.addBook(book);
    return result;
  };

  @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
  public boolean updateBook(Book book){
    boolean result = false;
    if(book.getId()!=null) {
      result= bookService.updateBook(book);
    }
    return result;
  };
  @RequestMapping(value = "/deleteBook",method = RequestMethod.POST)
  public boolean deleteBook(@RequestParam("id") Integer id,@RequestParam("name") String name){
    boolean result = bookService.deleteBook(id, name);
    return result;
  };
}

