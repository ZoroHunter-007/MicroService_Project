package com.example.SchoolService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepositary extends JpaRepository<School, Integer> {

}
