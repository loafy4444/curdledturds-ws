package com.cooksys.curdledturds.ws.domain.location.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.curdledturds.ws.domain.interest.InterestRepository;
import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.CityRepository;
import com.cooksys.curdledturds.ws.domain.location.CityService;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@Service
public class CityServiceImpl implements CityService{

	private final CityRepository repo;
	private final InterestRepository interestRepo;
	
	@Autowired
	public CityServiceImpl(CityRepository repo, InterestRepository interestRepo){
		super();
		this.repo = repo;
		this.interestRepo = interestRepo;
	}

	@Override
	public List<City> index() {
		return this.repo.findAll();
	}

	@Override
	public List<City> create(List<City> cities) {
		List<City> result = new ArrayList<>();
		for (City city : cities) {
			this.repo.save(city);
			result.add(city);
		}
		return result;
	}

	@Override
	public City read(Long id) {
		return this.repo.findOne(id);
	}

	@Override
	public City update(Long id, City city) {
		city.setId(id);
		this.repo.save(city);
		return this.repo.findOne(id);
	}

	@Override
	public City delete(Long id) {
		City city = this.repo.findOne(id);
		this.repo.delete(id);
		return city;
	}

	@Override
	public State readState(Long id) {
		return this.repo.findOne(id).getState();
	}

	@Override
	public City updateState(Long id, State state) {
		this.repo.findOne(id).setState(state);
		return this.repo.findOne(id);
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
	public List<Interest> indexInterests(Long id) {
		List<Interest> result = new ArrayList<>();
		for (Person person : this.repo.findOne(id).getPeople()) {
			for (Interest interest : person.getInterests()) {
				if(!result.contains(interest)){
					result.add(interest);
				}
			}
		}
		for (Group group : this.repo.findOne(id).getGroups()) {
			if(!result.contains(group.getInterest())){
				result.add(group.getInterest());
			}
		}
		return result;
	}

	@Override
	public List<Person> indexInterestPeople(Long id, Long iid) {
		List<Person> result = new ArrayList<>();
		for (Person person : this.repo.findOne(id).getPeople()) {
			if(person.getInterests().contains(this.interestRepo.findOne(iid))){
				result.add(person);
			}
		}
		return result;
	}

	@Override
	public List<Group> indexInterestGroups(Long id, Long iid) {
		List<Group> result = new ArrayList<>();
		for (Group group : this.repo.findOne(id).getGroups()) {
			if(group.getInterest().equals(this.interestRepo.findOne(iid))){
				result.add(group);
			}
		}
		return result;
	}
}
