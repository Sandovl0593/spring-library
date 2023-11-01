package com.application.backend.persistence.source;

import com.application.backend.models.BuyModel;
import com.application.backend.persistence.IBuyDAO;
import com.application.backend.repositories.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BuyDAOSrc implements IBuyDAO {
    @Autowired
    private BuyRepository buyRepository;

    @Override
    public List<BuyModel> findAll() {
        return (List<BuyModel>) buyRepository.findAll();
    }

    @Override
    public Optional<BuyModel> findByVoucher(String voucher) {
        return buyRepository.findById(voucher);
    }

    @Override
    public void register(BuyModel buy) {
        buyRepository.save(buy);
    }

    @Override
    public List<BuyModel> findUserPurchase(String clientDni) {
        return buyRepository.findUserPurchase(clientDni);
    }
}
