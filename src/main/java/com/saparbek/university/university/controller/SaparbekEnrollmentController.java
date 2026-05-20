package com.saparbek.university.university.controller;

import com.saparbek.university.university.async.SaparbekAsyncService;
import com.saparbek.university.university.dto.SaparbekEnrollmentDto;
import com.saparbek.university.university.service.SaparbekEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class SaparbekEnrollmentController {

    private final SaparbekEnrollmentService enrollmentService;
    private final SaparbekAsyncService asyncService;

    @GetMapping
    public ResponseEntity<List<SaparbekEnrollmentDto>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @PostMapping
    public ResponseEntity<SaparbekEnrollmentDto> enroll(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        SaparbekEnrollmentDto dto = enrollmentService.enroll(studentId, courseId);
        asyncService.sendEnrollmentNotification(
                dto.getStudentUsername(), dto.getCourseTitle());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok("Enrollment deleted");
    }
}