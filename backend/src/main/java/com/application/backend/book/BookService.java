package com.application.backend.book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookModel> findAll();

    Optional<BookModel> findByCode(String code);

    void registerBook(BookModel book);  // no usado en la UI

    List<BookModel> findBookByAuthor(String nameAuthor);

    List<BookModel> findBookByGenero(String genero);

    void reduceUnits(Integer cant, String bookcode);

    void addUnits(Integer cant, String bookcode);
}
