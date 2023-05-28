package com.gres.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {

	@Id
    @Column(unique = true)
	private Integer userId;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String uuid;

	private LocalDateTime localDateTime;
	
}
