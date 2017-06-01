package com.hibernate.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Administrator
 *	持久化对象类 
 * 	学生类
 */
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer stuId;
	private String stuName;
	private String stuCity;
	private Integer stuAge;
	private Integer gradeId;
	private Grade grade;
	private Set<Teacher> teachers;
	
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	
	public Student() {
		super();
	}
	public Student(String stuName, String stuCity, Integer stuAge, Integer gradeId) {
		super();
		this.stuName = stuName;
		this.stuCity = stuCity;
		this.stuAge = stuAge;
		this.gradeId = gradeId;
	}
	@ManyToOne(targetEntity=Grade.class, fetch=FetchType.LAZY)
	@JoinColumn(name="gradeId")
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuCity=" + stuCity + ", stuAge=" + stuAge
				+ ", gradeId=" + gradeId + ", grade=" + grade + ", teachers=" + teachers + "]";
	}
	

}
