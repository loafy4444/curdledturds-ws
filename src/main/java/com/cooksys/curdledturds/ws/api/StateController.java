package com.cooksys.curdledturds.ws.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.StateService;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@RestController
@RequestMapping("api/states")
public class StateController {

	private final StateService service;
	
	@Autowired
	public StateController(StateService service){
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<State> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<State> create(@RequestBody List<State> states){
		return this.service.create(states);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public State read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public State update(@PathVariable Long id, @RequestBody State state){
		return this.service.update(id, state);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public State delete(@PathVariable Long id){
		return this.service.delete(id);
	}
	
	@RequestMapping(value = "/{id}/cities", method = RequestMethod.GET)
	public Set<City> indexCities(@PathVariable Long id){
		return this.service.indexCities(id);
	}
	
	@RequestMapping(value = "/{id}/people", method = RequestMethod.GET)
	public List<Person> indexPeople(@PathVariable Long id){
		return this.service.indexPeople(id);
	}
	
	@RequestMapping(value = "/{id}/groups", method = RequestMethod.GET)
	public List<Group> indexGroups(@PathVariable Long id){
		return this.service.indexGroups(id);
	}
	
	@RequestMapping(value = "/{id}/interests", method = RequestMethod.GET)
	public List<Interest> indexInterests(@PathVariable Long id){
		return this.service.indexInterests(id);
	}
	
	@RequestMapping(value = "/{id}/interests/{iid}/cities", method = RequestMethod.GET)
	public List<City> indexInterests(@PathVariable Long id, @PathVariable Long iid){
		return this.service.indexInterestCities(id, iid);
	}
	
	@RequestMapping(value = "/{id}/interests/{iid}/people", method = RequestMethod.GET)
	public List<Person> indexInterestPeople(@PathVariable Long id, @PathVariable Long iid){
		return this.service.indexInterestPeople(id, iid);
	}
	
	@RequestMapping(value = "/{id}/interests/{iid}/groups", method = RequestMethod.GET)
	public List<Group> indexInterestGroups(@PathVariable Long id, @PathVariable Long iid){
		return this.service.indexInterestGroups(id, iid);
	}
}
