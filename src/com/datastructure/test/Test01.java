package com.datastructure.test;

import com.datastructure.dao.impl.BinaryTree;
import com.datastructure.dao.impl.TreeNode;

public class Test01 {
	public static void main(String[] args) {
		for (int i=1; i<13; i++){
			int n = f(i);
			System.out.println("当前月份"+i+",兔子数:"+n);
		}
		
		BinaryTree tree = new  BinaryTree();
		System.out.println(tree.toString());
	}
	
	public static int f(int n){
		if (n<1){
			return 0;
		} else if (n==1 || n==2){
			return 1;
		} else {
			return f(n-1)+f(n-2);
		}
	}
	
	/**
	 * 构造二叉树
	 * @return
	 */
	public static BinaryTree create(){
		TreeNode a,b,c,d,e,f,g;
		g = new TreeNode("G");
		f = new TreeNode("F");
		d = new TreeNode("D");
		e = new TreeNode("E",f,g);
		b = new TreeNode("B",d,e);
		c = new TreeNode("C");
		a = new TreeNode("A",b,c);
		return new BinaryTree(a);
	}
	
}
