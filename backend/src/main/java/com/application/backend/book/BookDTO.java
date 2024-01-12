package com.application.backend.book;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private String code;
    private String title;
    private String author;
    private String genero;
    private String editorial;
    private Integer num_pages;
    private Double price;
    private Long units_stock;
}
