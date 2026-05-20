package com.saparbek.university.university.service;

import com.saparbek.university.university.dto.SaparbekUserDto;
import com.saparbek.university.university.entity.SaparbekUser;
import com.saparbek.university.university.repository.SaparbekUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaparbekUserService {

    private final SaparbekUserRepository userRepository;

    public List<SaparbekUserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SaparbekUserDto getUserById(Long id) {
        SaparbekUser user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDto(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private SaparbekUserDto toDto(SaparbekUser user) {
        return SaparbekUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}