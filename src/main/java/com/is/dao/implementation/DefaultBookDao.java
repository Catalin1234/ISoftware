package com.is.dao.implementation;

import com.is.dao.BookDao;
import com.is.dao.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * Created by blackghost on 1/18/2017.
 */
public class DefaultBookDao implements BookDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public List<Book> getAllBooks() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Book> listOfBooks = jdbcTemplate.query("select * from book", new BookRowMapper());
        return listOfBooks;
    }

    @Override
    public void deleteBook(int bookId){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String SQLCommand = "delete from book where bookId = " + bookId;
        jdbcTemplate.update(SQLCommand);
    }

    @Override
    public void addBook(Book book){
        String sql = "INSERT INTO book "
                + "(bookId, name, author, price) VALUES (?, ?, ?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,
                new Object[]{book.getBookId, book.getName, book.getAuthor, book.getPrice});
    }

    @Override
    public void updateBook(Book bookToBeUpdated){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("UPDATE book SET " + "name = ? , " +
                        "name = ?," +
                        " author = ?, " +
                        " price = ?," +
                        " WHERE bookId= ? ",
                bookToBeUpdated.getName(),
                bookToBeUpdated.getAuthor(),
                bookToBeUpdated.getPrice();
    }


}
