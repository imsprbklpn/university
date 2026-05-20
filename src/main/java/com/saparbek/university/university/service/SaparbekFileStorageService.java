package com.saparbek.university.university.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class SaparbekFileStorageService {

    private final Path uploadDir = Paths.get("uploads");

    public SaparbekFileStorageService() throws IOException {
        Files.createDirectories(uploadDir);
    }

    public String saveFile(MultipartFile file) throws IOException {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = uploadDir.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public byte[] loadFile(String filename) throws IOException {
        Path filePath = uploadDir.resolve(filename);
        return Files.readAllBytes(filePath);
    }
}