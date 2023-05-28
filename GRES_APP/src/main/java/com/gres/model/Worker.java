package com.gres.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Worker {

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="name", nullable=false)
	private String name;
	
	
	@Email
	@NotBlank
	@Column(unique = true,nullable = false)
	private String email;
	
	@Size(min = 12, max = 12, message="INVALID ADHAR NUMBER")
	@Pattern(regexp="[0-9]{12}")
	@Column(name="adhar", nullable=false, unique=true)
	private String adhar;
	
	@NotNull(message = "DOB cannot be null")
	private LocalDate dob;
	
	@NotNull
	@NotBlank
	private String gender;
	
	@NotNull
	@NotBlank
	private String panchayatName;
	
	@NotNull
	@NotBlank
	private String district;
	
	@NotNull
	@NotBlank
	private String State;
	
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "member_id")
    private GramPanchayatMember gramPanchayatMember;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projects;
	
}
