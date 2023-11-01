package com.application.backend.persistence;

import com.application.backend.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    List<BookModel> findAll();

    Optional<BookModel> findByCode(String code);

    void register(BookModel user);

    List<BookModel> findBookByAuthor(String nameAuthor);

    List<BookModel> findBookByGenero(String genero);

    void reduceUnits(Integer cant, String bookcode);
}
