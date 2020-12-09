package com.pixeon.challenge.api.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.api.response.Message;
import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.ExamRepository;
import com.pixeon.challenge.domain.repository.HealthcareInstitutionRepository;
import com.pixeon.challenge.domain.service.ExamService;
import com.pixeon.challenge.domain.service.HealthcareInstitutionService;

@RestController
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;
	
	@Autowired
	private HealthcareInstitutionService healthcareInstitutionService;
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST,
			        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> register(@RequestBody Exam exam) {
				
		HealthcareInstitution healthcareInstitution = healthcareInstitutionRepository.findById(exam.getHealthcareInstitution().getId()).get();				
		
		//Verify if the Healthcare Instituion have available Pixeon Coins to register a new exam
		if(healthcareInstitution.isPixeonCoinAvailable()) {		
			return ResponseEntity.ok(examService.register(exam));
		}else {
			Message msg = new Message();
			msg.setMessage("Not enough PixeonCoin Available to register a new exam. Please, contact us."); 
			return ResponseEntity.ok(msg);
		}
			
	}
	
	@GetMapping("/find/{idHealthcareInst}/{id}")
	public ResponseEntity<Object> findExam(@PathVariable Long idHealthcareInst, @PathVariable Long id) {
		
		
		Exam exam = examRepository.findById(id).get();
		HealthcareInstitution healthcareInstitution = healthcareInstitutionRepository.findById(exam.getHealthcareInstitution().getId()).get();		
		
		//Verify if the Exam HealthcareInstitution is the same of the requester
		if(exam.getHealthcareInstitution().getId() != idHealthcareInst) {						
			Message msg = new Message();
			msg.setMessage("The requested exam is not allowed to be retrieved. It belongs to another Healthcare Institution."); 
			return ResponseEntity.ok(msg);
		}
		
		//Verify first access to exam
		if(exam.getFirstAcess() == null) {
				
			//Verify if the Healthcare Instituion have available Pixeon Coins 
			if(healthcareInstitution.isPixeonCoinAvailable()) {
				
				//Charge a Pixeon Coin			
				healthcareInstitutionService.chargePixeonCoin(healthcareInstitution);
				
				//Fill First Acess with the timestamp			
				examService.updateFirstAccessToExam(exam);
				
			}else {
				Message msg = new Message();
				msg.setMessage("Not enough PixeonCoin Available to register a new exam. Please, contact us."); 
				return ResponseEntity.ok(msg);
			}
		}
													
		
		return ResponseEntity.ok(exam);
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<Exam> update(@Valid @PathVariable Long id, @RequestBody Exam exam){
		if(!examRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		exam.setId(id);
		exam = examRepository.save(exam);
		
		return ResponseEntity.ok(exam);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		if(!examRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		examService.remove(id);
		
		return ResponseEntity.ok(null);
	}
}
