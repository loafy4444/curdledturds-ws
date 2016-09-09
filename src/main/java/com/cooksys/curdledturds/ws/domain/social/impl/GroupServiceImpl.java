package com.cooksys.curdledturds.ws.domain.social.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.social.GroupRepository;
import com.cooksys.curdledturds.ws.domain.social.GroupService;
import com.cooksys.curdledturds.ws.domain.social.PersonRepository;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@Service
public class GroupServiceImpl implements GroupService{

	private final GroupRepository repo;
	private final PersonRepository personRepo;
	
	@Autowired
	public GroupServiceImpl(GroupRepository repo, PersonRepository personRepo){
		super();
		this.repo = repo;
		this.personRepo = personRepo;
	}

	@Override
	public List<Group> index(){
		return this.repo.findAll();
	}

	@Override
	public List<Group> create(List<Group> groups) {
		List<Group> result = new ArrayList<>();
		for (Group group : groups) {
			this.repo.save(group);
			result.add(group);
		}
		return result;
	}

	@Override
	public Group read(Long id) {
		return this.read(id);
	}

	@Override
	public Group update(Long id, Group group) {
		group.setId(id);
		this.repo.save(group);
		return this.repo.findOne(id);
	}

	@Override
	public Group delete(Long id) {
		Group group = this.repo.findOne(id);
		this.repo.delete(id);
		return group;
	}

	@Override
	public Interest readInterest(Long id) {
		return this.repo.findOne(id).getInterest();
	}

	@Override
	public Group updateInterest(Long id, Interest interest) {
		this.repo.findOne(id).setInterest(interest);
		return this.repo.findOne(id);
	}

	@Override
	public City readCity(Long id) {
		return this.repo.findOne(id).getCity();
	}

	@Override
	public Group updateCity(Long id, City city) {
		this.repo.findOne(id).setCity(city);
		return this.repo.findOne(id);
	}

	@Override
	public Set<Person> indexMembers(Long id) {
		return this.repo.findOne(id).getMembers();
	}

	@Override
	public Group updateMembers(Long id, List<Person> people) {
		for (Person person : people) {
			this.repo.findOne(id).getMembers().add(person);
		}
		return this.repo.findOne(id);
	}

	@Override
	public Group deleteMember(Long id, Long pid) {
		this.repo.findOne(id).getMembers().remove(personRepo.findOne(pid));
		return this.repo.findOne(id);
	}
	
}
