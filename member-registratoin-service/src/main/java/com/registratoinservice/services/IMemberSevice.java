package com.registratoinservice.services;

import com.registratoinservice.models.Members;

public interface IMemberSevice {

	Members save(Members member);

	boolean isUserExistsByEmail(String email);

}
