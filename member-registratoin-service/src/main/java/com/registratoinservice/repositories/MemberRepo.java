package com.registratoinservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.registratoinservice.models.Members;

@Repository
public interface MemberRepo extends MongoRepository<Members, Integer> {

	public Members findByMemberId(String memberId);

	public Members findById(String email);

	public Members findByEmail(String email);

}
