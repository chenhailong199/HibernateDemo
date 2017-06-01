package com.hibernate.dao;

import java.util.List;

import com.hibernate.pojo.Grade;

public interface GradeDao {
	
	/**
	 * 年级列表
	 * @return
	 */
	Grade getGradeById(int id);
	
	/**
	 * 根据ID删除年级
	 * @param id
	 * @return
	 */
	boolean removeGradeById(String hql, int id);
}
