package com.example.SchoolService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class School {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "location")
	private String location;

	@Column(name = "principal_name")
	private String principalName;
	}
