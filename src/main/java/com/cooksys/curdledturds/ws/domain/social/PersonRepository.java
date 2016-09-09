package com.cooksys.curdledturds.ws.domain.social;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.curdledturds.ws.domain.social.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
