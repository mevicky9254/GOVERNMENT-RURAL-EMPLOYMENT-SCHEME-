package com.gres.model;

import java.time.LocalDate;
import java.util.Date;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="projectName",nullable=false,unique=true)
	private String projectName;
	
	@Column(name="startDate",nullable=false)
	private LocalDate startDate;
	
	@Column(name="endDate",nullable=false)
	private LocalDate endDate;
	
	
	@Column(name="per_day_wages")
	private Integer per_day_wages;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER ,cascade=CascadeType.PERSIST, mappedBy="projects")
	private List<Worker> workers;
    
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "member_id")
	 private GramPanchayatMember gramPanchayatMember;
	
}
