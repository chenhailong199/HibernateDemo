package com.datastructure.test;

import com.datastructure.dao.Stack;
import com.datastructure.dao.impl.StackImpl;

public class StackTest {
	public static void main(String[] args) {
		String s ="sdf)sthtye(jurkyltk";
		boolean flag = isSymmetry(s);
		System.out.println("小括号是否匹配:"+flag);
	}
	
	public static boolean isSymmetry(String args){
		Stack ss = new StackImpl();
		int size = args.length();
		for (int i=0; i<size; i++){
			char c = args.charAt(i);
			switch(c){
			case 40:
				ss.push("(");
				break;
			case 41:
				if (! ss.isEmpty()){
					if ("(".equals(ss.pop())){
						return true;
					}
				}
				break;
			}
			
		}
		return false;
	}
}
