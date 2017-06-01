package com.hibernate.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.GradeDao;
import com.hibernate.dao.StudentDao;
import com.hibernate.dao.impl.GradeDaoImpl;
import com.hibernate.dao.impl.StudentDaoImpl;
import com.hibernate.pojo.Grade;
import com.hibernate.pojo.Student;
import com.hibernate.util.HibConfig;

/**
 * @author Administrator
 *
 */
public class StudentTest {
	StudentDao studentDao = null;
	GradeDao gradeDao = null;
	private Session session;
	private Transaction tran;
	
	@Before
	public void before(){
		studentDao = new StudentDaoImpl();
		gradeDao = new GradeDaoImpl();
		session = HibConfig.getSession();
		tran = session.beginTransaction();
		PropertyConfigurator.configure("config/log4j.properties");
	}
	@After
	public void after(){
		try {
			tran.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null){
				tran.rollback();
			}
		}
	}
	
	@org.junit.Test
	public void getStudentByID(){
		String hql = "from Student where stuId = :stuId";
		Session session = HibConfig.getSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stuId", 6);
		query.setProperties(map);
		Student student = (Student) query.uniqueResult();
		System.out.println(student.getStuName()+"--"+student.getGrade().getGradeName());
		HibConfig.commit();
	}
	@org.junit.Test
	public void listStudent(){
		String hql = "select stuId,stuName from Student where stuId > ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 6);
		List<Object[]> list = query.list();
		for (Object[] obj:list){
			System.out.println(obj[0]+"====>"+obj[1]);
		}
	}
	
	/**
	 * 批量查询
	 */
	@org.junit.Test
	public void listStudentByID(){
		String hql = "from Student where stuId in (:id)";
		Query query = session.createQuery(hql);
		Integer[] id = {1,3,5,7,12,25};
		query.setParameterList("id", id);
		List<Student> list = query.list();
		for (Student stu:list){
			System.out.println(stu.getStuId()+"\t"+stu.getStuName());
		}
	}
	/**
	 * 内连接查询
	 */
	@org.junit.Test
	public void listJoinQuery(){
		String hql = "from Student s join s.grade ";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] obj:list){
			Student stu = (Student) obj[0];
			Grade grade = (Grade)obj[1];
			System.out.println(stu.getStuName()+"--->"+grade.getGradeName());
		}
	}
	/**
	 * 内连接迫切查询
	 */
	@Test
	public void listFetchJoin(){
		String hql = "from Student s join fetch s.grade";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for (Student stu:list){
			System.out.println(stu.getStuName()+"--"+stu.getGrade().getGradeName());
		}
	}
	@Test
	public void listRightFetchJoin(){
		String hql = "from Student s right join fetch s.grade";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for (Student stu:list){
			System.out.println(stu.getStuName()+"--"+stu.getGrade().getGradeName());
		}
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void page(){
		String hql="from Student";
		Query query=session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(3);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		for (Student s : list) {
			System.out.println(s.getStuName());
		}
	}
}
