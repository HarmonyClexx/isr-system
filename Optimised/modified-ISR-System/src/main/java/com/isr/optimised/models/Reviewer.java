package com.isr.optimised.models;

import com.isr.optimised.repos.ReviewerRepository;

public class Reviewer {
    public String id;
    public String name;
    public int workload;

    public void notifyAssignment(String submissionId) {
        System.out.println("Reviewer [" + name + "]: Notification received for submission " + submissionId);
    }

    public void submitScore(ReviewerRepository repo, String submissionId, int score) {
        repo.submitScore(submissionId, score);
        System.out.println("Reviewer [" + name + "]: Submitted score " + score + " for submission " + submissionId);
    }
}