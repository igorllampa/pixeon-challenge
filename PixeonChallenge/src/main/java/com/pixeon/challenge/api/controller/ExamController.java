package com.pixeon.challenge.api.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pixeon.challenge.domain.model.Exam;
import com.pixeon.challenge.domain.repository.ExamRepository;
import com.pixeon.challenge.domain.service.ExamService;

@RestController
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST,
			        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Exam register(@RequestBody Exam exam) {
		return examService.register(exam);
	}
	
	@GetMapping("/list/{id}")
	public Optional<Exam> findExam(@PathVariable Long id) {
		return examRepository.findById(id);
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
	
	public ResponseEntity<Void> remove(@PathVariable Long id){
		if(!examRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		examService.remove(id);
		
		return ResponseEntity.noContent().build();
	}
}
