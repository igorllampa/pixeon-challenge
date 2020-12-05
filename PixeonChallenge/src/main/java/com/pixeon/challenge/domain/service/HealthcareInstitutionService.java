package com.pixeon.challenge.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.HealthcareInstitutionRepository;

@Service
public class HealthcareInstitutionService {

	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;
	
	public HealthcareInstitution register(HealthcareInstitution healthcareInstitution) {
		
		healthcareInstitution.setTotalPixeonCoin(20);//Initialize total of Pixeon Coin with Default 20
		
		return healthcareInstitutionRepository.save(healthcareInstitution);
	}
	
	
	
}
