package com.cooksys.curdledturds.ws.domain.interest;

import java.util.List;
import java.util.Set;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface InterestService {

	List<Interest> index();

	List<Interest> create(List<Interest> interests);

	Interest read(Long id);

	Interest update(Long id, Interest interest);

	Interest delete(Long id);

	Set<Person> indexPeople(Long id);

	Set<Group> indexGroups(Long id);

	List<City> indexCities(Long id);

	List<State> indexStates(Long id);
}
