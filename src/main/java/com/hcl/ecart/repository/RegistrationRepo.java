package com.hcl.ecart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecart.entity.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
	
	Optional<List<Registration>>findByMobile(long mobile);
	Optional<List<Registration>>findByEmail(String email);
	Optional<List<Registration>>findByMobileAndPassword(long mobile, String password);
	Optional<List<Registration>>findByPassword(String password);
}
