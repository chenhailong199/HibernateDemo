package com.datastructure.dao.impl;

public class Node {
	private Object nodeValue; //数据域
	private Node next;	//指针域
	public Node(){
		nodeValue = null;
		next = null;
	}
	public Node(Object item){
		nodeValue = item;
		next = null;
	}
	public Node(Object item, Node next){
		nodeValue = item;
		this.next = next;
	}
	public Object getNodeValue(){
		return nodeValue;
	}
	public void setNodeValue(Object nodeValue){
		this.nodeValue = nodeValue;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node next){
		this.next = next;
	}
}
