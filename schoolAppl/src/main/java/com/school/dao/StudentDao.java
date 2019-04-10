package com.school.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.entity.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
//	@Query("select s from students s where s.marks>90")
//	public List<Student> Merit();

}
