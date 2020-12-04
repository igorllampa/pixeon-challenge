package com.pixeon.challenge.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 100)
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "patient_age")
	private Integer patientAge;
	
	@ManyToOne
	@JoinColumn(name = "id_healthcareinstitution")
	private HealthcareInstitution healthcareInstitution;
	
	@Column(name = "patient_gender")
	@Size(max = 1)
	private String patientGender; 
	 
	@Column(name = "physician_name")
	@Size(max = 100)
	private String physicianName;   
	 
	@Column(name = "physician_crm")
	@Size(max = 50)
	private String physicianCrm;
	  
	@Column(name = "procedure_name")
	@Size(max = 250)
	private String procedureName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public HealthcareInstitution getHealthcareInstitution() {
		return healthcareInstitution;
	}

	public void setHealthcareInstitution(HealthcareInstitution healthcareInstitution) {
		this.healthcareInstitution = healthcareInstitution;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianCrm() {
		return physicianCrm;
	}

	public void setPhysicianCrm(String physicianCrm) {
		this.physicianCrm = physicianCrm;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
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
		Exam other = (Exam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 		
	
	
}
