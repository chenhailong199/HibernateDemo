package com.hibernate.pojo;

import java.io.Serializable;

public class IdCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String no;
	private User user;
	public IdCard() {
		super();
	}
	public IdCard(String no) {
		super();
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", no=" + no + ", user=" + user + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
