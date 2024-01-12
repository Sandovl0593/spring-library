package com.application.backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll() {
        return (List<BookModel>) bookRepository.findAll();
    }

    public Optional<BookModel> findByCode(String code) {
        return bookRepository.findById(code);
    }

    public List<BookModel> findBookByAuthor(String nameAuthor){
        return bookRepository.findBookByAuthor(nameAuthor);
    }

    public void register(BookModel user) {
        bookRepository.save(user);
    }

    public List<BookModel> findBookByGenero(String genero){
        return bookRepository.findBookByGenero(genero);
    }

    public void reduceUnits(Integer cant, String bookcode) {
        bookRepository.reduceUnits(cant, bookcode);
    }

    public void addUnits(Integer cant, String bookcode) {
        bookRepository.addUnits(cant, bookcode);
    }
}
