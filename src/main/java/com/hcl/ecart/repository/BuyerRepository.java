package com.hcl.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.hcl.ecart.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

	Optional<List<Buyer>>findByPName(String pName);
}
