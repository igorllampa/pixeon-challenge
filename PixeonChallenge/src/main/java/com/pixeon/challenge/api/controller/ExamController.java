package com.pixeon.challenge.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
}
