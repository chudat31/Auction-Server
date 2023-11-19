package com.example.product.service;

import com.example.product.models.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> feedbackList();

    Feedback addNewFeedback(String content);
}
