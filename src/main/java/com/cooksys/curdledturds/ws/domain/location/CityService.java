package com.cooksys.curdledturds.ws.domain.location;

import java.util.List;
import java.util.Set;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.cooksys.curdledturds.ws.domain.location.entity.State;
import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface CityService {

	List<City> index();

	List<City> create(List<City> cities);

	City read(Long id);

	City update(Long id, City city);

	City delete(Long id);

	State readState(Long id);

	City updateState(Long id, State state);

	Set<Person> indexPeople(Long id);

	Set<Group> indexGroups(Long id);

	List<Interest> indexInterests(Long id);

	List<Person> indexInterestPeople(Long id, Long iid);

	List<Group> indexInterestGroups(Long id, Long iid);

}
