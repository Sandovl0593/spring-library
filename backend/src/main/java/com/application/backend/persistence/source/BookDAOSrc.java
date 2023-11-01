package com.application.backend.persistence.source;

import com.application.backend.models.BookModel;
import com.application.backend.persistence.IBookDAO;
import com.application.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAOSrc implements IBookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookModel> findAll() {
        return (List<BookModel>) bookRepository.findAll();
    }

    @Override
    public Optional<BookModel> findByCode(String code) {
        return bookRepository.findById(code);
    }

    @Override
    public List<BookModel> findBookByAuthor(String nameAuthor){
        return bookRepository.findBookByAuthor(nameAuthor);
    }

    @Override
    public List<BookModel> findBookByGenero(String genero){
        return bookRepository.findBookByGenero(genero);
    }
}
