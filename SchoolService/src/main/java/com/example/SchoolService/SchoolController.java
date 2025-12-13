package com.example.SchoolService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/schools")
public class SchoolController {

	@Autowired
	private SchoolSerivice schoolSerivice;
	
	@PostMapping
	public ResponseEntity<School>addSchool(@RequestBody School school){
		System.out.println(">>> Received: " + school);
		School sc=schoolSerivice.addStudents(school);
		return ResponseEntity.ok(sc);
	}
	@GetMapping
	public ResponseEntity<List<School>>showAllData(){
		return ResponseEntity.ok(schoolSerivice.getAllData());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<School>getDataById(@PathVariable int id){
		School sc=schoolSerivice.getById(id);
		if(sc!=null) {
			return ResponseEntity.ok(sc);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<School>updateSchool(@PathVariable int id,@RequestBody School school){
		School sc=schoolSerivice.updateData(id, school);
		if(sc!=null) {
			return ResponseEntity.ok(sc);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<School>DeleteById(@PathVariable int id){
		schoolSerivice.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
