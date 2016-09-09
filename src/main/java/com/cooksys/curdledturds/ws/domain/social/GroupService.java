package com.cooksys.curdledturds.ws.domain.social;

import java.util.List;
import java.util.Set;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface GroupService {

	List<Group> index();

	List<Group> create(List<Group> groups);

	Group read(Long id);

	Group update(Long id, Group group);

	Group delete(Long id);

	Interest readInterest(Long id);

	Group updateInterest(Long id, Interest interest);

	City readCity(Long id);

	Group updateCity(Long id, City city);

	Set<Person> indexMembers(Long id);

	Group updateMembers(Long id, List<Person> people);

	Group deleteMember(Long id, Long pid);

}
