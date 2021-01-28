package com.demo.HibernateDemo.Dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.demo.HibernateDemo.POJO.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory factory;

	public StudentDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		boolean status = session.getTransaction().getStatus() == TransactionStatus.COMMITTED;
		session.close();

		return status;

	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	    Root<Student> rootEntry = cq.from(Student.class);
	    CriteriaQuery<Student> all = cq.select(rootEntry);

	    TypedQuery<Student> allQuery = session.createQuery(all);
	    return allQuery.getResultList();
	}

}
