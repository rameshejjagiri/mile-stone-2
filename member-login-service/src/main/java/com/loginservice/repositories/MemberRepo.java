package com.loginservice.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loginservice.models.Members;

@Repository
public interface MemberRepo extends MongoRepository<Members, Integer> {

	public Members findByMemberId(String memberId);

	public Members findById(String email);

	public Optional<Members> findByEmail(String email);

}
