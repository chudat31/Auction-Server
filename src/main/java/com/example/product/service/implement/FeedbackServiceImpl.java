package com.example.product.service.implement;

import com.example.product.models.Feedback;
import com.example.product.repository.FeedbackRepository;
import com.example.product.service.FeedbackService;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> feedbackList() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback addNewFeedback(String content) {
        Feedback feedback = new Feedback();
        feedback.setContent(content);
        return  (Feedback) feedbackRepository.save(feedback);
    }
}
