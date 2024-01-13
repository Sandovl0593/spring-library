package com.application.backend.buy;

import com.application.backend.book.BookModel;
import com.application.backend.user.UserModel;
import com.application.backend.book.BookService;
import com.application.backend.stand.StandService;
import com.application.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    BuyService buyService;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    @Autowired
    StandService standService;

    private BookModel currentBook;
    private UserModel currentUser;

    @GetMapping("/all")  // get para mostrar la lista de compras (no visible para UI)
    public ResponseEntity<?> getPurchases() {
        List<BuyDTO> purchases = buyService.findAll().stream()
                .map(buy -> BuyDTO.builder().boucher(buy.getBoucher())
                        .client(buy.getClient()).book_id(buy.getBook_id())
                        .units(buy.getUnits()).time_buy(buy.getTime_buy()).build()
                ).toList();
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/voucher/{voucher}")  // get para mostrar la boleta de compra
    public ResponseEntity<?> getByVoucher(@PathVariable String voucher) {
        Optional<BuyModel> purchase = buyService.findByVoucher(voucher);

        if (purchase.isPresent()) {
            BuyModel buy = purchase.get();
            BuyDTO buyDTO = BuyDTO.builder().boucher(buy.getBoucher())
                    .client(buy.getClient()).book_id(buy.getBook_id())
                    .units(buy.getUnits()).time_buy(buy.getTime_buy()).build();
            return ResponseEntity.ok(buyDTO);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al mostrar compra");
    }

    @PostMapping("/{bookcode}/{userdni}/{cant}")  // post para registrar una nueva compra
    public ResponseEntity<?> registerBuy(@PathVariable String bookcode, @PathVariable String userdni, @PathVariable Integer cant) {
        this.currentUser = userService.findByDni(userdni).get();
        this.currentBook = bookService.findByCode(bookcode).get();

        // generar voucher random si el caracter es distinto y unico
        Random rand = new Random();
        String randomVoucher = "P" + rand.nextInt(999999);
        while (buyService.findByVoucher(randomVoucher).isPresent())
            randomVoucher = "P" + rand.nextInt(999999);

        // tiempo actual
        Timestamp current_time = new Timestamp(new Date().getTime());

        try {
            this.bookService.reduceUnits(cant, bookcode);
            this.buyService.registerBuy(BuyModel.builder().boucher(randomVoucher)
                    .client(this.currentUser).book_id(this.currentBook)
                    .units(cant).time_buy(current_time).build());
            this.standService.addUnit(cant, bookcode, userdni);
            return ResponseEntity.status(HttpStatus.OK).body("Compra exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error durante la compra");
        }
    }

    @GetMapping("/view/{dni}")  // get para mostrar las compras de usuario en sesion (dni almacenada en Hook React)
    public ResponseEntity<?> getMyPurchases(@PathVariable String dni) {
        List<BuyDTO> purchases = buyService.findUserPurchase(dni).stream()
                .map(buy -> BuyDTO.builder().boucher(buy.getBoucher())
                        .client(buy.getClient()).book_id(buy.getBook_id())
                        .units(buy.getUnits()).time_buy(buy.getTime_buy()).build()
                ).toList();
        return ResponseEntity.ok(purchases);
    }

}
