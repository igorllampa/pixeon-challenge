package com.pixeon.challenge.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(name = "total_pixeon_coin")
	private Integer totalPixeonCoin;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	public Integer getTotalPixeonCoin() {
		return totalPixeonCoin;
	}

	public void setTotalPixeonCoin(Integer totalPixeonCoin) {
		this.totalPixeonCoin = totalPixeonCoin;
	}

	public boolean isPixeonCoinAvailable() {
		
		
		if(this.getTotalPixeonCoin() != null && this.getTotalPixeonCoin() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthcareInstitution other = (HealthcareInstitution) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	public void chargePixeonCoin() {
		this.totalPixeonCoin--;
	}
	//@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)		
	//private List<Exam> exams =  new ArrayList<>();	
}
