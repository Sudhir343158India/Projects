package com.hcl.ecart.service;

import com.hcl.ecart.dto.ResponseDto;
import com.hcl.ecart.dto.UserLoginRequestDto;
import com.hcl.ecart.exception.EcartException;

public interface UserLoginService {
	public ResponseDto UserLogin(UserLoginRequestDto userLoginRequestDto )throws EcartException;
}
