package com.cooksys.curdledturds.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface PersonService {

	List<Person> index();

	List<Person> create(List<Person> people);
	
	Person read(Long id);

	Person update(Long id, Person persontoUpdate);

	Person delete(Long id);

	City readCity(Long id);
	
	Person updateCity(Long id, City city);

	Set<Interest> indexInterests(Long id);
	
	Person updateInterests(Long id, Interest interest);

	Person deleteInterest(Long id, Long iid);

	Set<Group> indexGroups(Long id);

	Person updateGroups(Long id, Group group);

	Person deleteGroup(Long id, Long gid);


}
