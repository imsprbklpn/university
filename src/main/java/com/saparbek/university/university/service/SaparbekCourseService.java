package com.saparbek.university.university.service;

import com.saparbek.university.university.dto.SaparbekCourseDto;
import com.saparbek.university.university.entity.SaparbekCourse;
import com.saparbek.university.university.repository.SaparbekCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaparbekCourseService {

    private final SaparbekCourseRepository courseRepository;

    public Page<SaparbekCourseDto> getAllCourses(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return courseRepository.findByTitleContainingIgnoreCase(search, pageable)
                    .map(this::toDto);
        }
        return courseRepository.findAll(pageable).map(this::toDto);
    }

    public SaparbekCourseDto getCourseById(Long id) {
        SaparbekCourse course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return toDto(course);
    }

    public SaparbekCourseDto createCourse(SaparbekCourseDto dto) {
        SaparbekCourse course = SaparbekCourse.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
        return toDto(courseRepository.save(course));
    }

    public SaparbekCourseDto updateCourse(Long id, SaparbekCourseDto dto) {
        SaparbekCourse course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        return toDto(courseRepository.save(course));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    private SaparbekCourseDto toDto(SaparbekCourse course) {
        return SaparbekCourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .build();
    }
}