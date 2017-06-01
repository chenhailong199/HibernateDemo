package com.datastructure.dao;

public interface Stack {
	/**
	 * 入栈
	 * @param item
	 */
	public void push(Object item);
	/**
	 * 出栈
	 * @return
	 */
	public Object pop();
	/**
	 * 查询栈顶值
	 * @return
	 */
	public Object peek();
	/**
	 * 判断是否为空栈
	 * @return
	 */
	public boolean isEmpty();
	/**
	 * 返回栈的大小
	 * @return
	 */
	public int size();
}
