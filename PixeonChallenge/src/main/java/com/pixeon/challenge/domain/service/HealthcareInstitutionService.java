package com.pixeon.challenge.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.HealthcareInstitutionRepository;

@Service
public class HealthcareInstitutionService {

	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;
	
	public HealthcareInstitution register(HealthcareInstitution healthcareInstitution) {
		
		return healthcareInstitutionRepository.save(healthcareInstitution);
	}
}
