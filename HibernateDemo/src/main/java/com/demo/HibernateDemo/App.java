package com.demo.HibernateDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

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

		/*
		 * Reading image file and storing it in a byte[] array. This image will be
		 * stored in DB as blob object.
		 */
		
		FileInputStream file = new FileInputStream("src/main/java/image.jpg");
		byte[] image = new byte[file.available()];
		file.read(image);
		file.close();

		/*
		 * Create student and course objects to be pushed to DB.
		 */

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

		/*
		 * Creating a new session for the first transaction. First transaction involves
		 * pushing newly created Student and Courses object onto DB. SessionProvider
		 * class creates a new Session object which can be accessed with getSession().
		 * SessionProvider.getSession() returns the Session object created. This Session
		 * object is passed to DAO methods for ORM operations.
		 */

		SessionProvider session = new SessionProvider();

		StudentDao sdao = new StudentDaoImpl(session.getSession());
		session.beginTransaction();
		sdao.addStudent(s1);
		sdao.addStudent(s2);

		CourseDao cdao = new CourseDaoImpl(session.getSession());
		session.beginTransaction();
		cdao.addCourse(c1);
		cdao.addCourse(c2);

		System.out.println(session.commitTransaction());
		session.closeSession();

		/*
		 * After each operation, commit needs to be called for the data to be persisted
		 * into DB After each commit the present Session object needs to be closed. As
		 * Session isn't thread safe, so, doing multiple commit() operations in one
		 * instance of Session will cause IllegaStateException error. Thus we need to
		 * close Session after each commit and create a new Session for new transactions
		 */

		StudentDao sdao2 = new StudentDaoImpl(session.getSession());
		session.beginTransaction();
		Student s = sdao2.getStudentById(2);
		session.commitTransaction();
		System.out.println(s.getFirst_name());
		session.closeSession();
	}
}
