package com.pixeon.challenge.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.domain.model.HealthcareInstitution;
import com.pixeon.challenge.domain.repository.HealthcareInstitutionRepository;
import com.pixeon.challenge.domain.service.HealthcareInstitutionService;

@RestController
@RequestMapping("healthcareinstitution")
public class HealthcareInstitutionController {

	@Autowired
	private HealthcareInstitutionRepository healthcareInstitutionRepository;
	
	@Autowired
	private HealthcareInstitutionService healthcareInstitutionService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, 
	        		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HealthcareInstitution register(@RequestBody HealthcareInstitution healthcareInstitution) {
		return healthcareInstitutionService.register(healthcareInstitution);
	}
	
}
