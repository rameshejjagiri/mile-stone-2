package com.memberdependentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memberdependentservice.models.Dependents;
import com.memberdependentservice.services.DependentService;

@RestController
@RequestMapping("/dependent")
public class DependentController {

	@Autowired
	private DependentService dependentService;

	@PostMapping("/add-dependent")
	public ResponseEntity<?> addDependent(@RequestBody Dependents dependent) {
		Dependents addDependent = dependentService.addDependent(dependent);
		return addDependent == null ? new ResponseEntity<String>("Error while adding dependent", HttpStatus.BAD_REQUEST)
				: new ResponseEntity<Dependents>(addDependent, HttpStatus.OK);
	}

	@RequestMapping("/get-dependent-by-id/{dependentId}")
	public Dependents getDependentName(@PathVariable String dependentId) {
		Dependents dependent = dependentService.getDependentByDependentId(dependentId);
		return dependent;
	}

	@PutMapping("/update-dependent")
	public Dependents updateDependent(@RequestBody Dependents dependent) {
		dependent = dependentService.updateDependent(dependent);
		return dependent;
	}

}
