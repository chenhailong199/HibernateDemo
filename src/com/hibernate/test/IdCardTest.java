package com.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.pojo.IdCard;
import com.hibernate.pojo.User;
import com.hibernate.util.HibConfig;

public class IdCardTest {
	private Session session;
	@Before
	public void before(){
		session = HibConfig.getSession();
	}
	@After
	public void after(){
		HibConfig.commit();
	}
	@Test
	public void saveIdCard(){
		IdCard idCard = new IdCard("jldsonds");
		session.save(idCard);
		User user = new User("王五", "sdfjlwedf");
		user.setIdCard(idCard);
		session.save(user);
	}
	@Test
	public void listIdCard(){
		String hql = "from IdCard";
		Query query = session.createQuery(hql);
		List<IdCard> list = query.list();
		for (IdCard card:list){
			System.out.println(card.getUser().getUsername());
		}
	}
	
}
