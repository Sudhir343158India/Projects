package com.hcl.ecart.service;

import com.hcl.ecart.dto.RegistrationRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;

public interface RegistrationService {

	public ResponseDto Registration(RegistrationRequestDto registrationRequestDto)throws EcartException;
	
}
