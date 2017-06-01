package com.hibernate.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hibernate.pojo.Student;

public interface StudentDao {
	/**
	 * 保存学生
	 * @param stu
	 * @return boolean
	 */
	boolean saveStudent(Student student);
	
	/**
	 * 根据id查询学生
	 * @param id
	 * @return Student
	 */
	Student getStudent(int id);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return boolean
	 */
	boolean updateStudent(Student student);
	
	/**
	 * 保存或更新学生
	 * @param student
	 * @return
	 */
	boolean saveOrUpdateStudent(Student student);
	
	/**
	 * 删除学生
	 * @param student
	 * @return boolean
	 */
	boolean deleteStudent(Student student);
	
	/**
	 * 查询学生集合对象
	 * @return List<Student>
	 */
	List<Student> listStudent(String hql, Object[] params);
	
	/**
	 * 
	 * @param hql
	 * @param params
	 * @return Iterator<Student>
	 */
	Iterator<Student> iterStudent(String hql, Object[] params);
	
	/**
	 * 分页查询
	 * @param hql
	 * @param map
	 * @return
	 */
	List<Student> listPage(String hql, Map<String, Object> map);
	
	/**
	 * @param hql
	 * @param map
	 * @return
	 */
	List<Student> listStudentByMap(String hql, Map<String, Object> map);
	
	/**
	 * 根据ID查询学生和年级
	 * 多对一查询
	 * @param id
	 * @return
	 */
	Student getStudnetById(int id);
	
	List<Student> listStudentByCriteria();
	
	/**
	 * Criteria 分页
	 * @return
	 */
	List<Student> listStudentByPage();
	
	/**
	 * 命名HQL查询学生
	 * @param student
	 * @return
	 */
	List<Student> getStudentByName(Student student);
	
	
	/**
	 * SQLQuery 执行本地SQL
	 * @param student
	 * @return
	 */
	List<Student> getStudentBySQL(Student student);
	
	/**
	 * 命名SQL查询
	 * @return
	 */
	List<Student> getStudentNamedQuery(Student student);
	
	/**
	 * 定制SQL保存
	 * @param student
	 * @return
	 */
	boolean saveStudentBySQL(Student student);
	
	/**
	 * 使用二级缓存查询学生
	 * @param id
	 * @return
	 */
	List<Student> getStudentByCache(int id);
	
	/**
	 * 关联查询
	 * @return
	 */
	List listJoin();
}
