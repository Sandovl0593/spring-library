package com.application.backend.repositories;

import com.application.backend.models.BookModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String> {

    @Query("SELECT b FROM BookModel b WHERE b.price BETWEEN ?1 AND ?2")
    List<BookModel> findByPriceInRange(Double minPrice, Double maxPrice);
}