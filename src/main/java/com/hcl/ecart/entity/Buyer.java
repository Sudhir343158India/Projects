package com.hcl.ecart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private  String pName;
	private double pstock;
	private long userId;
}
