package com.student_management_system.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "courses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;

    @ManyToOne //many courses can be taught by one teacher
    @JoinColumn(name = "teacher_id")
    private User teacher;
}

