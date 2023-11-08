package com.application.backend.controllers.dto;

import com.application.backend.models.BookModel;
import com.application.backend.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandDTO {

    private Integer id;
    private UserModel book_id;
    private BookModel owner;
    private Integer units;
}
