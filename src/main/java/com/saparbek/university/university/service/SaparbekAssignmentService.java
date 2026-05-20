package com.saparbek.university.university.service;

import com.saparbek.university.university.dto.SaparbekAssignmentDto;
import com.saparbek.university.university.entity.SaparbekAssignment;
import com.saparbek.university.university.entity.SaparbekCourse;
import com.saparbek.university.university.repository.SaparbekAssignmentRepository;
import com.saparbek.university.university.repository.SaparbekCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaparbekAssignmentService {

    private final SaparbekAssignmentRepository assignmentRepository;
    private final SaparbekCourseRepository courseRepository;

    public List<SaparbekAssignmentDto> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SaparbekAssignmentDto getAssignmentById(Long id) {
        SaparbekAssignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        return toDto(assignment);
    }

    public SaparbekAssignmentDto createAssignment(SaparbekAssignmentDto dto) {
        SaparbekCourse course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        SaparbekAssignment assignment = SaparbekAssignment.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .course(course)
                .build();
        return toDto(assignmentRepository.save(assignment));
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    private SaparbekAssignmentDto toDto(SaparbekAssignment a) {
        return SaparbekAssignmentDto.builder()
                .id(a.getId())
                .title(a.getTitle())
                .description(a.getDescription())
                .courseId(a.getCourse().getId())
                .courseTitle(a.getCourse().getTitle())
                .build();
    }
}