package com.datastructure.dao.impl;

import com.datastructure.dao.LinearList;



public class LinearListImpl implements LinearList{
	private Object[] slist; //对象数组
	private int size; //线性表长度
	
	public LinearListImpl() {
		this(10);
	}
	
	/**
	 * 初始化数组长度
	 * @param length
	 */
	public LinearListImpl(int length) {
		if (length <= 0){
			this.slist = new Object[10];
		}
		this.slist = new Object[length];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// 返回线性表的长度
		return size;
	}

	@Override
	public Object get(int index) {
		// 返回指定索引index的对象
		checkindex(index);
		return (Object)slist[index];
	}

	@Override
	public void set(int index, Object element) {
		// 用指定元素替换线性表中指定的位置
		checkindex(index);
		slist[index] = element;
		
	}

	@Override
	public boolean add(int index, Object element) {
		if (index > size || index < 0){
			//指定索引超过数组长度 或 索引小于0,抛出异常
			throw new IndexOutOfBoundsException("Index "+index+" Size "+size);
		}
		if (size == slist.length){
			//数组长度==线性表长度时,进行扩容
			Object[] temp = slist;
			this.slist = new Object[temp.length*2];
			for (int j=0; j<temp.length; j++){
				slist[j] = temp[j];
			}
		}
		for (int i=size-1; i>=index; i--){
			//替换位置后的元素后移一位
			slist[i+1] = slist[i];
		}
		//给指定位置赋值
		slist[index] = element;
		//长度加一
		size ++ ;
		return true;
	}

	@Override
	public boolean addlast(Object element) {
		//调用指定位置添加元素方法
		return add(size, element);
	}

	@Override
	public Object remove(int index) {
		// 移除指定元素
		checkindex(index);
		Object old = (Object)slist[index];
		//移除元素的 后面元素往前移
		for (int i=index; i<size-1; i++){
			slist[i] = slist[i+1];
		}
		slist[size--]=null;
		return old;
	}

	@Override
	public void clear() {
		//清空线性列表
		if (size != 0){
			for (int i=0; i<size; i++){
				this.slist[i] = null;
			}
			size = 0;
		}
	}
	
	/**
	 * 判断传入的索引值是否合法
	 * @param index
	 */
	public void checkindex(int index){
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index "+index+" Size "+size);
		}
	}
}
