package com.isr.baseline;
import com.isr.baseline.models.ReviewerObj;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewerManager {
    private Database db = new Database();

    public List<ReviewerObj> getAvailableReviewers() {
        System.out.println("SubmissionController: getting available reviewers...");
        List<ReviewerObj> list = db.fetchReviewers();
        list = filterConflicts(list);
        list = checkWorkload(list);
        return list;
    }

    private List<ReviewerObj> filterConflicts(List<ReviewerObj> list) {
        System.out.println("ReviewerManager: Filtering conflicts...");
        return list; // Baseline: matching diagram's self-call
    }

    private List<ReviewerObj> checkWorkload(List<ReviewerObj> list) {
        System.out.println("ReviewerManager: Checking workloads...");
        return list.stream().filter(r -> r.currentWorkload < 5).collect(Collectors.toList());
    }
}