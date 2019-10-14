package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.travelline.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
