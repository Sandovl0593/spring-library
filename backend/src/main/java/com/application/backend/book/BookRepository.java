package com.application.backend.book;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String> {

    @Query("SELECT b FROM BookModel b WHERE b.author = ?1")
    List<BookModel> findBookByAuthor(String nameAuthor);

    @Query("SELECT b FROM BookModel b WHERE b.genero = ?1")
    List<BookModel> findBookByGenero(String genero);

    @Modifying
    @Query("UPDATE BookModel b SET b.units_stock = b.units_stock - ?1 WHERE b.code = ?2")
    void reduceUnits(Integer cant, String bookcode);

    @Modifying
    @Query("UPDATE BookModel b SET b.units_stock = b.units_stock + ?1 WHERE b.code = ?2")
    void addUnits(Integer cant, String bookcode);
}