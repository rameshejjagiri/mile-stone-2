package com.claimservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claimservice.models.MemberClaims;

@Repository
public interface MemberClaimsRepo extends MongoRepository<MemberClaims, Integer> {

}
