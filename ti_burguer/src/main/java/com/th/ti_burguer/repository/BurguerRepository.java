package com.th.ti_burguer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.th.ti_burguer.model.Burguer;

public interface BurguerRepository extends MongoRepository<Burguer, String> {

    
    
}
