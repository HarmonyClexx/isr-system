package com.isr.optimised;

import com.isr.optimised.controllers.SubmissionController;
import com.isr.optimised.models.Submission;

public class UI {
    private SubmissionController controller = new SubmissionController();

    public void start(String title, String content) {
        System.out.println("UI: Forwarding submission to Controller...");
        Submission s = new Submission();
        s.title = title;
        s.content = content;

        String result = controller.processSubmission(s);

        if (result.equals("error")) {
            System.err.println("UI: Submission Error - Check content length.");
        } else {
            displaySuccess();
        }
    }

    private void displaySuccess() {
        System.out.println("UI: Success! Submission fully processed.");
    }
}