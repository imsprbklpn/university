package com.saparbek.university.university.controller;

import com.saparbek.university.university.dto.SaparbekAssignmentDto;
import com.saparbek.university.university.service.SaparbekAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class SaparbekAssignmentController {

    private final SaparbekAssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<List<SaparbekAssignmentDto>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaparbekAssignmentDto> getAssignmentById(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(id));
    }

    @PostMapping
    public ResponseEntity<SaparbekAssignmentDto> createAssignment(@Valid @RequestBody SaparbekAssignmentDto dto) {
        return ResponseEntity.ok(assignmentService.createAssignment(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted");
    }
}