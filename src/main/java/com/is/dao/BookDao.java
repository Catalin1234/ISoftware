package com.is.dao;

import com.is.model.Book;

import java.util.List;

/**
 * Created by blackghost on 1/18/2017.
 */
public interface BookDao {
    List<Book> getAllBooks();

    void deleteBook(int bookId);

    void addBook(Book book);

    void updateBook(Book bookToBeUpdated);
}
