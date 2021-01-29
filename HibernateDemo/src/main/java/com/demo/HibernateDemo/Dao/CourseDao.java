package com.demo.HibernateDemo.Dao;

import java.util.List;

import com.demo.HibernateDemo.POJO.Course;

public interface CourseDao {
	void addCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(Course course);

	List<Course> getAllCourses();
}
