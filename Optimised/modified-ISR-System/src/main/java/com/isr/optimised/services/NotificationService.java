package com.isr.optimised.services;

public class NotificationService {
    public String sendFinalNotice(String researcherId, String status) {
        System.out.println("[Email Sent] To: " + researcherId + " | Status: " + status);
        return "processComplete";
    }
}