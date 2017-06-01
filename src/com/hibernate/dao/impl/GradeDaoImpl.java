package com.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.dao.GradeDao;
import com.hibernate.pojo.Grade;
import com.hibernate.util.HibConfig;

public class GradeDaoImpl implements GradeDao{

	@Override
	public Grade getGradeById(int id) {
		Grade grade = null;
		try {
			Session session = HibConfig.getSession();
			session.beginTransaction();
			grade = (Grade) session.get(Grade.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return grade;
	}

	@Override
	public boolean removeGradeById(String hql, int id) {
		boolean flag = true;
		Transaction tran = null;
		Session session = HibConfig.getSession();
		try {
			tran = session.beginTransaction();
			Grade grade = (Grade) session.get(Grade.class, id);
			session.delete(grade);
			//query.setParameter(0, id);
			//int rows = query.executeUpdate();
			//if (rows > 0){
				//flag = true;
			//}
			tran.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran != null){
				tran.rollback();
			}
			flag = false;
		} finally {
			session.close();
		}
		return flag;
	}
	
}
