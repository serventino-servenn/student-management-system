package com.student_management_system.service;

import com.student_management_system.entity.Enrollment;
import com.student_management_system.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public Enrollment enrollStudent(Enrollment enrollment) {
        enrollment.setEnrollmentDate(LocalDate.now()); 
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getStudentEnrollments(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }
}
