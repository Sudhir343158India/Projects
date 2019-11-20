package com.hcl.ecart.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserLoginRequestDto {
	private String password;
	private long mobile;
}
