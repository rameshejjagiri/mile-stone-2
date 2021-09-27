package com.memberdependentservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberdependentservice.models.Dependents;
import com.memberdependentservice.models.Members;
import com.memberdependentservice.repositories.DependentRepository;
import com.memberdependentservice.repositories.MemberRepo;

@Service
public class DependentIdGenerationService {

	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private DependentRepository dependentRepo;

	public int generateId() {
		int dependentId = 0;
		int generatedId = getRandomId();

		Optional<Dependents> findByDependentId = dependentRepo.findById(generatedId);
		Optional<Members> findById = memberRepo.findById(generatedId);

		if (findByDependentId.isPresent() || findById.isPresent()) {
			generateId();
		} else {
			dependentId = generatedId;
		}
		return dependentId;
	}

	int getRandomId() {
		int randomPIN = (int) (Math.random() * 900) + 100;
		return randomPIN;
	}

}
