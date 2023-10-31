package com.application.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book", schema = "sp_library")
public class BookModel {

    @Id
    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String editorial;

    @Column(nullable = false)
    private Integer num_pages;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Long units_stock;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String lastname) {
        this.author = lastname;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String email) {
        this.genero = email;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String password) {
        this.editorial = password;
    }

    public Integer getNum_pages() {
        return num_pages;
    }

    public void setNum_pages(Integer num_pages) {
        this.num_pages = num_pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUnits_stock() {
        return units_stock;
    }

    public void setUnits_stock(Long units_stock) {
        this.units_stock = units_stock;
    }
}
