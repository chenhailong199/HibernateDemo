package com.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;


import com.hibernate.dao.StudentDao;
import com.hibernate.pojo.Student;
import com.hibernate.util.HibConfig;

public class StudentDaoImpl implements StudentDao{
	
	@Override
	public boolean saveStudent(Student student) {
		Transaction tran = null;
		Session  session = null;
		try {
			session = HibConfig.getSession();
			tran = session.beginTransaction();
			session.save(student);
			tran.commit();	
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public Student getStudent(int id) {
		Transaction tran = null;
		Student student = null;
		try {
			Session session = HibConfig.getSession();
			tran = session.beginTransaction();
			student = (Student) session.get(Student.class, id);
		} catch (HibernateException e) {
			if (tran!=null){
				tran.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean flag = true;
		Transaction tran = null;
		try {
			Session session = HibConfig.getSession();
			tran = session.beginTransaction();
			session.update(student);
			tran.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdateStudent(Student student) {
		boolean flag = true;
		Transaction tran = null;
		try {
			Session session = HibConfig.getSession();
			tran = session.beginTransaction();
			session.saveOrUpdate(student);
			tran.commit();		
		} catch (HibernateException e) {		
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteStudent(Student student) {
		Transaction tran = null;
		try {
			Session session = HibConfig.getSession();
			tran = session.beginTransaction();
			session.delete(student);
			tran.commit();
			session.clear();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
			return false;
		}
		return true;
	}

	@Override
	public List<Student> listStudent(String hql, Object[] params) {
		List<Student> list = new ArrayList<Student>();
		try {
			Session session = HibConfig.getSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			for (int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
			list = query.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Iterator<Student> iterStudent(String hql, Object[] params) {
		Iterator<Student> iters = null;
		try {
			Session session = HibConfig.getSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			for (int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
			iters = query.iterate();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return iters;
	}

	@Override
	public List<Student> listPage(String hql, Map<String, Object> map) {
		List<Student> list = new ArrayList<Student>();
		try {
			Session session = HibConfig.getSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(3);
//			query.setProperties(map);
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> listStudentByMap(String hql, Map<String, Object> map) {
		List<Student> list = new ArrayList<Student>();
		try {
			Session session = HibConfig.getSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setProperties(map);
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student getStudnetById(int id) {
		Transaction tran = null;
		Student student = null;
		try {
			Session session = HibConfig.getSession();
			tran = session.beginTransaction();
			student = (Student) session.load(Student.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran != null){
				tran.rollback();
			}
		}
		return student;
	}

	@Override
	public List<Student> listStudentByCriteria() {
		//List<Student> list = new ArrayList<Student>();
		List list = new ArrayList();
		Session session = null;
		try {
			session = HibConfig.getSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			//查询 李达康
			//criteria.add(Restrictions.eq("stuName", "李达康"));
			//查询ID 5-9的学生
			//criteria.add(Restrictions.between("stuId", 5, 9));
			//
			criteria.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("stuName"))
					.add(Projections.rowCount())
					);
			list = criteria.list();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Student> listStudentByPage() {
		List<Student> list = new ArrayList<Student>();
		Session session = null;
		try {
			session = HibConfig.getSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);
			list = criteria.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Student> getStudentByName(Student student) {
		Session session = null;
		Transaction tran = null;
		List<Student> list = new ArrayList<Student>();
		try {
			session = HibConfig.getSession();
			tran = session.beginTransaction();
			Query query = session.getNamedQuery("stuName");
			query.setProperties(student);
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Student> getStudentBySQL(Student student) {
		Session session = null;
		Transaction tran = null;
		List<Student> list = new ArrayList<Student>();
		try {
			session = HibConfig.getSession();
			tran = session.beginTransaction();
			String sql = "select {s.*} from student s where s.name = " + student.getStuName();
			SQLQuery query = session.createSQLQuery(sql).addEntity("s", Student.class);
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Student> getStudentNamedQuery(Student student) {
		Session session = null;
		Transaction tran = null;
		List<Student> list = new ArrayList<Student>();
		try {
			session = HibConfig.getSession();
			tran = session.beginTransaction();
			Query query = session.getNamedQuery("getStudent");
			query.setString(0, student.getStuName());
			list = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean saveStudentBySQL(Student student) {
		Session  session = null;
		Transaction tran = null;
		try {
			session = HibConfig.getSession();
			tran = session.beginTransaction();
			session.save(student);
			tran.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tran!=null){
				tran.rollback();
			}
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public List<Student> getStudentByCache(int id) {
		
		Session session = HibConfig.getSession();
		session.beginTransaction();
		Student student1 = (Student) session.load(Student.class, id);
		System.out.println("student1:"+student1.getStuName());
		//Grade grade1 = (Grade) session.load(Grade.class, id);
		//System.err.println("grade1:"+grade1.getGradeName());
		session.close();
		
		Session session2 = HibConfig.getSession();
		session2.beginTransaction();
		Student student2 = (Student) session.load(Student.class, id);
		System.out.println("student2:"+student2.getStuName());
		//Grade grade2 = (Grade) session.load(Grade.class, id);
		//System.err.println("grade2:"+grade2.getGradeName());
		session2.close();
		return null;		
	}

	@Override
	public List listJoin() {
		Session session = HibConfig.getSession();
		session.beginTransaction();
//		List list = session.createCriteria(Student.class, "s")
//				.createAlias("s.grade", "g",CriteriaSpecification.LEFT_JOIN)
//				.add(Restrictions.like("s.stuName","李", MatchMode.START)).list();
//		List list = session.createCriteria(Student.class, "s")
//					.setProjection(Property.forName("stuName")).list();
//		List<Object[]> list = session.createCriteria(Student.class, "s")
//						.setProjection(
//								Projections.projectionList()
//								//.add(Property.forName("stuName"))
//								.add(Property.forName("stuCity").group())
//								.add(Property.forName("stuAge").avg())
//								).list();
		List<Object[]> list = session.createCriteria(Student.class, "s")
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("stuCity"))
						.add(Projections.avg("stuAge"))
						).list();
		
		return list;
	}
	
	
	
}
