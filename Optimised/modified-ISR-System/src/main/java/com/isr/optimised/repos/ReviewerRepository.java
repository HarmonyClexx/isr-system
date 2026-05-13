package com.isr.optimised.repos;

import com.isr.optimised.models.Reviewer;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class ReviewerRepository {
    private MongoCollection<Document> reviewerCollection;
    private MongoCollection<Document> submissionCollection;

    public ReviewerRepository() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        this.reviewerCollection = client.getDatabase("ReviewSystem").getCollection("reviewers");
        this.submissionCollection = client.getDatabase("ReviewSystem").getCollection("submissions");
    }

    public List<Reviewer> findQualifiedReviewers(String researcherId) {
        // Optimised: DB-side filtering (e.g., workload < 5)
        List<Reviewer> list = new ArrayList<>();
        for (Document doc : reviewerCollection.find(new Document("workload", new Document("$lt", 5)))) {
            Reviewer r = new Reviewer();
            r.id = doc.getObjectId("_id").toString();
            r.name = doc.getString("name");
            list.add(r);
        }
        return list;
    }

    public void submitScore(String submissionId, int score) {
        submissionCollection.updateOne(new Document("_id", new ObjectId(submissionId)),
                new Document("$push", new Document("scores", score)));
    }
}

