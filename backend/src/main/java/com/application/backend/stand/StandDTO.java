package com.application.backend.stand;

import com.application.backend.book.BookModel;
import com.application.backend.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandDTO {

    private Integer id;
    private BookModel book_id;
    private UserModel owner;
    private Integer units;
}
