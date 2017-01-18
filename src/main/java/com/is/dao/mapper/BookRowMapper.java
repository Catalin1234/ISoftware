package com.is.dao.mapper;

import com.is.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by blackghost on 1/18/2017.
 */
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int nrColumn) throws SQLException {
        Book b = new Book();
        b.setBookId(rs.getInt("bookId"));
        b.setName(rs.getString("name"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getFloat("price"));
        return b;
    }
}