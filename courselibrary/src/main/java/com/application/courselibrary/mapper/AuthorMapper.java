package com.application.courselibrary.mapper;

import com.application.courselibrary.entity.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Select("SELECT * FROM authors WHERE id = #{id}")
    Author findById(Long id);

    @Select("SELECT * FROM authors")
    List<Author> findAll();
}
