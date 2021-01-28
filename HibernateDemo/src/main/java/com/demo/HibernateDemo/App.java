package com.demo.HibernateDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.HibernateDemo.Dao.CourseDao;
import com.demo.HibernateDemo.Dao.CourseDaoImpl;
import com.demo.HibernateDemo.Dao.StudentDao;
import com.demo.HibernateDemo.Dao.StudentDaoImpl;
import com.demo.HibernateDemo.POJO.Course;
import com.demo.HibernateDemo.POJO.Student;
import com.demo.HibernateDemo.POJO.StudentAddress;
import com.demo.HibernateDemo.Service.SessionProvider;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		FileInputStream file = new FileInputStream("src/main/java/image.jpg");
		byte[] image = new byte[file.available()];
		file.read(image);

		file.close();

		Student s1 = new Student(12, "Siddhanta", "Biswas", "sid@123.com", new Date(), image,
				new StudentAddress("Asansol", "India"));
		Student s2 = new Student(12, "Shubhangi", "Nath", "shubh@123.com", new Date(), image,
				new StudentAddress("Kalol", "India"));
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);

		Course c1 = new Course();
		c1.setCourse_name("Java");
		Course c2 = new Course();
		c2.setCourse_name("Deep Learning");
		List<Course> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);

		s1.setCourses(courses);
		s2.setCourses(courses);
		c1.setStudents(students);
		c2.setStudents(students);

		SessionProvider provider = new SessionProvider();
		SessionFactory factory = provider.getSessionFactory();

		/*
		StudentDao sdao = new StudentDaoImpl(factory);
		sdao.addStudent(s1);
		sdao.addStudent(s2);
		CourseDao cdao = new CourseDaoImpl(factory);
		cdao.addCourse(c1);
		cdao.addCourse(c2);
		*/
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);
		session.getTransaction().commit();
		session.close();
		
		provider.closeSession();
	}
}
