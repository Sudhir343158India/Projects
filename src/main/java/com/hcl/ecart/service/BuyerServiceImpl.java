package com.hcl.ecart.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.hcl.ecart.dto.BuyerRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.entity.Buyer;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.repository.BuyerRepository;
import com.hcl.ecart.util.ApplicationUtil;
@Service
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	BuyerRepository buyerRepository;
//	@Autowired
//	ProductRepository productRepository;
	@Override
	
	public ResponseDto Buyer(BuyerRequestDto buyerRequestDto) throws EcartException {
		
	//Optional<List<Buyer>> productBuyer= buyerRepository.findByPName(buyerRequestDto.getPName());
		Optional<List<Buyer>>productBuyer=buyerRepository.findByPName(buyerRequestDto.getPName());
//		if(!productBuyer.isPresent()|| productBuyer.get().isEmpty())
//	throw new EcartException(ApplicationUtil.PRODUCT_NAME_VALIDATION_STATUS);
	
	if (productBuyer.get().get(0).getPstock() < buyerRequestDto.getPStock())
			throw new EcartException(ApplicationUtil.BALANCE_STATUS);
		if(productBuyer.get().get(0).getPstock()<= 0)
		throw new EcartException(ApplicationUtil.BALANCE_STATUS);

		productBuyer.get().get(0)
  	.setPstock(productBuyer.get().get(0).getPstock()-buyerRequestDto.getPStock());
//		
//		
	buyerRepository.save(productBuyer.get().get(0));
//		customerRegistrationRepository.save(userDetailstoAccNum.get().get(0));
//		
//		// enter buyer table
//
		Buyer buyer= new Buyer();	
	BeanUtils.copyProperties(buyerRequestDto, buyer);
    buyerRepository.save(buyer);
		ResponseDto reponseDto  = new ResponseDto ();
		reponseDto.setMessage(ApplicationUtil.TRANSACTION_STATUS);
		reponseDto.setStatusCode(HttpStatus.CREATED.value());
		return reponseDto;	
	//	return null;
	}

}
