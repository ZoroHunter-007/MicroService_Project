package com.example.StudentService;




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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

	@Id
	
	private String id;
	@Column
	private String studName;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private Integer schoolId;
}
