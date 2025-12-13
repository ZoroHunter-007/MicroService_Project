package com.example.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")

public class StudentController {

	@Autowired
	private StudnetService studnetService;
	
	@PostMapping
	public ResponseEntity<?>AddStudent(@RequestBody Student stud){
		return studnetService.CreateStudent(stud);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>FetchStudent(@PathVariable String id){
		return studnetService.fetchStudentByd(id);
	}
}
