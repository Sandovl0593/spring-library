package com.server.backend.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "buy")
public class BuyModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

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

    BuyModel() {}

    public BuyModel(String id, UserModel client, BookModel book_id, Integer units, Timestamp time_buy, Integer refund_days) {
        this.id = id;
        this.client = client;
        this.book_id = book_id;
        this.units = units;
        this.time_buy = time_buy;
        this.refund_days = refund_days;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
