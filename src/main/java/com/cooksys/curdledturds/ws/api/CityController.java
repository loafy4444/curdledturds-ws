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
import com.cooksys.curdledturds.ws.domain.location.CityService;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@RestController
@RequestMapping("api/cities")
public class CityController {

	private final CityService service;
	
	@Autowired
	public CityController(CityService service){
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<City> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<City> create(@RequestBody List<City> cities){
		return this.service.create(cities);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public City read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public City read(@PathVariable Long id, @RequestBody City city){
		return this.service.update(id, city);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public City delete(@PathVariable Long id){
		return this.service.delete(id);
	}
	
	@RequestMapping(value = "/{id}/state", method = RequestMethod.GET)
	public State readState(@PathVariable Long id){
		return this.service.readState(id);
	}
	
	@RequestMapping(value = "/{id}/state", method = RequestMethod.PUT)
	public City updateState(@PathVariable Long id, @RequestBody State state){
		return this.service.updateState(id, state);
	}
	
	@RequestMapping(value = "/{id}/people", method = RequestMethod.GET)
	public Set<Person> indexPeople(@PathVariable Long id){
		return this.service.indexPeople(id);
	}
	
	@RequestMapping(value = "/{id}/groups", method = RequestMethod.GET)
	public Set<Group> indexGroups(@PathVariable Long id){
		return this.service.indexGroups(id);
	}
	
	@RequestMapping(value = "/{id}/interests", method = RequestMethod.GET)
	public List<Interest> indexInterests(@PathVariable Long id){
		return this.service.indexInterests(id);
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
