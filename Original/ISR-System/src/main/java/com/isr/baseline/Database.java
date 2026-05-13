package com.isr.baseline;
import com.isr.baseline.models.ResearchOutput;
import com.isr.baseline.models.ReviewerObj;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private MongoCollection<Document> submissions;
    private MongoCollection<Document> reviewers;

    public Database() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ReviewSystem");
        this.submissions = database.getCollection("submissions");
        this.reviewers = database.getCollection("reviewers");
    }

    public String saveSubmission(ResearchOutput data) {
        Document doc = data.toBson();
        submissions.insertOne(doc);
        return doc.getObjectId("_id").toString();
    }

    public List<ReviewerObj> fetchReviewers() {
        List<ReviewerObj> results = new ArrayList<>();
        System.out.println("ReviewerManager: fetching reviewers from Database...");
        for (Document doc : reviewers.find()) {
            ReviewerObj r = new ReviewerObj();
            r.name = doc.getString("name");
            r.currentWorkload = doc.getInteger("workload");
            results.add(r);
        }
        System.out.println("Database: returned " + results.size() + " reviewers");
        return results;
    }

    public void saveScore(String submissionId, int score) {
        submissions.updateOne(
            new Document("_id", new ObjectId(submissionId)),
            new Document("$push", new Document("scores", score))
        );
    }
}

