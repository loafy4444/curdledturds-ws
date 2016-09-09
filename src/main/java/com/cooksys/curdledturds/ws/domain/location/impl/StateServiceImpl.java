package com.cooksys.curdledturds.ws.domain.location.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.curdledturds.ws.domain.interest.InterestRepository;
import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.StateRepository;
import com.cooksys.curdledturds.ws.domain.location.StateService;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@Service
public class StateServiceImpl implements StateService {

	private final StateRepository repo;
	private final InterestRepository interestRepo;

	@Autowired
	public StateServiceImpl(StateRepository repo, InterestRepository interestRepo) {
		super();
		this.repo = repo;
		this.interestRepo = interestRepo;
	}

	@Override
	public List<State> index() {
		return this.repo.findAll();
	}

	@Override
	public List<State> create(List<State> states) {
		List<State> result = new ArrayList<>();
		for (State state : states) {
			this.repo.save(state);
			result.add(state);
		}
		return result;
	}

	@Override
	public State read(Long id) {
		return this.repo.findOne(id);
	}

	@Override
	public State update(Long id, State state) {
		state.setId(id);
		this.repo.save(state);
		return this.repo.findOne(id);
	}

	@Override
	public State delete(Long id) {
		State state = this.repo.findOne(id);
		this.repo.delete(id);
		return state;
	}

	@Override
	public Set<City> indexCities(Long id) {
		return this.repo.findOne(id).getCities();
	}

	@Override
	public List<Person> indexPeople(Long id) {
		List<Person> result = new ArrayList<>();
		for (City city : this.repo.findOne(id).getCities()) {
			result.addAll(city.getPeople());
		}
		return result;
	}

	@Override
	public List<Group> indexGroups(Long id) {
		List<Group> result = new ArrayList<>();
		for (City city : this.repo.findOne(id).getCities()) {
			result.addAll(city.getGroups());
		}
		return result;
	}

	@Override
	public List<Interest> indexInterests(Long id) {
		List<Interest> result = new ArrayList<>();
		for (City city : this.repo.findOne(id).getCities()) {
			for (Person person : city.getPeople()) {
				for (Interest interest : person.getInterests()) {
					if (!result.contains(interest)) {
						result.add(interest);
					}
				}
			}
			for (Group group : city.getGroups()) {
				if (!result.contains(group.getInterest())) {
					result.add(group.getInterest());
				}
			}
		}
		return result;
	}

	@Override
	public List<City> indexInterestCities(Long id, Long iid) {
		List<City> result = new ArrayList<>();
		for (City city : this.repo.findOne(id).getCities()) {
			for (Group group : city.getGroups()) {
				if (!result.contains(city) && group.getInterest().equals(this.interestRepo.findOne(id))) {
					result.add(city);
					break;
				}
			}
			if (!result.contains(city)) {
				for (Person person : city.getPeople()) {
					if (!result.contains(city) && person.getInterests().contains(this.interestRepo.findOne(iid))) {
						result.add(city);
						break;
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<Person> indexInterestPeople(Long id, Long iid) {
		List<Person> result = new ArrayList<>();
		for(City city : this.repo.findOne(id).getCities()){
			for (Person person : city.getPeople()) {
				if(person.getInterests().contains(this.interestRepo.findOne(iid))){
					result.add(person);
				}
			}
		}
		return result;
	}

	@Override
	public List<Group> indexInterestGroups(Long id, Long iid) {
		List<Group> result = new ArrayList<>();
		for (City city : this.repo.findOne(id).getCities()) {
			for(Group group : city.getGroups()){
				if(group.getInterest().equals(this.interestRepo.findOne(iid))){
					result.add(group);
				}
			}
		}
		return result;
	}

}
