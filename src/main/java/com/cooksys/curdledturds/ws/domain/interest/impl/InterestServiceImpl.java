package com.cooksys.curdledturds.ws.domain.interest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.curdledturds.ws.domain.interest.InterestRepository;
import com.cooksys.curdledturds.ws.domain.interest.InterestService;
import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@Service
public class InterestServiceImpl implements InterestService{

	private final InterestRepository repo;
	
	@Autowired
	public InterestServiceImpl(InterestRepository repo){
		super();
		this.repo = repo;
	}

	@Override
	public List<Interest> index() {
		return this.repo.findAll();
	}

	@Override
	public List<Interest> create(List<Interest> interests) {
		List<Interest> result = new ArrayList<>();
		for (Interest interest : interests) {
			this.repo.save(interest);
			result.add(interest);
		}
		return result;
	}

	@Override
	public Interest read(Long id) {
		return this.repo.findOne(id);
	}

	@Override
	public Interest update(Long id, Interest interest) {
		interest.setId(id);
		this.repo.save(interest);
		return this.repo.findOne(id);
	}

	@Override
	public Interest delete(Long id) {
		Interest interest = this.repo.findOne(id);
		this.repo.delete(id);
		return interest;
	}

	@Override
	public Set<Person> indexPeople(Long id) {
		return this.repo.findOne(id).getPeople();
	}

	@Override
	public Set<Group> indexGroups(Long id) {
		return this.repo.findOne(id).getGroups();
	}

	@Override
	public List<City> indexCities(Long id) {
		List<City> result = new ArrayList<>();
		for (Person person : this.repo.findOne(id).getPeople()) {
			if(!result.contains(person.getCity())){
				result.add(person.getCity());
			}
		}
		for (Group group : this.repo.findOne(id).getGroups()){
			if(!result.contains(group.getCity())){
				result.add(group.getCity());
			}
		}
		return result;
	}

	@Override
	public List<State> indexStates(Long id) {
		List<State> result = new ArrayList<>();
		for (Person person : this.repo.findOne(id).getPeople()) {
			if(!result.contains(person.getCity().getState())){
				result.add(person.getCity().getState());
			}
		}
		for (Group group : this.repo.findOne(id).getGroups()){
			if(!result.contains(group.getCity().getState())){
				result.add(group.getCity().getState());
			}
		}
		return result;
	}


	
}
