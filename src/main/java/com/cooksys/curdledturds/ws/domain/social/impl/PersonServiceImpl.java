package com.cooksys.curdledturds.ws.domain.social.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.curdledturds.ws.domain.interest.InterestRepository;
import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.social.GroupRepository;
import com.cooksys.curdledturds.ws.domain.social.PersonRepository;
import com.cooksys.curdledturds.ws.domain.social.PersonService;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

	private final PersonRepository repo;
	private final InterestRepository interestRepo;
	private final GroupRepository groupRepo;
	
	@Autowired
	public PersonServiceImpl(PersonRepository repo, InterestRepository interestRepo,
			GroupRepository groupRepo){
		super();
		this.repo = repo;
		this.interestRepo = interestRepo;
		this.groupRepo = groupRepo;
	}

	@Override
	public List<Person> index() {
		return this.repo.findAll();
	}
	
	@Override
	public List<Person> create(List<Person> people) {
		List<Person> result = new ArrayList<>();
		for (Person person : people) {
			this.repo.save(person);
			result.add(person);
		}
		return result;
	}

	@Override
	public Person read(Long id) {
		return this.repo.findOne(id);
	}

	@Override
	public Person update(Long id, Person persontoUpdate) {
		persontoUpdate.setId(id);
		return this.repo.save(persontoUpdate);
	}

	@Override
	public Person delete(Long id) {
		Person person = this.read(id);
		this.repo.delete(id);
		return person;
	}

	@Override
	public City readCity(Long id) {
		return this.repo.findOne(id).getCity();
	}
	
	@Override
	public Person updateCity(Long id, City city) {
		this.repo.findOne(id).setCity(city);
		return this.repo.findOne(id);
	}
	
	@Override
	public Set<Interest> indexInterests(Long id) {
		return this.repo.findOne(id).getInterests();
	}

	@Override
	public Person updateInterests(Long id, Interest interest) {
		this.repo.findOne(id).getInterests().add(interest);
		return this.repo.findOne(id);
	}

	@Override
	public Person deleteInterest(Long id, Long iid) {
		this.repo.findOne(id).getInterests().remove(this.interestRepo.findOne(iid));
		return this.repo.findOne(id);
	}

	@Override
	public Set<Group> indexGroups(Long id) {
		return this.repo.findOne(id).getGroups();
	}

	@Override
	public Person updateGroups(Long id, Group group) {
		this.repo.findOne(id).getGroups().add(group);
		return this.repo.findOne(id);
	}

	@Override
	public Person deleteGroup(Long id, Long gid) {
		this.repo.findOne(id).getGroups().remove(this.groupRepo.findOne(gid));
		return this.repo.findOne(id);
	}

}
