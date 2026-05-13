package com.isr.optimised;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Boundary Object (UI)
        UI appUI = new UI();

        System.out.println("Research Submission System (Optimised version)");
        System.out.println("Log: Acting as Researcher (Actor)");

        // 1. Capture user input
        System.out.print("Enter Research Paper Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Research Content (min 20 chars for validity): ");
        String content = scanner.nextLine();

        // 2. Trigger the sequence: Researcher -> UI : submit(data)
        // This effectively kicks off the flow in the sequence diagram
        System.out.println("\n[Action] Submitting research output...");
        appUI.start(title, content);

        scanner.close();
    }
}