package com.isr.optimised.repos;

import com.isr.optimised.models.Submission;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class SubmissionRepository {
    private MongoCollection<Document> collection;

    public SubmissionRepository() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        this.collection = client.getDatabase("ReviewSystem").getCollection("submissions");
    }

    public String saveSubmission(Submission s) {
        Document doc = new Document("title", s.title)
                .append("content", s.content)
                .append("researcherId", s.researcherId)
                .append("status", "Under Review");
        collection.insertOne(doc);
        return doc.getObjectId("_id").toString();
    }

    public void updateScore(String subId, int score) {
        collection.updateOne(new Document("_id", new ObjectId(subId)),
                new Document("$push", new Document("scores", score)));
    }
}