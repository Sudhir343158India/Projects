package com.hcl.ecart.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegistrationRequestDto {
	
	private String userName;
	private String password;
	private long mobile;
	private String email;

}
