package com.pixeon.challenge.domain.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.ExamRepository;
import com.pixeon.challenge.domain.repository.HealthcareInstitutionRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private HealthcareInstitutionService healthcareInstitutionService;
	
	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;
	
	public Exam register(Exam exam) {
		
		exam = examRepository.save(exam);		
		
		//Charge a Pixeon Coin of the Healthcare Institution
		HealthcareInstitution healthcareInstitution;
		healthcareInstitution = exam.getHealthcareInstitution();				
		healthcareInstitution = healthcareInstitutionRepository.getOne(healthcareInstitution.getId());
		healthcareInstitution.chargePixeonCoin();
		healthcareInstitutionRepository.save(healthcareInstitution);
				
		return exam;
	}
	
	public void remove(Long id) {
		examRepository.deleteById(id);
	}
	
	public void updateFirstAccessToExam(Exam exam) {
		
		exam.setFirstAcess(LocalDateTime.now());
		
		examRepository.save(exam);			
	}
}
