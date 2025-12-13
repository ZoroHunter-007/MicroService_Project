package com.example.SchoolService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolSerivice {

	@Autowired 
	private SchoolRepositary schoolRepositary;
	
	//insert the data 
	public School addStudents(School school) {
		return schoolRepositary.saveAndFlush(school);
	}
	
	//fetch the all data
	public List<School>getAllData(){
		return schoolRepositary.findAll();
	}
	
	//fetch the data by Id
	public School getById(int id) {
		return schoolRepositary.findById(id).orElse(null);
	}
	
	//update the data
	public School updateData(int id ,School school) {
	School sc=schoolRepositary.findById(id).orElse(null);
		if(sc!=null) {
			sc.setLocation(school.getLocation());
			sc.setPrincipalName(school.getPrincipalName());
			sc.setSchoolName(school.getSchoolName());
			return schoolRepositary.saveAndFlush(sc);
		}
		else {
			return null;
		}
	}
	
	//delete data by id
	public void deleteById(int id) {
		schoolRepositary.deleteById(id);
	}
}
