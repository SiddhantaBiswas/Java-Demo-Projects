package com.demo.HibernateDemo.Dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.demo.HibernateDemo.POJO.Course;

public class CourseDaoImpl implements CourseDao {

	private Session session;

	public CourseDaoImpl(Session session) {
		super();
		this.session = session;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub

		session.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub

		session.saveOrUpdate(course);
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub

		session.delete(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub

		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> rootEntry = cq.from(Course.class);
		CriteriaQuery<Course> all = cq.select(rootEntry);

		TypedQuery<Course> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}

}
