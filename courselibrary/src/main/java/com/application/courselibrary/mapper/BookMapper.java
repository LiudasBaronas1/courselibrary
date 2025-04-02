package com.application.courselibrary.mapper;

import com.application.courselibrary.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM books WHERE id = #{id}")
    Book getBookById(Long id);

    @Select("SELECT * FROM books")
    List<Book> getAllBooks();
}
