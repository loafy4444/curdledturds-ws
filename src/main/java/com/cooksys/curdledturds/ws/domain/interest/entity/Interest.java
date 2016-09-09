package com.cooksys.curdledturds.ws.domain.interest.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cooksys.curdledturds.ws.domain.social.entity.Group;
import com.cooksys.curdledturds.ws.domain.social.entity.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Interest {

    @Id
    @SequenceGenerator(name="interest_id_seq", sequenceName="interest_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="interest_id_seq")
    @Column(updatable=false)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="interest", fetch=FetchType.LAZY)
	private Set<Group> groups;

	@JsonIgnore
	@ManyToMany(mappedBy="interests", fetch=FetchType.LAZY)
	private Set<Person> people;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}	
}
