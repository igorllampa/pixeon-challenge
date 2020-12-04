package com.pixeon.challenge.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "healthcare_institution")
public class HealthcareInstitution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Size(max = 100)
	private String name; 
	
	@Size(max = 14)
	private String cnpj;
	
	//@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)		
	//private List<Exam> exams =  new ArrayList<>();
}
