package com.hibernate.pojo;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity	//通用
@org.hibernate.annotations.Entity(dynamicUpdate=true)	//补充,个性化配置
@Table(name="grade")	//表名和类名完全相同,可以不写,建议都写上
@Proxy(lazy=false) //延迟策略,默认true
public class Grade implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer gradeId;
	private String gradeName;
	private Set students = new HashSet();
	private String msg;
	
	@Transient	//非映射属性
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Grade [id=" + id + ", gradeId=" + gradeId + ", gradeName=" + gradeName + ", students=" + students + "]";
	}
	
	@OneToMany(cascade={CascadeType.ALL},targetEntity=Student.class,mappedBy="grade")
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="gradeId")
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
	@Column(name="gradeName")
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
