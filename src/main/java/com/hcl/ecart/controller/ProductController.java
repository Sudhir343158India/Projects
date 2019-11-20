package com.hcl.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecart.dto.ProductRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/adding")
		public ResponseEntity<ResponseDto> Product(@RequestBody ProductRequestDto productRequestDto)throws EcartException{
			
		ResponseDto response=productService.Product(productRequestDto);
			log.info("EcartController:: Add products to Stock.....");;
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	
	@GetMapping("/Viewallproducts")
	public ResponseEntity<List<ResponseDto>> Product()
	
}
