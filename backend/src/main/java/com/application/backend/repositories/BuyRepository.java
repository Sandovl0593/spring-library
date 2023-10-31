package com.application.backend.repositories;

import com.application.backend.models.BuyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends CrudRepository<BuyModel, String> {

}