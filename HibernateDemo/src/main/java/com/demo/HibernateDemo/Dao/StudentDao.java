package com.demo.HibernateDemo.Dao;

import java.util.List;

import com.demo.HibernateDemo.POJO.Student;

public interface StudentDao {
	void addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int id);
	
}
