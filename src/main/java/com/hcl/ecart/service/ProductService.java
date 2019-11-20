package com.hcl.ecart.service;

import java.util.List;

import com.hcl.ecart.dto.ProductRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;

public interface ProductService {
public List<ResponseDto> ViewProductList(ProductRequestDto productRequestDto)throws EcartException;
	public ResponseDto Product(ProductRequestDto productRequestDto)throws EcartException;
}
