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
    public List<BookModel> findByPriceInRange(Double minPrice, Double maxPrice) {
        return bookDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(BookModel book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteByCode(String code) {
        bookDAO.deleteByCode(code);
    }
}
