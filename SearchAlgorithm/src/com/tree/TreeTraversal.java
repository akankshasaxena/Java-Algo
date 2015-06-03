package com.tree;

import java.util.LinkedList;

import com.tree.BinaryTree.BSTNode;

public class TreeTraversal {

	LinkedList<BSTNode> queue;
	
	public void depthPreFirstSearch(BSTNode root){
		if (root == null){
			return;
		}
		
		System.out.print(root.getData()+" ");
		depthPreFirstSearch(root.getLeftNode());
		depthPreFirstSearch(root.getRightNode());
	}
	public void depthInFirstSearch(BSTNode root){
		if (root == null){
			return;
		}
		
		depthInFirstSearch(root.getLeftNode());
		System.out.print(root.getData()+" ");
		depthInFirstSearch(root.getRightNode());
	}
	
	public void levelOrderTraverse(BSTNode root){
		if(root == null){
			return ;
		}
		if(queue == null){
			queue = new LinkedList<BSTNode>();
			queue.add(root);
		}
		
		while(queue != null && queue.size() > 0){
			BSTNode node = queue.poll();
			System.out.print(node.getData()+" ");
			
			if(node.getLeftNode() != null)
				queue.add(node.getLeftNode());
			
			if(node.getRightNode() != null)
				queue.add(node.getRightNode());
			
		}		
		
	}
	
	public boolean isBST(BSTNode root){
		boolean check = false;
		
		if(root == null){
			return true;
		}
		int max = getMax(root.getLeftNode());
		int min = getMin(root.getRightNode());
		
		if(root.getData() > max && root.getData() < min){
			check = true;
		}
		return check;
	}
	int min = -1;
	
	public  int getMin(BSTNode root) {
		if(root == null){
			return 0;
		}
		if(min == -1 || min > root.getData() ){
			min = root.getData(); 
		}
		getMin(root.getLeftNode());
		getMin(root.getRightNode());
		return min;
	}
	
	int max=-1;
	public  int getMax(BSTNode root) {
		if(root == null){
			return 0;
		}
		if(max ==  -1 || max < root.getData() ){
			max = root.getData(); 
		}
		getMax(root.getLeftNode());
		getMax(root.getRightNode());
		return max;
	}
	BSTNode parentNode = null;
	public BSTNode search(BSTNode root, int data){
		BSTNode node = null;
		if(root == null){
			return null;
		}
		
		if(root.getData() == data){
			return root;
		}
		
		if(data < root.getData()){
			node = search(root.getLeftNode(), data);
		}else{
			node = search(root.getRightNode(), data);
		}
		
		return node;
		
	}
	

	public BSTNode deleteNode(BSTNode root,int  data){
		BSTNode node = null;
		
		if(root.getData() == data){
			if (node.getLeftNode() == null && node.getRightNode() == null){
				
			}
		}else if(root.getData() > data){
			//search
		}
		return node;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeTraversal trver = new TreeTraversal();
		BSTNode root = null;
		root = tree.insertData(root, 15);
		tree.insertData(root, 5);
		tree.insertData(root, 20);
		tree.insertData(root, 25);
		tree.insertData(root, 3);
		tree.insertData(root, 30);
		tree.insertData(root, 40);
		tree.insertData(root, 10);
		tree.insertData(root, 60);
		tree.insertData(root, 135);
		tree.insertData(root, 2);
		tree.insertData(root, 22);
		tree.insertData(root, 20);
		
		trver.levelOrderTraverse(root);
		
		System.out.println("depth first Preorder tree traversal");
		trver.depthPreFirstSearch(root);
		
		System.out.println("\n"+"Inorder traveral");
		trver.depthInFirstSearch(root);
		
		/*boolean bst = trver.isBST(root);
		if(bst)
			System.out.println("It is a BST");
		else
			System.out.println("It is not  bst");*/
		
		BSTNode node = trver.search(root, 60);
		System.out.println(node.getLeftNode().getData() +" "+ node.getRightNode().getData());
	}
	
	

}
