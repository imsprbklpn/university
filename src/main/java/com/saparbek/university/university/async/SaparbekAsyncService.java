package com.saparbek.university.university.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SaparbekAsyncService {

    @Async
    public CompletableFuture<String> sendEnrollmentNotification(String username, String courseTitle) {
        try {
            Thread.sleep(1000);
            log.info("Notification sent to {} for course {}", username, courseTitle);
            return CompletableFuture.completedFuture("Notification sent to " + username);
        } catch (InterruptedException e) {
            return CompletableFuture.completedFuture("Notification failed");
        }
    }

    @Async
    public CompletableFuture<String> generateReport(Long courseId) {
        try {
            Thread.sleep(2000);
            log.info("Report generated for course {}", courseId);
            return CompletableFuture.completedFuture("Report generated for course " + courseId);
        } catch (InterruptedException e) {
            return CompletableFuture.completedFuture("Report generation failed");
        }
    }

    @Async
    public CompletableFuture<String> sendSubmissionConfirmation(String username, String assignmentTitle) {
        try {
            Thread.sleep(500);
            log.info("Submission confirmed for {} on assignment {}", username, assignmentTitle);
            return CompletableFuture.completedFuture("Submission confirmed");
        } catch (InterruptedException e) {
            return CompletableFuture.completedFuture("Confirmation failed");
        }
    }
}