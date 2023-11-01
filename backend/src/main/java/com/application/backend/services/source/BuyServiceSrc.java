package com.application.backend.services.source;

import com.application.backend.models.BuyModel;
import com.application.backend.persistence.source.BuyDAOSrc;
import com.application.backend.services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyServiceSrc implements BuyService {
    @Autowired
    private BuyDAOSrc buyDAO;

    @Override
    public List<BuyModel> findAll() {   // no usado en la UI
        return buyDAO.findAll();
    }

    @Override
    public Optional<BuyModel> findByVoucher(String voucher) {
        return buyDAO.findByVoucher(voucher);
    }

    @Override
    public void registerBuy(BuyModel buy) {
        buyDAO.register(buy);
    }

    @Override
    public List<BuyModel> findUserPurchase(String clientDni) {
        return buyDAO.findUserPurchase(clientDni);
    }
}
