// Validator.java
package com.isr.baseline;

import com.isr.baseline.models.ResearchOutput;

public class Validator {
    public String validateFormat(ResearchOutput data) {
        System.out.println("Validator: Checking data format...");

        // Logical check: If content is empty or too short, return invalid
        if (data.content == null || data.content.trim().length() < 10) {
            return "invalid";
        }

        return "valid";
    }
}

