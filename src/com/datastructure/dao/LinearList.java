package com.datastructure.dao;

public interface LinearList {
	/**
	 * 判断线性表是否为空
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 获取线性表长度
	 * @return
	 */
	public int size();
	/**
	 * 获取指定位置的元素
	 * @param index
	 * @return
	 */
	public Object get(int index);
	/**
	 * 替换指定位置的元素
	 * @param index
	 * @param element
	 */
	public void set(int index, Object element);
	/**
	 * 向指定位置插入元素
	 * @param index
	 * @param element
	 * @return
	 */
	public boolean add(int index, Object element);
	/**
	 * 向尾部插入元素
	 * @param element
	 * @return
	 */
	public boolean addlast(Object element);
	/**
	 * 删除元素
	 * @param index
	 * @return
	 */
	public Object remove(int index);
	/**
	 * 清除所有元素
	 */
	public void clear();
}
