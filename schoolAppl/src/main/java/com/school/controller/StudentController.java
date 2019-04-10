package com.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dao.StudentDao;
import com.school.entity.Student;
@RestController
@RequestMapping("stud")
@CrossOrigin
public class StudentController {
	
	@Autowired
	public StudentDao studentDao;
    @GetMapping("all")
	public List<Student> getMerit(){
		return studentDao.findAll();
	}
    @GetMapping("one/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
    	return studentDao.findById(id);
    }
    @PostMapping("add")
    public void addStudent(@RequestBody Student student) {
    	 studentDao.save(student);	 
    }
    @PutMapping("put/{id}")
    public Student update(@PathVariable int id) {
		return studentDao.findById(id).orElse(new Student());
    	
    }
    @RequestMapping("delete/{id}")
    
    public void delete(@PathVariable int id) {
    	studentDao.deleteById(id);
    }
    @GetMapping("count")
    public int byName(){
    	int a= (int) studentDao.count();
    	return a;
    }

}
