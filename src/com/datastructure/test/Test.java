package com.datastructure.test;

import com.datastructure.dao.LinearList;
import com.datastructure.dao.impl.LinearListImpl;

public class Test {
	public static void main(String[] args) {
		LinearList list = new LinearListImpl(6);
		list.add(0, "张三");
		list.add(1, "李四");
		list.add(2, "王五");
		list.add(3, "马六");
		list.add(4, "陈七");
		System.out.println("list.size() : "+list.size());
		System.out.println("list.get(3) : "+list.get(3));
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("=================");
		list.add(2, "李达康");
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("list.size() : "+list.size());
		System.out.println(Integer.MAX_VALUE);
	}
}
