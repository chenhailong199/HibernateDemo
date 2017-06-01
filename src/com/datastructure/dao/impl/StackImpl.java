package com.datastructure.dao.impl;

import java.util.EmptyStackException;

import com.datastructure.dao.Stack;

public class StackImpl implements Stack{
	private LinearListImpl stackList;
	
	
	public StackImpl() {
		stackList = new LinearListImpl();
	}

	@Override
	public void push(Object item) {
		stackList.addlast(item);
		
	}

	@Override
	public Object pop() {
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return stackList.remove(stackList.size()-1);
	}

	@Override
	public Object peek() {
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return stackList.get(stackList.size()-1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stackList.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stackList.size();
	}
	
}
