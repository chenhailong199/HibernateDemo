package com.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.hibernate.pojo.IdCard;
import com.hibernate.pojo.User;
import com.hibernate.util.HibConfig;

public class UserTest {
	private Session session;
	@Before
	public void before(){
		session = HibConfig.getSession();
	}
	@After
	public void after(){
		HibConfig.commit();
	}
	@org.junit.Test
	public void saveUser(){
		User user = new User("李四", "123dsf");
		IdCard idCard = new IdCard("dsfewfwef");
		session.save(idCard);
		user.setIdCard(idCard);
		session.save(user);
	}
	@org.junit.Test
	public void listUser(){
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		for (User user:userList){
			System.out.println(user);
		}
	}
	
}
