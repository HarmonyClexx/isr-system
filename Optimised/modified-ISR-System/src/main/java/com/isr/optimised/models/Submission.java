package com.isr.optimised.models;
import java.util.ArrayList;
import java.util.List;

public class Submission {
    public String id;
    public String researcherId = "RES-99";
    public String title;
    public String content;
    public List<Integer> scores = new ArrayList<>();
    public String status = "Pending";
}