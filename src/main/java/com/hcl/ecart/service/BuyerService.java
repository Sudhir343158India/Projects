package com.hcl.ecart.service;

import com.hcl.ecart.dto.BuyerRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.exception.EcartException;

public interface BuyerService {

	public ResponseDto Buyer(BuyerRequestDto buyerRequestDto)throws EcartException;
}
