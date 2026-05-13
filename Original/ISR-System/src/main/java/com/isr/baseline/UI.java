package com.isr.baseline;

import com.isr.baseline.models.ResearchOutput;

public class UI {
    private final SubmissionController controller;

    public UI() {
        // In the baseline, we initialize the controller here
        this.controller = new SubmissionController(this);
    }

    public void submitResearchOutput(ResearchOutput data) {
        System.out.println("UI: Forwarding submission to Controller...");
        controller.submit(data);
    }

    // This matches the "return error" arrow in the [invalid] block
    public void displayError(String msg) {
        System.err.println("\n[!] UI NOTIFICATION: Submission Failed!");
        System.err.println("Reason: " + msg);
    }

    // This matches the "sendNotification()" arrow at the very bottom
    public void receiveNotification(String msg) {
        System.out.println("\n[*] UI NOTIFICATION: Final System Message");
        System.out.println("Status: " + msg);
    }
}