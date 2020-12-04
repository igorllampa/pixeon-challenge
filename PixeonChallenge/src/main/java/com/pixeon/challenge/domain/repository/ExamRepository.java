package com.pixeon.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeon.challenge.domain.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
