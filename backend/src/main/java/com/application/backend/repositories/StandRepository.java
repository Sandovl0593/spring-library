package com.application.backend.repositories;

import com.application.backend.models.StandModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends CrudRepository<StandModel, Integer> {

}