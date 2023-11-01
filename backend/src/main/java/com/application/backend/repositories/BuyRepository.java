package com.application.backend.repositories;

import com.application.backend.models.BuyModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends CrudRepository<BuyModel, String> {

    @Query("SELECT b FROM BuyModel b WHERE b.client = ?1")
    List<BuyModel> findUserPurchase(String clientDni);

}