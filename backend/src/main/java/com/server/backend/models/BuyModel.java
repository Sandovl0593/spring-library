package com.server.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "buy")
public class BuyModel {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private String book_id;

    @Column(nullable = false)
    private Integer units;

    @Column(nullable = false)
    private String time_buy;

    @Column(nullable = false)
    private Integer refund_days;

    public BuyModel(String id, String client, String book_id, Integer units, String time_buy, Integer refund_days) {
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getTime_buy() {
        return time_buy;
    }

    public void setTime_buy(String time_buy) {
        this.time_buy = time_buy;
    }

    public Integer getRefund_days() {
        return refund_days;
    }

    public void setRefund_days(Integer refund_days) {
        this.refund_days = refund_days;
    }
}
