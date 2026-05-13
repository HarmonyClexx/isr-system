package com.isr.optimised.controllers;

import com.isr.optimised.models.Submission;
import com.isr.optimised.repos.SubmissionRepository;
import com.isr.optimised.services.*;

public class SubmissionController {
    private ValidationService validator = new ValidationService();
    private SubmissionRepository submissionRepo = new SubmissionRepository();
    private ReviewWorkflowManager workflowManager = new ReviewWorkflowManager();

    public String processSubmission(Submission data) {
        if (!validator.isValid(data)) {
            return "error";
        }

        System.out.println("Controller: received confirmation from Database");

        String subId = submissionRepo.saveSubmission(data);
        String workflowStatus = workflowManager.initiateReviewProcess(subId, data.researcherId);

        return workflowStatus;
    }
}