package com.saparbek.university.university.controller;

import com.saparbek.university.university.dto.SaparbekSubmissionDto;
import com.saparbek.university.university.service.SaparbekSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SaparbekSubmissionController {

    private final SaparbekSubmissionService submissionService;

    @GetMapping
    public ResponseEntity<List<SaparbekSubmissionDto>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }

    @PostMapping
    public ResponseEntity<SaparbekSubmissionDto> createSubmission(@RequestBody SaparbekSubmissionDto dto) {
        return ResponseEntity.ok(submissionService.createSubmission(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.ok("Submission deleted");
    }
}