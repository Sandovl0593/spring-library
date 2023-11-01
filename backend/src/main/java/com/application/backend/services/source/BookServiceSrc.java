package com.application.backend.services.source;

import com.application.backend.models.BookModel;
import com.application.backend.persistence.source.BookDAOSrc;
import com.application.backend.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceSrc implements BookService {

    @Autowired
    private BookDAOSrc bookDAO;

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
}
