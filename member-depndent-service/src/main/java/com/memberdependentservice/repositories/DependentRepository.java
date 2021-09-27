package com.memberdependentservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.memberdependentservice.models.Dependents;
@Repository
public interface DependentRepository extends MongoRepository<Dependents, Integer> {

	Dependents findByDependentId(String dependentId);

}
