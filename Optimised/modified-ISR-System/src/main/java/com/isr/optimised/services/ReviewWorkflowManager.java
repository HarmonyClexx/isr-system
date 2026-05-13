package com.isr.optimised.services;

import com.isr.optimised.models.Reviewer;
import com.isr.optimised.repos.ReviewerRepository;
import java.util.Arrays;
import java.util.List;

public class ReviewWorkflowManager {
    private final ReviewerRepository reviewerRepo = new ReviewerRepository();
    private final EvaluationService evalService = new EvaluationService();
    private final NotificationService notifier = new NotificationService();

    public String initiateReviewProcess(String submissionId, String researcherId) {
        List<Reviewer> reviewers = reviewerRepo.findQualifiedReviewers(researcherId);

        // Loop: notifyAssignment()
        for (Reviewer r : reviewers) {
            r.notifyAssignment(submissionId);
        }

        // Loop: each qualifiedReviewer submits score
        List<Integer> dummyScores = Arrays.asList(85, 78, 90);
        int scoreIndex = 0;
        for (Reviewer r : reviewers) {
            if (scoreIndex < dummyScores.size()) {
                r.submitScore(reviewerRepo, submissionId, dummyScores.get(scoreIndex));
                scoreIndex++;
            }
        }

        String status = evalService.generateFinalOutcome(submissionId);

        String notificationStatus = notifier.sendFinalNotice(researcherId, status);

        return notificationStatus;
    }
}