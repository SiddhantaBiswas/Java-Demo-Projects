package com.demo.HibernateDemo.Dao;

import java.util.List;

import com.demo.HibernateDemo.POJO.Course;
import com.demo.HibernateDemo.POJO.Student;

public interface CourseDao {
	boolean addCourse(Course course);

	boolean updateCourse(Course course);

	boolean deleteCourse(Course course);

	List<Course> getAllCourses();
}
