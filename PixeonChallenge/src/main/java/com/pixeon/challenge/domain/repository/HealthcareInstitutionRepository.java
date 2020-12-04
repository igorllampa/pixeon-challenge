package com.pixeon.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeon.challenge.domain.model.HealthcareInstitution;

public interface HealthcareInstitutionRepository extends JpaRepository<HealthcareInstitution, Long> {

}
