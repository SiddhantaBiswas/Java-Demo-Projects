package com.demo.HibernateDemo.POJO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // sets primary key as "auto_increment"
	@Column(name = "RollNo")
	private int student_id;

	@Column(name = "FristName")
	private String first_name;

	@Column(name = "LastName")
	private String last_name;

	@Column(name = "Email", length = 50) // this implies VARCHAR(50), default VARCHAR is 255
	private String email;

	@Column(name = "DateAdded")
	@Temporal(TemporalType.DATE) // TemporalType.DATE formats date to be sent to DB without the timestamp
	private Date date;

	@Lob	// LargeObject (BLOB)
	@Column(name = "ProfilePicture")
	private byte[] image;
	
	StudentAddress address;
	
	@ManyToMany
	private List<Course> courses;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String first_name, String last_name, String email, Date date, byte[] image, StudentAddress address) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.date = date;
		this.image = image;
		this.address = address;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public StudentAddress getAddress() {
		return address;
	}

	public void setAddress(StudentAddress address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
