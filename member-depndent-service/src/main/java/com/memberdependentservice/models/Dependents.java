package com.memberdependentservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dependents {
	@Id
	private int id;
	private String dependentId;
	private String dependentFirstName;
	private String dependentLastName;
	private String dependentDOB;
	private String memberId;

	public Dependents(int id, String dependentId, String dependentFirstName, String dependentLastName,
			String dependentDOB, String memberId) {
		super();
		this.id = id;
		this.dependentId = dependentId;
		this.dependentFirstName = dependentFirstName;
		this.dependentLastName = dependentLastName;
		this.dependentDOB = dependentDOB;
		this.memberId = memberId;
	}

	public Dependents() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDependentId() {
		return dependentId;
	}

	public void setDependentId(String dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentFirstName() {
		return dependentFirstName;
	}

	public void setDependentFirstName(String dependentFirstName) {
		this.dependentFirstName = dependentFirstName;
	}

	public String getDependentLastName() {
		return dependentLastName;
	}

	public void setDependentLastName(String dependentLastName) {
		this.dependentLastName = dependentLastName;
	}

	public String getDependentDOB() {
		return dependentDOB;
	}

	public void setDependentDOB(String dependentDOB) {
		this.dependentDOB = dependentDOB;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Dependents [id=" + id + ", dependentId=" + dependentId + ", dependentFirstName=" + dependentFirstName
				+ ", dependentLastName=" + dependentLastName + ", dependentDOB=" + dependentDOB + ", memberId="
				+ memberId + "]";
	}

}
