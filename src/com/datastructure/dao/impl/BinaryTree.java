package com.datastructure.dao.impl;

/**
 * @author Administrator
 * 实现二叉树
 */
public class BinaryTree {
    protected TreeNode root;
    public BinaryTree(){
    	root = null;
    }
    
    
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	

	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public String toString(){
		return root.toString();
	}
	public boolean isEmpty(){
		return this.root==null;
	}
    
}
