package com.demo.HibernateDemo.Dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.demo.HibernateDemo.POJO.Course;

public class CourseDaoImpl implements CourseDao {

	private SessionFactory factory;

	public CourseDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;
	}

	@Override
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.saveOrUpdate(course);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;
	}

	@Override
	public boolean deleteCourse(Course course) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.delete(course);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> rootEntry = cq.from(Course.class);
		CriteriaQuery<Course> all = cq.select(rootEntry);

		TypedQuery<Course> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}

}
