package com.application.backend.controllers;

import com.application.backend.controllers.dto.BookDTO;
import com.application.backend.models.BookModel;
import com.application.backend.services.source.BookServiceSrc;
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
    BookServiceSrc bookService;

    @GetMapping("/all")  // get para mostrar la lista de libros
    public ResponseEntity<?> getBooks() {
        List<BookDTO> books = bookService.findAll().stream()
                .map(book -> BookDTO.builder().code(book.getCode())
                        .title(book.getTitle()).author(book.getAuthor())
                        .genero(book.getGenero()).editorial(book.getEditorial())
                        .num_pages(book.getNum_pages()).price(book.getPrice())
                        .units_stock(book.getUnits_stock())
                        .build()
                ).toList();
        return ResponseEntity.ok(books);
    }

    @PostMapping()


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
    public ResponseEntity<?> getBookByAuthor(@PathVariable String author) {
        List<BookDTO> books = bookService.findBookByAuthor(author).stream()
                .map(book -> BookDTO.builder().code(book.getCode())
                        .title(book.getTitle()).author(book.getAuthor())
                        .genero(book.getGenero()).editorial(book.getEditorial())
                        .num_pages(book.getNum_pages()).price(book.getPrice())
                        .units_stock(book.getUnits_stock())
                        .build()
                ).toList();
        return ResponseEntity.ok(books);
    }

    @GetMapping("getGenero/{genero}")  // get para mostrar los libros por genero
    public ResponseEntity<?> getBookByGenero(@PathVariable String genero) {
        List<BookDTO> books = bookService.findBookByGenero(genero).stream()
                .map(book -> BookDTO.builder().code(book.getCode())
                        .title(book.getTitle()).author(book.getAuthor())
                        .genero(book.getGenero()).editorial(book.getEditorial())
                        .num_pages(book.getNum_pages()).price(book.getPrice())
                        .units_stock(book.getUnits_stock())
                        .build()
                ).toList();
        return ResponseEntity.ok(books);
    }
}
