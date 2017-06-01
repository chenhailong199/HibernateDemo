package com.datastructure.dao.impl;

/**
 * @author Administrator
 *	树的节点
 */
public class TreeNode {
	private Object nodeValue;
	private TreeNode left,right;
	public TreeNode(){
		this(null, null, null);
	}
	public TreeNode(Object item){
		this(item, null, null);
	}
	
	
	
	public TreeNode(Object nodeValue, TreeNode left, TreeNode right) {
		super();
		this.nodeValue = nodeValue;
		this.left = left;
		this.right = right;
	}
	
	//判断是否为叶子
	public boolean isLeaf(){
		if (this.left==null && this.right==null){
			return true;
		}
		return false;
	}
	
	public String toString(){
		if (nodeValue==null){
			return null;
		}
		String  result ="(节点"+nodeValue.toString();
		if (left!=null){
			result += "左子树:"+left.toString();
		}
		if (right!=null){
			result += "右子树:"+right.toString();
		}
		result +=")";
		return result;
	}
	
	
}
