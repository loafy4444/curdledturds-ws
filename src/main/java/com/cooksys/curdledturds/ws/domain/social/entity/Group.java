package com.cooksys.curdledturds.ws.domain.social.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cooksys.curdledturds.ws.domain.interest.entity.Interest;
import com.cooksys.curdledturds.ws.domain.location.entity.City;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"city_id", "interest_id", "name"}))
public class Group {

    @Id
    @SequenceGenerator(name="group_id_seq", sequenceName="group_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="group_id_seq")
    @Column(updatable=false)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="interest_id")
	private Interest interest;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="group_members")
	private Set<Person> members;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Set<Person> getMembers() {
		return members;
	}

	public void setMembers(Set<Person> members) {
		this.members = members;
	}
}
