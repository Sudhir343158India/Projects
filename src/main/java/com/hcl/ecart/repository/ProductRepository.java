package com.hcl.ecart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<List<Product>> findByPName(String pName);
	
}
