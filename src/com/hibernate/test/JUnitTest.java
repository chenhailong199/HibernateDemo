package com.hibernate.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.GradeDao;
import com.hibernate.dao.StudentDao;
import com.hibernate.dao.impl.GradeDaoImpl;
import com.hibernate.dao.impl.StudentDaoImpl;
import com.hibernate.pojo.Grade;
import com.hibernate.pojo.Student;

public class JUnitTest {
	StudentDao studentDao = null;
	GradeDao gradeDao = null;
	@Before
	public void before(){
		studentDao = new StudentDaoImpl();
		gradeDao = new GradeDaoImpl();
		PropertyConfigurator.configure("config/log4j.properties");
	}
	
	@Test
	public void saveStudent(){
		Student student = new Student();
		student.setStuAge(25);
		student.setStuCity("宁州");
		student.setStuName("路然轻");
		student.setGradeId(1703);
		studentDao.saveStudent(student);
	}
	@Test
	public void getStudent(){
		Student student = studentDao.getStudent(8);
		System.out.println(student.getStuName()+"--"+student.getGrade().getGradeName());
	}
	
	@Test
	public void removeGradeById(){
		String hql = "delete from Grade where gradeId = ?";
		int id = 1704;
		
		boolean flag = gradeDao.removeGradeById(hql, id);
		if (flag){
			System.out.println("删除成功");
		}
	}
	
	
	@Test
	public void saveOrUpdateStudent(){
		Student student = new Student();
		student.setStuId(16);
		student.setStuName("蔡成功");
		student.setStuAge(43);
		student.setStuCity("京州");
		studentDao.saveOrUpdateStudent(student);
	}
	@Test
	public void deleteStudent(){
		Student student = new Student();
		student.setStuId(14);
		student.setStuName("钟小艾");
		studentDao.deleteStudent(student);
	}
	@Test
	public void listStudent(){
		String hql = "from Student";
		Object[] params = {};
		List<Student> list = studentDao.listStudent(hql, params);
		for (Student stu:list){
			System.out.println(stu.getStuName());
		}
	}
	@Test
	public void iterStudent(){
		String hql = "from Student";
		Object[] params = {};
		Iterator<Student> iter = studentDao.iterStudent(hql, params);
		while (iter.hasNext()){
			System.out.println(iter.next().getStuName());
		}
	}
	@Test
	public void listPage(){
		String hql = "from Student";
		Map<String, Object> map = null;
		List<Student> list = studentDao.listPage(hql, map);
		for (Student stu:list){
			System.out.println(stu.getStuName());
		}
	}
	@Test
	public void listStudentByMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Student where stuId > :Id";
		map.put("Id", Integer.valueOf("11"));
		List<Student> list = studentDao.listStudentByMap(hql, map);
		for (Student stu:list){
			System.out.println(stu.getStuName());
		}
	}
	@Test
	public void getStudnetById(){
		Student student = studentDao.getStudnetById(2);
		System.out.println(student.getStuName());
		System.out.println("-----------------");
		System.out.println(student.getGrade().getGradeName());
	}
	@Test
	public void getGradeById(){
		
		Grade grade = gradeDao.getGradeById(2);
		System.out.println(grade.getGradeName());
		Set<Student> set = grade.getStudents();
		for (Student stu:set){
			System.out.println(stu.getStuName());
		}
	}

	@Test
	public void listStudentByCriteria(){
		List<Student> list = studentDao.listStudentByCriteria();
		System.out.println(list.iterator().next());
//		for (Iterator<Student> iter = list.iterator(); iter.hasNext();){
//			System.out.println(iter.next());
//		}
	}
	@Test
	public void listStudentByPage(){
		List<Student> list = studentDao.listStudentByPage();
		for (Iterator<Student> iter = list.iterator(); iter.hasNext();){
			System.out.println(iter.next().getStuName());
		}
	}
	
	
	/**
	 * 命名HQL查询
	 */
	@Test
	public void  getStudentByName(){
		Student student = new Student();
		student.setStuName("关羽");
		List<Student> list = studentDao.getStudentByName(student);
		System.out.println(list.iterator().next());
	}
	
	
	/**
	 * 本地SQL查询
	 */
	@Test
	public void getStudentBySQL(){
		Student student = new Student();
		student.setStuName("关羽");
		List<Student> list = studentDao.getStudentByName(student);
		System.out.println(list.iterator().next());
	}
	
	
	/**
	 * 命名SQL查询
	 */
	@Test
	public void getStudentNamedQuery(){
		Student student = new Student();
		student.setStuName("关羽");
		List<Student> list = studentDao.getStudentNamedQuery(student);
		System.out.println(list.iterator().next());
	}
	/**
	 * 定制SQL
	 */
	@Test
	public void saveStudentBySQL(){
		Student student = new Student();
		student.setStuName("林惊羽");
		student.setStuAge(23);
		student.setStuCity("南昌");
		student.setGradeId(1702);
		studentDao.saveStudentBySQL(student);
	}
	/**
	 * 二级缓存查询
	 */
	@Test
	public void getStudentByCache(){
		studentDao.getStudentByCache(3);
	}
	
	@Test
	public void listJoin(){
		List<Object[]> list = studentDao.listJoin();
		for (Object[] o:list){
			
			System.out.println(o[0]+"--"+o[1]);
		}
	}
}
