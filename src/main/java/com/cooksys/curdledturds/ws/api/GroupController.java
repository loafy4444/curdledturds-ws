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
import com.cooksys.curdledturds.ws.domain.social.GroupService;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

@RestController
@RequestMapping("api/groups")
public class GroupController {

	private final GroupService service;
	
	@Autowired
	public GroupController(GroupService service){
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Group> index(){
		return this.service.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<Group> create(@RequestBody List<Group> groups){
		return this.service.create(groups);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Group read(@PathVariable Long id){
		return this.service.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Group update(@PathVariable Long id, @RequestBody Group group){
		return this.service.update(id, group);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Group delete(@PathVariable Long id){
		return this.service.delete(id);
	}
	
	@RequestMapping(value = "/{id}/interest", method = RequestMethod.GET)
	public Interest readInterest(@PathVariable Long id){
		return this.service.readInterest(id);
	}
	
	@RequestMapping(value = "/{id}/interest", method = RequestMethod.PUT)
	public Group updateInterest(@PathVariable Long id, @RequestBody Interest interest){
		return this.service.updateInterest(id, interest);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.GET)
	public City readCity(@PathVariable Long id){
		return this.service.readCity(id);
	}
	
	@RequestMapping(value = "/{id}/city", method = RequestMethod.PUT)
	public Group updateCity(@PathVariable Long id, @RequestBody City city){
		return this.service.updateCity(id, city);
	}
	
	@RequestMapping(value = "/{id}/members", method = RequestMethod.GET)
	public Set<Person> indexMembers(@PathVariable Long id){
		return this.service.indexMembers(id);
	}
	
	@RequestMapping(value = "/{id}/members", method = RequestMethod.PUT)
	public Group updateMembers(@PathVariable Long id, @RequestBody List<Person> people){
		return this.service.updateMembers(id, people);
	}

	@RequestMapping(value = "/{id}/members/{pid}", method = RequestMethod.DELETE)
	public Group deleteMembers(@PathVariable Long id, @PathVariable Long pid){
		return this.service.deleteMember(id, pid);
	}
}
