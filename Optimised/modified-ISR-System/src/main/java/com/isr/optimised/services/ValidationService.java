package com.isr.optimised.services;
import com.isr.optimised.models.Submission;

public class ValidationService {
    public boolean isValid(Submission data) {
        return data.content != null && data.content.trim().length() > 20;
    }
}