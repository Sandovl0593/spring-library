package com.application.backend.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "buy", schema = "sp_library")
public class BuyModel {

    @Id
    @Column(unique = true, nullable = false)
    private String boucher;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "dni", nullable = false)
    private UserModel client;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private BookModel book_id;

    @Column(nullable = false)
    private Integer units;

    @Column(nullable = false)
    private Timestamp time_buy;

    @Column(nullable = false)
    private Integer refund_days;

    public String getBoucher() {
        return boucher;
    }

    public void setBoucher(String boucher) {
        this.boucher = boucher;
    }

    public UserModel getClient() {
        return client;
    }

    public void setClient(UserModel client) {
        this.client = client;
    }

    public BookModel getBook_id() {
        return book_id;
    }

    public void setBook_id(BookModel book_id) {
        this.book_id = book_id;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Timestamp getTime_buy() {
        return time_buy;
    }

    public void setTime_buy(Timestamp time_buy) {
        this.time_buy = time_buy;
    }

    public Integer getRefund_days() {
        return refund_days;
    }

    public void setRefund_days(Integer refund_days) {
        this.refund_days = refund_days;
    }
}
