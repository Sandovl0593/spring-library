package com.application.backend.repositories;

import com.application.backend.models.BookModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String> {

    @Query("SELECT b FROM BookModel b WHERE b.author like %?1%")
    List<BookModel> findBookByAuthor(String nameAuthor);

    @Query("SELECT b FROM BookModel b WHERE b.genero like %?1%")
    List<BookModel> findBookByGenero(String genero);
}