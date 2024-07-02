package tree;

import java.util.Queue;
import java.util.LinkedList;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class TreeStart {

	public static void inOrder(Node root) {

		if (root == null) {
			return;

		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public static void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void postOrder(Node root) {
		if (root == null) {
			return;

		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static int countNUmberOfNOdes(Node root) {

		if (root == null) {
			return 0;

		}

		int leftNodes = countNUmberOfNOdes(root.left);
		int rightNodes = countNUmberOfNOdes(root.right);
		return leftNodes + rightNodes + 1;

	}

	public static void levelOrder(Node root) {

		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node currNode = q.remove();
//			System.out.println(currNode.data);
			if (currNode == null)

			{

				System.out.println();
				if (q.isEmpty()) {
					break;
				} else {

					q.add(null);
				}
			}

			else {
				System.out.print(currNode.data + " ");
				if (currNode.left != null) {
					q.add(currNode.left);
				}
				if (currNode.right != null) {
					q.add(currNode.right);
				}
			}
		}

	}

	public static int sumOfNode(Node root) {
		if (root == null) {
			return 0;
		}

		int count = root.data;

		int leftSum = sumOfNode(root.left);
		int rightSum = sumOfNode(root.right);
		return count + leftSum + rightSum;

	}

	public static int HeightOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = HeightOfTree(root.left);
		int rightHeight = HeightOfTree(root.right);
		int myHeigh = Math.max(leftHeight, rightHeight) + 1;
		return myHeigh;
	}

	public static int DiameterOfTree1(Node root) {
		if (root == null) {
			return 0;
		}

		int leftDia = DiameterOfTree1(root.left);
		int rightDia = DiameterOfTree1(root.right);
		int maxHeight = HeightOfTree(root.left) + HeightOfTree(root.right) + 1;
		int myDia = Math.max(Math.max(rightDia, leftDia), maxHeight);
		return myDia;

	}

	static class TreeInfo {

		int Dia, height;

		TreeInfo(int Dia, int height) {
			this.Dia = Dia;
			this.height = height;
		}
	}

	public static TreeInfo DiameterOfTree2(Node root) {

		if (root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo left = DiameterOfTree2(root.left);
		TreeInfo right = DiameterOfTree2(root.right);
		int myHeight = Math.max(left.height, right.height) + 1;
		int Diam1 = left.Dia;
		int Diam2 = right.Dia;
		int Diam3 = left.height + right.height + 1;
		int myDia = Math.max(Math.max(Diam1, Diam2), Diam3);

		TreeInfo treeinfo = new TreeInfo(myDia, myHeight);
		return treeinfo;

	}

	public static boolean isIdentical(Node root, Node subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root == null || subRoot == null) {
			return false;

		}
		if (root.data == subRoot.data) {
			return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
		}

		return false;

	}

	public static boolean isSubtree(Node root, Node subRoot) {
		if (subRoot == null) {
			return true;
		}
		if (root == null) {
			return false;

		}

		if (root.data == subRoot.data) {
			if (isIdentical(root, subRoot)) {
				return true;
			}
		}

		return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		
		Node subRoot = new Node(3);
		subRoot.left=new Node(5);
		subRoot.right=new Node(6);

		inOrder(root);
		System.out.println();
		inOrder(subRoot);
//
		System.out.println();
//		preOrder(root);
//		System.out.println();
//		postOrder(root);
//		System.out.println();

//		System.out.println("The Number of Nodes are "+countNUmberOfNOdes(root));
//		levelOrder(root);

		System.out.println(sumOfNode(root));
		System.out.println(HeightOfTree(root));
		System.out.println(DiameterOfTree2(root).Dia);
		System.out.println(isSubtree(root, subRoot));

	}

}
