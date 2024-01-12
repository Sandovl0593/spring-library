package com.application.backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceSrc implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<BookModel> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Optional<BookModel> findByCode(String code) {
        return bookDAO.findByCode(code);
    }

    @Override
    public void registerBook(BookModel book) {  // no usado en la UI
        bookDAO.register(book);
    }

    @Override
    public List<BookModel> findBookByAuthor(String nameAuthor) {
        return bookDAO.findBookByAuthor(nameAuthor);
    }

    @Override
    public List<BookModel> findBookByGenero(String genero) {
        return bookDAO.findBookByGenero(genero);
    }

    @Override
    public void reduceUnits(Integer cant, String bookcode) {
        bookDAO.reduceUnits(cant, bookcode);
    }

    @Override
    public void addUnits(Integer cant, String bookcode) {
        bookDAO.addUnits(cant, bookcode);
    }
}
