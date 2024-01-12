package com.application.backend.buy;

import com.application.backend.book.BookModel;
import com.application.backend.user.UserModel;

import lombok.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyDTO {

    private String boucher;
    private UserModel client;
    private BookModel book_id;
    private Integer units;
    private Timestamp time_buy;
}
