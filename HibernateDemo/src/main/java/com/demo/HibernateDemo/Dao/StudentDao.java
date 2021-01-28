package com.demo.HibernateDemo.Dao;

import java.util.List;

import com.demo.HibernateDemo.POJO.Student;

public interface StudentDao {
	boolean addStudent(Student student);

	boolean updateStudent(Student student);

	boolean deleteStudent(Student student);

	List<Student> getAllStudents();
	
}
