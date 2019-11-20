package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.RegistrationRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired 
	RegistrationService registrationService;
	
	@PostMapping("/Users")

	public ResponseEntity<ResponseDto> Registration(@RequestBody RegistrationRequestDto registrationRequestDto )throws EcartException
	{
	ResponseDto response=registrationService.Registration(registrationRequestDto);
		log.info("EcartController:: User Registration.....");;
			
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	
	}

	
}
