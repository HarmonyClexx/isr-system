package com.isr.baseline;
import java.util.ArrayList;
import java.util.List;

public class EvaluationManager {
    private Database db = new Database();
    private NotificationService notifier = new NotificationService();
    private List<Integer> scores = new ArrayList<>();
    private String submissionId;

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public void startEvaluation() {
        System.out.println("Evaluation Process Started.");

        // Loop: each reviewer submits scores (simulated here)
        submitScore(85);
        submitScore(90);

        calculateAverage();
        checkConsensus();
        applyRules();
    }

    public void submitScore(int score) {
        scores.add(score);
        db.saveScore(submissionId, score);
    }

    private void calculateAverage() { System.out.println("EvaluationManager: Calculating Average..."); }
    private void checkConsensus() { System.out.println("EvaluationManager: Checking Consensus..."); }

    private void applyRules() {
        System.out.println("EvaluationManager: Applying Rules...");
        // Logic to determine alt block (simplified for baseline)
        notifier.notifyAcceptance();
    }

    public void notifyResearcher(UI ui) {
        notifier.sendNotificationToResearcher(ui);
    }
}