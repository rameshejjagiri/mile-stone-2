package com.claimservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
public class MemberClaims {
	@Id
	private int id;
	private String cFirstName;
	private String cLastName;
	private String cAdmissionDate;
	private String cDischargeDate;
	private String cDob;
	private String cAmount;
	private String cProviderName;
	private String memberId;

	public MemberClaims(int id, String cFirstName, String cLastName, String cAdmissionDate, String cDischargeDate,
			String cDob, String cAmount, String cProviderName, String memberId) {
		super();
		this.id = id;
		this.cFirstName = cFirstName;
		this.cLastName = cLastName;
		this.cAdmissionDate = cAdmissionDate;
		this.cDischargeDate = cDischargeDate;
		this.cDob = cDob;
		this.cAmount = cAmount;
		this.cProviderName = cProviderName;
		this.memberId = memberId;
	}

	public MemberClaims() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcFirstName() {
		return cFirstName;
	}

	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}

	public String getcLastName() {
		return cLastName;
	}

	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}

	public String getcAdmissionDate() {
		return cAdmissionDate;
	}

	public void setcAdmissionDate(String cAdmissionDate) {
		this.cAdmissionDate = cAdmissionDate;
	}

	public String getcDischargeDate() {
		return cDischargeDate;
	}

	public void setcDischargeDate(String cDischargeDate) {
		this.cDischargeDate = cDischargeDate;
	}

	public String getcDob() {
		return cDob;
	}

	public void setcDob(String cDob) {
		this.cDob = cDob;
	}

	public String getcAmount() {
		return cAmount;
	}

	public void setcAmount(String cAmount) {
		this.cAmount = cAmount;
	}

	public String getcProviderName() {
		return cProviderName;
	}

	public void setcProviderName(String cProviderName) {
		this.cProviderName = cProviderName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "MemberClaims [id=" + id + ", cFirstName=" + cFirstName + ", cLastName=" + cLastName
				+ ", cAdmissionDate=" + cAdmissionDate + ", cDischargeDate=" + cDischargeDate + ", cDob=" + cDob
				+ ", cAmount=" + cAmount + ", cProviderName=" + cProviderName + ", memberId=" + memberId + "]";
	}

}
