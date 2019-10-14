package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.Feedback;
import com.virtusa.travelline.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	public Feedback getFeedbackById(int feedbackId) {
		return feedbackRepository.findById(feedbackId).orElse(null);
	}

	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public boolean deleteFeedback(int feedbackId) {
		boolean status = false;
		feedbackRepository.deleteById(feedbackId);
		status = true;
		return status;
	}

	public Feedback updateFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
}