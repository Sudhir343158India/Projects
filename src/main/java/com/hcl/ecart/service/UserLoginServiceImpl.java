package com.hcl.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.dto.UserLoginRequestDto;
import com.hcl.ecart.entity.Registration;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.repository.RegistrationRepo;
import com.hcl.ecart.util.ApplicationUtil;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	RegistrationRepo registrationRepo;

	@Override
	public ResponseDto UserLogin(UserLoginRequestDto userLoginRequestDto) throws EcartException {
	Optional<List<Registration>> userLogin=registrationRepo.findByMobileAndPassword(userLoginRequestDto.getMobile(), userLoginRequestDto.getPassword());
	Optional<List<Registration>> userPasswordEncrypt=registrationRepo.findByPassword(userLoginRequestDto.getPassword());
	if(!userLogin.isPresent())
			throw new EcartException(ApplicationUtil.INVALID_LOGIN_STATUS);
	if(!userPasswordEncrypt.isPresent())
		throw new EcartException(ApplicationUtil.INVALID_LOGIN_STATUS);
		
		ResponseDto loginresponseDto= new ResponseDto();
		//loginresponseDto.setUserId(userLogin.get().get(0).getUserId());
		loginresponseDto.setMessage(ApplicationUtil.LOGIN_STATUS);
     	loginresponseDto.setStatusCode(HttpStatus.CREATED.value());
		return loginresponseDto;
		
	}
	
}
