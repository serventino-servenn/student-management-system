package com.student_management_system.controller;

import com.student_management_system.entity.Grade;
import com.student_management_system.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> submitGrade(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.submitGrade(grade));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
        return ResponseEntity.ok(gradeService.getGradesByStudent(studentId));
    }

    @GetMapping("/student/{studentId}/average")
    public ResponseEntity<Double> getStudentAverage(@PathVariable Long studentId) {
        return ResponseEntity.ok(gradeService.calculateAverage(studentId));
    }
}
