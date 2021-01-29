package com.demo.HibernateDemo.Dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.demo.HibernateDemo.POJO.Student;

public class StudentDaoImpl implements StudentDao {

	private Session session;

	public StudentDaoImpl(Session session) {
		super();
		this.session = session;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

		session.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

		session.saveOrUpdate(student);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub

		session.delete(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	    Root<Student> rootEntry = cq.from(Student.class);
	    CriteriaQuery<Student> all = cq.select(rootEntry);

	    TypedQuery<Student> allQuery = session.createQuery(all);
	    return allQuery.getResultList();
	}
	
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		
		return (Student) session.get(Student.class, id);
	}

}
