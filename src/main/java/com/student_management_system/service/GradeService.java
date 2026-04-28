package com.student_management_system.service;

import com.student_management_system.entity.Grade;
import com.student_management_system.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public Grade submitGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<Grade> getGradesByStudent(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    //Calculate GPA/Average for a student
    public Double calculateAverage(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        if (grades.isEmpty()) return 0.0;
        
        return grades.stream()
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }
}
