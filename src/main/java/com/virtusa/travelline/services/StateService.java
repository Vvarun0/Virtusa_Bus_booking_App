package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.State;
import com.virtusa.travelline.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public List<State> getAllState() {
		return stateRepository.findAll();
	}

	public State getStateById(int stateId) {
		return stateRepository.findById(stateId).orElse(null);
	}

	public State addState(State state) {
		return stateRepository.save(state);
	}

	public boolean deleteState(int stateId) {
		boolean status = false;
		stateRepository.deleteById(stateId);
		status = true;
		return status;
	}

	public State updateState(State state) {
		return stateRepository.save(state);
	}
}