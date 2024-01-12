package com.application.backend.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuyDAO {
    @Autowired
    private BuyRepository buyRepository;

    public List<BuyModel> findAll() {
        return (List<BuyModel>) buyRepository.findAll();
    }

    public Optional<BuyModel> findByVoucher(String voucher) {
        return buyRepository.findById(voucher);
    }

    public void register(BuyModel buy) {
        buyRepository.save(buy);
    }

    public List<BuyModel> findUserPurchase(String clientDni) {
        return buyRepository.findUserPurchase(clientDni);
    }
}
