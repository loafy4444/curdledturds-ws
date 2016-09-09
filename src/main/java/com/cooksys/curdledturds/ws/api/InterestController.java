package com.cooksys.curdledturds.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.curdledturds.ws.domain.interest.InterestService;
import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@RestController
@RequestMapping("api/interests")
public class InterestController {

	private final InterestService service;
	
	@Autowired
	public InterestController(InterestService service){
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Interest> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Interest> create(@RequestBody List<Interest> interests){
		return this.service.create(interests);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Interest read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Interest update(@PathVariable Long id, @RequestBody Interest interest){
		return this.service.update(id, interest);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Interest delete(@PathVariable Long id){
		return this.service.delete(id);
	}
	
	@RequestMapping(value = "/{id}/people", method = RequestMethod.GET)
	public Set<Person> indexPeople(@PathVariable Long id){
		return this.service.indexPeople(id);
	}

	@RequestMapping(value = "/{id}/groups", method = RequestMethod.GET)
	public Set<Group> indexGroups(@PathVariable Long id){
		return this.service.indexGroups(id);
	}
	
	@RequestMapping(value = "/{id}/cities", method = RequestMethod.GET)
	public List<City> indexCities(@PathVariable Long id){
		return this.service.indexCities(id);
	}
	
	@RequestMapping(value = "/{id}/states", method = RequestMethod.GET)
	public List<State> indexStates(@PathVariable Long id){
		return this.service.indexStates(id);
	}
}
