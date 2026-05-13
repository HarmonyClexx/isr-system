package com.isr.optimised.services;
import com.isr.optimised.repos.SubmissionRepository;
import org.bson.Document;
import com.mongodb.client.*;
import java.util.List;

public class EvaluationService {
    private MongoCollection<Document> collection;

    public EvaluationService() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        this.collection = client.getDatabase("ReviewSystem").getCollection("submissions");
    }

    // Implements the Decision Table from Task 3
    public String generateFinalOutcome(String submissionId) {
        // Fetch scores from submission
        Document submission = collection.find(new Document("_id", new org.bson.types.ObjectId(submissionId))).first();
        List<Integer> scores = (List<Integer>) submission.get("scores");

        double avg = scores.stream().mapToInt(i -> i).average().orElse(0);
        boolean hasConsensus = checkConsensus(scores);

        if (avg >= 80 && hasConsensus) return "Accepted";
        if (avg >= 50) return "Revision";
        return "Rejected";
    }

    private boolean checkConsensus(List<Integer> scores) {
        if (scores.size() < 2) return true;
        int max = scores.stream().max(Integer::compare).get();
        int min = scores.stream().min(Integer::compare).get();
        return (max - min) < 25; // Business rule
    }
}