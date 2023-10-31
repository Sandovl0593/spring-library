package com.application.backend.repositories;

import com.application.backend.models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookModel, String> {

}