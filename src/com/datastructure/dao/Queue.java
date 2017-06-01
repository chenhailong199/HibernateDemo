package com.datastructure.dao;

public interface Queue {
	/**
	 * 入队
	 * @param item
	 */
	void push(Object item);
	/**
	 * 出队
	 * @return
	 */
	Object pop();
	/**
	 * 查找队头元素
	 * @return
	 */
	Object peek();
	/**
	 * 判断是否为空队列
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 返回队列的大小
	 * @return
	 */
	int size();
	
}
