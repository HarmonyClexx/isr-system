package com.isr.baseline;
import com.isr.baseline.models.ResearchOutput;
import com.isr.baseline.models.ReviewerObj;

import java.util.List;

public class SubmissionController {
    private final UI ui;
    private final Validator validator = new Validator();
    private final Database db = new Database();
    private final ReviewerManager reviewerManager = new ReviewerManager();
    private final EvaluationManager evaluationManager = new EvaluationManager();

    public SubmissionController(UI ui) { this.ui = ui; }

    public void submit(ResearchOutput data) {
        String status = validator.validateFormat(data);

        if (status.equals("invalid")) {
            ui.displayError("Invalid format");
        } else {
            // [valid] path
            String submissionId = db.saveSubmission(data);
            System.out.println("Controller: received confirmation from Database");

            List<ReviewerObj> reviewers = reviewerManager.getAvailableReviewers();

            // Loop: assign reviewers
            for (ReviewerObj rObj : reviewers) {
                Reviewer reviewerActor = new Reviewer(rObj.name, evaluationManager);
                reviewerActor.assignReview();
            }

            evaluationManager.setSubmissionId(submissionId);
            evaluationManager.startEvaluation();

            // NotificationService -> Researcher (final arrow in diagram)
            evaluationManager.notifyResearcher(ui);
        }
    }
}