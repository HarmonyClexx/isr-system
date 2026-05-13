package com.isr.baseline;

import com.isr.baseline.models.ResearchOutput;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UI appUI = new UI();

        System.out.println("Research Submission System (Baseline Version)");

        ResearchOutput inputData = new ResearchOutput();

        System.out.print("Enter Research Title: ");
        inputData.title = scanner.nextLine();

        System.out.print("Enter Research Content (Leave empty to test 'invalid' path): ");
        inputData.content = scanner.nextLine();

        // This triggers the first call in the Sequence Diagram
        appUI.submitResearchOutput(inputData);

        scanner.close();
    }
}