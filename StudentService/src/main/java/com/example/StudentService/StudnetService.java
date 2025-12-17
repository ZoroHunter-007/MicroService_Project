package com.example.StudentService;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudnetService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<?>CreateStudent(Student stud){
		try {
			
			return new ResponseEntity<Student>(studentRepo.saveAndFlush(stud),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<?>fetchStudentByd(Long id){
	
	Optional<Student> stud=studentRepo.findById(id);
	if(stud.isPresent()) {
		School school=restTemplate.getForObject("http://SCHOOLSERVICE/schools/"+ stud.get().getSchoolId(),School.class);
		StudentResponse studentResponse=new StudentResponse(
				
				stud.get().getId(),
				stud.get().getStudName(),
				stud.get().getAge(),
				stud.get().getGender(),
				school
				);
		return new ResponseEntity<>(studentResponse,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
	}
	}
}
