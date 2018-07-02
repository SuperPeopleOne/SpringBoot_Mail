package com.lenovo.dao;

import com.lenovo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@Service
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 不指定数据源使用默认数据源
     * @return
     */
     public List<Book> getList(){
         String sql = "select id,name,author from book";
         return (List<Book>)jdbcTemplate.query(sql, new RowMapper<Book>() {
             @Override
             public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                 Book book = new Book();
                 book.setId(resultSet.getLong("id"));
                 book.setName(resultSet.getString("name"));
                 book.setAuthor(resultSet.getString("author"));
                 return book;
             }
         });
     }
    /**
     * 指定数据源
     * 在对应的service进行指定;
     * @return
     */



}
