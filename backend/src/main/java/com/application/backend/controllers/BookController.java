package com.application.backend.controllers;

import com.application.backend.controllers.dto.BookDTO;
import com.application.backend.models.BookModel;
import com.application.backend.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/all")  // get para mostrar la lista de libros
    public List<BookModel> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/getCode/{code}")  // get para mostrar el libro por code
    public ResponseEntity<?> getByDni(@PathVariable String code) {
        Optional<BookModel> findBook = bookService.findByCode(code);

        if (findBook.isPresent()) {
            BookModel book = findBook.get();
            BookDTO userDTO = BookDTO.builder().code(book.getCode())
                    .title(book.getTitle()).author(book.getAuthor())
                    .genero(book.getGenero()).editorial(book.getEditorial())
                    .num_pages(book.getNum_pages()).price(book.getPrice())
                    .units_stock(book.getUnits_stock())
                    .build();

            return ResponseEntity.ok(userDTO);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El libro no se encuentra");
    }

    @GetMapping("getAuthor/{author}")  // get para mostrar los libros del author esp.
    public List<BookModel> getBookByAuthor(@PathVariable String author) {
        return bookService.findBookByAuthor(author);
    }

    @GetMapping("getGenero/{genero}")  // get para mostrar los libros por genero
    public List<BookModel> getBookByGenero(@PathVariable String genero) {
        return bookService.findBookByGenero(genero);
    }
}
