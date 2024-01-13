package com.application.backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<BookModel> findAll() {
        return bookDAO.findAll();
    }

    public Optional<BookModel> findByCode(String code) {
        return bookDAO.findByCode(code);
    }

    public void registerBook(BookModel book) {  // no usado en la UI
        bookDAO.register(book);
    }

    public List<BookModel> findBookByAuthor(String nameAuthor) {
        return bookDAO.findBookByAuthor(nameAuthor);
    }

    public List<BookModel> findBookByGenero(String genero) {
        return bookDAO.findBookByGenero(genero);
    }

    public void reduceUnits(Integer cant, String bookcode) {
        bookDAO.reduceUnits(cant, bookcode);
    }

    public void addUnits(Integer cant, String bookcode) {
        bookDAO.addUnits(cant, bookcode);
    }
}
