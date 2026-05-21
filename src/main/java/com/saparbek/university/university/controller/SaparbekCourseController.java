package com.saparbek.university.university.controller;

import com.saparbek.university.university.dto.SaparbekCourseDto;
import com.saparbek.university.university.service.SaparbekCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class SaparbekCourseController {

    private final SaparbekCourseService courseService;

    @GetMapping
    public ResponseEntity<Page<SaparbekCourseDto>> getAllCourses(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllCourses(search, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaparbekCourseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<SaparbekCourseDto> createCourse(@Valid @RequestBody SaparbekCourseDto dto) {
        return ResponseEntity.ok(courseService.createCourse(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaparbekCourseDto> updateCourse(@PathVariable Long id,
                                                          @Valid @RequestBody SaparbekCourseDto dto) {
        return ResponseEntity.ok(courseService.updateCourse(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }
}