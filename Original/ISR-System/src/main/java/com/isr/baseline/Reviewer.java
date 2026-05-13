package com.isr.baseline;

public class Reviewer {
    private String name;
    private EvaluationManager evalManager;

    public Reviewer(String name, EvaluationManager em) {
        this.name = name;
        this.evalManager = em;
    }

    public void assignReview() {
        System.out.println("Review assigned to: " + name);
        // Assignment only - score submission happens later in the loop
    }
}