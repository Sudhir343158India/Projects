package com.hcl.ecart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ecart.dto.ProductRequestDto;
import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.dto.ViewOrderResponseDto;
import com.hcl.ecart.entity.Product;
import com.hcl.ecart.exception.EcartException;
import com.hcl.ecart.repository.ProductRepository;
import com.hcl.ecart.util.ApplicationUtil;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ResponseDto Product(ProductRequestDto productRequestDto) throws EcartException {
		java.util.Optional<List<Product>>addProduct= productRepository.findByPName(productRequestDto.getPName());
       if(!addProduct.isPresent())
	throw new EcartException(ApplicationUtil.PRODUCT_NAME_VALIDATION_STATUS);
	
//	if (addProduct.get().get(0).getPStock() < productRequestDto.getPStock())
//			throw new EcartException(ApplicationUtil.BALANCE_STATUS);
//		if(addProduct.get().get(0).getPStock()<= 0)
//		throw new EcartException(ApplicationUtil.BALANCE_STATUS);

		addProduct.get().get(0).setPStock(addProduct.get().get(0).getPStock() + productRequestDto.getPStock());
//		
//		
	productRepository.save(addProduct.get().get(0));
//		customerRegistrationRepository.save(userDetailstoAccNum.get().get(0));
//		
//		// enter product table
//
		Product product= new Product();	
	BeanUtils.copyProperties(productRequestDto, product);
    productRepository.save(product);
		ResponseDto reponseDto  = new ResponseDto ();
		reponseDto.setMessage(ApplicationUtil.TRANSACTION_STATUS);
		reponseDto.setStatusCode(HttpStatus.CREATED.value());
		return reponseDto;	

		//return null;
	}

	@Override
	public List<ResponseDto> ViewProductList(ProductRequestDto productRequestDto) throws EcartException {
		List<ResponseDto> listproductResponse=new ArrayList<>();
	List<Repons> ProductList=productRepository.findAll() ;
		
		return null;
	}
}
