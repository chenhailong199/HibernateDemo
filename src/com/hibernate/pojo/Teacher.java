package com.hibernate.pojo;

import java.io.Serializable;
import java.util.Set;

public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tname;
	private Set<Student> students;
	public Teacher(String tname) {
		super();
		this.tname = tname;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", students=" + students + "]";
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
