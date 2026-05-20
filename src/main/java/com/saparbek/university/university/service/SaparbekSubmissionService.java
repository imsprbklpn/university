package com.saparbek.university.university.service;

import com.saparbek.university.university.dto.SaparbekSubmissionDto;
import com.saparbek.university.university.entity.*;
import com.saparbek.university.university.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaparbekSubmissionService {

    private final SaparbekSubmissionRepository submissionRepository;
    private final SaparbekUserRepository userRepository;
    private final SaparbekAssignmentRepository assignmentRepository;

    public List<SaparbekSubmissionDto> getAllSubmissions() {
        return submissionRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SaparbekSubmissionDto createSubmission(SaparbekSubmissionDto dto) {
        SaparbekUser student = userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        SaparbekAssignment assignment = assignmentRepository.findById(dto.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        SaparbekSubmission submission = SaparbekSubmission.builder()
                .student(student)
                .assignment(assignment)
                .fileUrl(dto.getFileUrl())
                .comment(dto.getComment())
                .build();
        return toDto(submissionRepository.save(submission));
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }

    private SaparbekSubmissionDto toDto(SaparbekSubmission s) {
        return SaparbekSubmissionDto.builder()
                .id(s.getId())
                .studentId(s.getStudent().getId())
                .studentUsername(s.getStudent().getUsername())
                .assignmentId(s.getAssignment().getId())
                .assignmentTitle(s.getAssignment().getTitle())
                .fileUrl(s.getFileUrl())
                .comment(s.getComment())
                .build();
    }
}