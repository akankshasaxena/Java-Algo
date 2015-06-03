package com.tree;

public class BinaryTree {
	
	public BSTNode insertData(BSTNode root, int data){
		if(root == null){
			root = getNewNode(data);
			return root;
		}
		if(data < root.getData()){
			root.setLeftNode(insertData(root.getLeftNode(),data));
		}else{
			root.setRightNode(insertData(root.getRightNode(),data));
		}
		return root;
			
	}
	
		
	private BSTNode getNewNode(int data){
		BSTNode node = new BSTNode();
		node.setData(data);
		return node;
	}
	
	public class BSTNode{
		private int data;
		private BSTNode leftNode;
		private BSTNode rightNode;
		
		int getData() {
			return data;
		}
		void setData(int data) {
			this.data = data;
		}
		BSTNode getLeftNode() {
			return leftNode;
		}
		void setLeftNode(BSTNode leftNode) {
			this.leftNode = leftNode;
		}
		BSTNode getRightNode() {
			return rightNode;
		}
		void setRightNode(BSTNode rightNode) {
			this.rightNode = rightNode;
		}
	}
}
