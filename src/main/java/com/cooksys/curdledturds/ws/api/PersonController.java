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
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.social.PersonService;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@RestController
@RequestMapping("api/people")
public class PersonController {

	private final PersonService service;
	
	@Autowired
	public PersonController(PersonService service){
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Person> create(@RequestBody List<Person> people){
		return this.service.create(people);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
	public Person update(@PathVariable Long id, @RequestBody Person persontoUpdate){
		return this.service.update(id, persontoUpdate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Person delete(@PathVariable Long id){
		return this.service.delete(id);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.GET)
	public City readCity(@PathVariable Long id){
		return this.service.readCity(id);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.PUT)
	public Person updateCity(@PathVariable Long id, @RequestBody City city){
		return this.service.updateCity(id, city);
	}
	
	@RequestMapping(value = "/{id}/interests", method = RequestMethod.GET)
	public Set<Interest> indexInterests(@PathVariable Long id){
		return this.service.indexInterests(id);
	}
	
	@RequestMapping(value = "/{id}/interests", method = RequestMethod.PUT)
	public Person updateInterests(@PathVariable Long id, @RequestBody Interest interest){
		return this.service.updateInterests(id, interest);
	}
	
	@RequestMapping(value = "/{id}/interests/{iid}", method = RequestMethod.DELETE)
	public Person updateInterests(@PathVariable Long id, @PathVariable Long iid){
		return this.service.deleteInterest(id, iid);
	}
	
	@RequestMapping(value = "/{id}/groups", method = RequestMethod.GET)
	public Set<Group> indexGroups(@PathVariable Long id){
		return this.service.indexGroups(id);
	}
	
	@RequestMapping(value = "/{id}/groups", method = RequestMethod.PUT)
	public Person updateGroups(@PathVariable Long id, @RequestBody Group group){
		return this.service.updateGroups(id, group);
	}

	@RequestMapping(value = "/{id}/groups/{gid}", method = RequestMethod.DELETE)
	public Person deleteGroup(@PathVariable Long id, @PathVariable Long gid){
		return this.service.deleteGroup(id, gid);
	}
}
