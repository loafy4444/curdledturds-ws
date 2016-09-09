package com.cooksys.curdledturds.ws.domain.location;

import java.util.List;
import java.util.Set;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface StateService {

	List<State> index();

	List<State> create(List<State> states);

	State read(Long id);

	State update(Long id, State state);

	State delete(Long id);

	Set<City> indexCities(Long id);

	List<Person> indexPeople(Long id);

	List<Group> indexGroups(Long id);

	List<Interest> indexInterests(Long id);

	List<City> indexInterestCities(Long id, Long iid);

	List<Person> indexInterestPeople(Long id, Long iid);

	List<Group> indexInterestGroups(Long id, Long iid);

}
