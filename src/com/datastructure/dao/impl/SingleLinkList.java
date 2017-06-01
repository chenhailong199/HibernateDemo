package com.datastructure.dao.impl;

import com.datastructure.dao.LinearList;

public class SingleLinkList implements LinearList{
	private Node node;
	
		
	public SingleLinkList() {
		node = null;
	}
	
	public SingleLinkList(Node node) {
		this.node = node;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return node==null;
	}

	@Override
	public int size() {
		int size = 0;
		Node p = this.node;
		while (p!=null){
			size++;
			p=p.getNext();
		}
		return size;
	}

	@Override
	public Object get(int index) {
		checkindex(index);
		Node p =this.node;
		for (int i=0; i<index; i++){
			p=p.getNext();
		}
		return (Object)p.getNodeValue();
	}

	@Override
	public void set(int index, Object element) {
		checkindex(index);
		Node p = this.node;
		for (int i=0; i<index; i++){
			p = p.getNext();
		}
		p.setNodeValue(element);
	}

	@Override
	public boolean add(int index, Object element) {
		// 在指定位置增加元素
		if (index < 0){
			throw new IndexOutOfBoundsException("Index "+index);
		}
		if (node == null){
			node = new Node(element);
		} else {
			Node p = this.node;
			if (index == 0){
				this.node = new Node(element, p);
			} else {
				int i=0;
				while (p.getNext() != null && i<index-1){
					i++;
					p = p.getNext();
				}
			p.setNext(new Node(element, p.getNext()));	
			}
		}
		return true;
	}

	@Override
	public boolean addlast(Object element) {
		
		return add(Integer.MAX_VALUE,element);
	}

	@Override
	public Object remove(int index) {
		checkindex(index);
		Object old = null;
		Node p = this.node;
		if (index == 0){
			old = (Object)node.getNodeValue();
			node = p.getNext();
			p = null;
		} else {
			int i = 0;
			while (p.getNext() != null && i<index -1){
				i++;
				p = p.getNext();
			}
			Node tmp = p.getNext();
			old = (Object)tmp.getNodeValue();
			p.setNext(tmp.getNext());
			tmp=null;
		}
		return old;
	}

	@Override
	public void clear() {
		node = null;
		
	}
	
	public void checkindex(int index){
		if (index < 0 || index > this.size()-1){
			throw new IndexOutOfBoundsException("Index "+index);
		}
	}
	

}
