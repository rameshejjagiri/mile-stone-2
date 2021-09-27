package com.memberdependentservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memberdependentservice.models.Dependents;
import com.memberdependentservice.repositories.DependentRepository;

@Service
public class DependentService {
	@Autowired
	private DependentRepository dependentRepo;
	@Autowired
	private DependentIdGenerationService dependentId;

	public Dependents addDependent(Dependents dependent) {
		int generateId = dependentId.generateId();
		dependent.setId(generateId);
		dependent.setDependentId("R-" + generateId);

		return dependentRepo.save(dependent);
	}

	public Dependents getDependentByDependentId(String dependentId) {

		return dependentRepo.findByDependentId(dependentId);
	}

	public Dependents updateDependent(Dependents dependent) {

		Optional<Dependents> findById = dependentRepo.findById(dependent.getId());

		if (findById.isPresent()) {

			dependent = dependentRepo.save(dependent);

		}
		return dependent;
	}

}
