package com.gres.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User {

	
	@Id
	@NotNull
	@NotBlank
	private String userId;
	
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	@NotBlank
	private String type;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	private GramPanchayatMember GMPs;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	private BlockDevelopmentOfficer BDO;

	
}
