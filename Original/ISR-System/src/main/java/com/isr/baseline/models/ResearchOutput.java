package com.isr.baseline.models;

// ResearchOutput.java
import org.bson.Document;

public class ResearchOutput {
    public String id;
    public String title;
    public String content;

    public Document toBson() {
        return new Document("title", title).append("content", content);
    }
}


