package com.gres.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class BlockDevelopmentOfficer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	@Size(min=5, max=8, message="Password should be length of min 5 and maximum 8")
	private String password;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "bdo_id")
	private List<Project> projects;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "bdo_id")
	private List<Worker> workers;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "bdo_id")
	private List<GramPanchayatMember> gmps;
	
	
	

}
