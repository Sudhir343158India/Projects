package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.dto.UserLoginRequestDto;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.service.UserLoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registration/{UsersLogin}")
public class UserLoginController {
	@Autowired 
	UserLoginService userLoginService;
	
	@PostMapping("/Login/")
	public ResponseEntity<ResponseDto> UserLogin(@RequestBody UserLoginRequestDto userLoginRequestDto )throws EcartException
	{
		ResponseDto response=userLoginService.UserLogin(userLoginRequestDto);
			log.info("EcartController:: Login Successfully.....");;
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
}
