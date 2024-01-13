package com.application.backend.stand;

import com.application.backend.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stand")
public class StandControlller {
    @Autowired
    StandService standService;
    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<?> getStand() {
        List<StandDTO> stands = standService.findAll().stream()
                .map(stand -> StandDTO.builder().id(stand.getId()).book_id(stand.getBook_id())
                        .owner(stand.getOwner()).units(stand.getUnits()).build()).toList();
        return ResponseEntity.ok(stands);
    }

    @GetMapping("/{userdni}")
    public ResponseEntity<?> getByUser(@PathVariable String userdni) {
        List<StandDTO> yourBooks = standService.findByUser(userdni).stream()
                .map(stand -> StandDTO.builder().id(stand.getId()).book_id(stand.getBook_id())
                        .owner(stand.getOwner()).units(stand.getUnits()).build()).toList();

        return ResponseEntity.ok(yourBooks);
    }

    @PostMapping("/add/{userdni}/{book}/{cant}")
    public ResponseEntity<?> addUserbook(@PathVariable String userdni, @PathVariable String book, @PathVariable Integer cant) {
        try {
            this.standService.addUnit(cant, userdni, book);
            this.bookService.reduceUnits(cant, book);
            return ResponseEntity.status(HttpStatus.OK).body("Libro almacenado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error cuando se almacena");
        }
    }

    @PostMapping("/refund/{userdni}/{book}/{cant}")
    public ResponseEntity<?> refundBook(@PathVariable String userdni, @PathVariable String book, @PathVariable Integer cant) {
        try {
            this.standService.refunding(cant, userdni, book);
            this.bookService.addUnits(cant, book);
            return ResponseEntity.status(HttpStatus.OK).body("Libro reembolsado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error durante el reembolso");
        }
    }
}
