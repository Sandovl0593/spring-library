package com.application.backend.services;

import com.application.backend.models.BuyModel;

import java.util.List;
import java.util.Optional;

public interface BuyService {

    List<BuyModel> findAll();  // no usado en la UI

    Optional<BuyModel> findByVoucher(String voucher);

    void registerBuy(BuyModel buy);

    List<BuyModel> findUserPurchase(String clientDni);

}
