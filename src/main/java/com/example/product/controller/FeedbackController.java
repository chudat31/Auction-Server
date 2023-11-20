package com.example.product.controller;

import com.example.product.models.Feedback;
import com.example.product.models.User;
import com.example.product.repository.FeedbackRepository;
import com.example.product.repository.UserRepository;
import com.example.product.response.APIResponse;
import com.example.product.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<APIResponse> getListFeedback(){
        List<Feedback> feedbackList = feedbackService.feedbackList();
        APIResponse apiResponse = APIResponse.success(feedbackList, HttpStatus.OK.value(), "Danh sach phan hoi");
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{userId}")
    public Feedback addFeedback(@PathVariable Integer userId, @RequestBody String content) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Feedback feedback = new Feedback();
            feedback.setContent(content);
            feedback.setUser(user.get());
            feedback.setDatetime(LocalDateTime.now());
            return feedbackRepository.save(feedback);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
