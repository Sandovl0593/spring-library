package com.application.backend.persistence;

import com.application.backend.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    List<BookModel> findAll();

    Optional<BookModel> findByCode(String code);

    List<BookModel> findByPriceInRange(Double minPrice, Double maxPrice);

    void save(BookModel book);

    void deleteByCode(String code);
}
