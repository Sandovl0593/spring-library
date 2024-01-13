package com.application.backend.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {
    @Autowired
    private BuyDAO buyDAO;

    public List<BuyModel> findAll() {   // no usado en la UI
        return buyDAO.findAll();
    }

    public Optional<BuyModel> findByVoucher(String voucher) {
        return buyDAO.findByVoucher(voucher);
    }

    public void registerBuy(BuyModel buy) {
        buyDAO.register(buy);
    }

    public List<BuyModel> findUserPurchase(String clientDni) {
        return buyDAO.findUserPurchase(clientDni);
    }
}
