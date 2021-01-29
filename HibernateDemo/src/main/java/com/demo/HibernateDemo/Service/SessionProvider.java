package com.demo.HibernateDemo.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.demo.HibernateDemo.POJO.Course;
import com.demo.HibernateDemo.POJO.Student;

public class SessionProvider {

	private static SessionFactory sf;
	private static Session session;

	public Session getSession() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class);
		sf = config.buildSessionFactory();

		session = sf.getCurrentSession();
		return session;
	}

	public void beginTransaction() {
		session.beginTransaction();
	}

	public TransactionStatus commitTransaction() {
		session.getTransaction().commit();
		return session.getTransaction().getStatus();
	}

	public void closeSession() {
		session.close();
		sf.close();
	}

}
