package com.application.backend.controllers.dto;

import com.application.backend.models.BookModel;
import com.application.backend.models.UserModel;

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
    private Integer refund_days;
}
