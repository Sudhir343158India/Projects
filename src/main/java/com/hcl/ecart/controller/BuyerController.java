package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.BuyerRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.service.BuyerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registration")

public class BuyerController {
	@Autowired
	BuyerService buyerService;

	@PostMapping("/buyer")
	public ResponseEntity<ResponseDto> Buyer(@RequestBody BuyerRequestDto buyerRequestDto)throws EcartException
	{
		ResponseDto response=buyerService.Buyer(buyerRequestDto);
		log.info("EcartController:: products buying.....");;	
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}