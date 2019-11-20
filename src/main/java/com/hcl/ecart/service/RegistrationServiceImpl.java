package com.hcl.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ecart.dto.RegistrationRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.entity.Registration;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.repository.RegistrationRepo;
import com.hcl.ecart.util.ApplicationUtil;
import com.hcl.ecart.util.Validations;

@Service
public class RegistrationServiceImpl implements RegistrationService {
@Autowired
RegistrationRepo registrationRepo;

	@Override
	public ResponseDto Registration(RegistrationRequestDto registrationRequestDto) throws EcartException {
	
		Optional<List<Registration>> userMobile=registrationRepo.findByMobile(registrationRequestDto.getMobile());
		Optional<List<Registration>> userEmail=registrationRepo.findByEmail(registrationRequestDto.getEmail());
		if(userEmail.isPresent())
			throw new EcartException(ApplicationUtil.EMAIL_STATUS);
		if(!Validations.isValid(registrationRequestDto.getEmail()))
			throw new EcartException(ApplicationUtil.INVALID_EMAIL_STATUS);
		if(userMobile.isPresent())
			throw new EcartException(ApplicationUtil.EXITED_MOBILE_NUMBER_STATUS);
				if(!Validations.mobileValid(""+registrationRequestDto.getMobile()))
					throw new EcartException(ApplicationUtil.INVALID_MOBILE_NUMBER_STATUS);
				Registration registration = new Registration();
				 
					BeanUtils.copyProperties(registrationRequestDto, registration);
					registrationRepo.save(registration);
					ResponseDto responseDto=new ResponseDto();
						responseDto.setMessage(ApplicationUtil.REGISTRTION_STATUS);
				     	responseDto.setStatusCode(HttpStatus.CREATED.value());
						
				return  responseDto;
				
				
	}

}
