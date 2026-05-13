package com.isr.baseline;

public class NotificationService {
    public void notifyAcceptance() {
        System.out.println("NotificationService: Acceptance notification prepared");
    }

    public void notifyRejection() {
        System.out.println("NotificationService: Rejection notification prepared");
    }

    public void notifyRevision() {
        System.out.println("NotificationService: Revision notification prepared");
    }

    public void sendNotificationToResearcher(UI ui) {
        // This matches the final arrow: NotificationService -> Researcher
        ui.receiveNotification("Your submission has been reviewed.");
    }

    private void sendNotification(String status) {
        System.out.println("NotificationService: Sending " + status + " to Researcher.");
    }
}