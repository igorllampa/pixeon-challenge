package com.pixeon.challenge.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	public Exam register(Exam exam) {
		return examRepository.save(exam);
	}
	
	public void remove(Long id) {
		examRepository.deleteById(id);
	}
}
