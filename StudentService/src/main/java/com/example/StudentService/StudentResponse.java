package com.example.StudentService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponse {

	private Long id;
	private String studName;
	private int age;
	private String gender;
	private School school;
}
