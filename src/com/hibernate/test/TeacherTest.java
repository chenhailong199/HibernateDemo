package com.hibernate.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.hibernate.pojo.Student;
import com.hibernate.pojo.Teacher;
import com.hibernate.util.HibConfig;

public class TeacherTest {
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
	public void saveTeacher(){
		//new出老师对象
		Teacher teac1=new Teacher("盖聂");
		Teacher teac2=new Teacher("卫庄");
		Teacher teac3=new Teacher("章邯");
		Teacher teac4=new Teacher("李斯");
		
		//new出学生对象
		Student stu1=new Student("韩信", "西周", 35, 1703);
		Student stu2=new Student("朱家", "皖洲", 35, 1703);
		Student stu3=new Student("英布", "翰洲", 35, 1703);
		
		//准备参数
	    Set<Teacher> teachers=new HashSet<>();
	    teachers.add(teac1);
	    teachers.add(teac3);
	    teachers.add(teac4);	    
	    Set<Teacher> teachers1=new HashSet<>();
	    teachers1.add(teac2);
	    teachers1.add(teac3);
	    teachers1.add(teac4);    
	    Set<Teacher> teachers2=new HashSet<>();
	    teachers2.add(teac1);
	    teachers2.add(teac2);
	    teachers2.add(teac4);	      
	    //添加参数
	    stu1.setTeachers(teachers);
	    stu2.setTeachers(teachers1);
	    stu3.setTeachers(teachers2);     
	    //保存信息
	    session.save(stu1);
	    session.save(stu2);
	    session.save(stu3);    
	    session.save(teac1);
	    session.save(teac2);
	    session.save(teac3);
	    session.save(teac4);
	}
	@org.junit.Test
	public void listTeacher(){
		String hql = "from Teacher";
		Query query = session.createQuery(hql);
		List<Teacher> list = query.list();
		for (Teacher t:list){
			System.out.println(t+"\t"+t.getStudents()+"\t"+t.getTname());
		}
	}
}
