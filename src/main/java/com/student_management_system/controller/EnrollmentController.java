package com.student_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_management_system.entity.Enrollment;
import com.student_management_system.service.EnrollmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/enrollments")
@Tag(name = "Enrollment Management", description = "Endpoints for managing student course enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    @Operation(summary = "Enroll a student in a course", description = "Creates a new enrollment record for a student and course.")
    public ResponseEntity<Enrollment> enrollStudent(@Valid @RequestBody Enrollment enrollment) {
        // Business logic for "Self-Service" enrollment or Admin assignment
        Enrollment savedEnrollment = enrollmentService.enrollStudent(enrollment);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get student's academic record", description = "Retrieves all courses a specific student is enrolled in.")
    public ResponseEntity<List<Enrollment>> getStudentEnrollments(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getStudentEnrollments(studentId);
        return ResponseEntity.ok(enrollments);
    }
}

