package com.application.backend.persistence;

import com.application.backend.models.BuyModel;

import java.util.List;
import java.util.Optional;

public interface IBuyDAO {

    List<BuyModel> findAll();

    Optional<BuyModel> findByVoucher(String voucher);

    void register(BuyModel buy);

    List<BuyModel> findUserPurchase(String clientDni);
}
