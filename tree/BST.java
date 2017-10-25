import java.util.*;

public class BST<K extends Comparable<K>> {
	private Node root;

	private class Node {
		private K key;
		private Node left, right;

		public Node(K key) {
			this.key = key;
		}
	}

	public void insert(K key) {
		root = insert(root, key);
	}

	private Node insert(Node n, K key) {
		if(n == null) return new Node(key);

		if(key.compareTo(n.key) == 0) return n;
		else if(key.compareTo(n.key) < 0) {
			if(n.left == null) n.left = new Node(key);
			else n.left = insert(n.left, key);
		} else {
			if(n.right == null) n.right = new Node(key);
			else n.right = insert(n.right, key);
		}
		return n;
	}

	public void traverse() {
		traverse(root);
	}

	private void traverse(Node n) {
		if(n == null) return;

		traverse(n.left);
		System.out.println(n.key);
		traverse(n.right);
	}

	public boolean contains(K key) {
		return contains(root, key);
	}

	private boolean contains(Node n, K key) {
		if(n == null) return false;

		if(key.compareTo(n.key) == 0) return true;
		else if(key.compareTo(n.key) < 0) return contains(n.left, key);
		else return contains(n.right, key);
	}

	public void delete(K key) {
		root = delete(root, key);
	}

	private Node delete(Node n, K key) {
		if(n == null) return n;

		if(key.compareTo(n.key) == 0) {
			if(n.left == null && n.right == null) return null;
			else if(n.left == null) return n.right;
			else if(n.right == null) return n.left;
			else {
				Node successor = n.right;
				while(successor.left != null) successor = successor.left;
				n.key = successor.key;
				successor = delete(successor, successor.key);
			}
		} else if(key.compareTo(n.key) < 0) n.left = delete(n.left, key);
		else n.right = delete(n.right, key);

		return n;
	}

	public K min() {
		if(isEmpty()) throw new NoSuchElementException("Cannot find the minimum of an empty BST");

		Node min = root;
		while(min.left != null) min = min.left;
		return min.key;
	}

	public K max() {
		if(isEmpty()) throw new NoSuchElementException("Cannot find the maximum of an empty BST");

		Node max = root;
		while(max.right != null) max = max.right;
		return max.key;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Sorts the keys in this BST.
	 * @return a sorted list of the keys in the BST
	 */
	public List<K> sort() {
		return sort(root);
	}

	private List<K> sort(Node n) {
		if(n == null) return new ArrayList<>();

		List<K> sorted = sort(n.left);
		sorted.add(n.key);
		sorted.addAll(sort(n.right));
		return sorted;
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(9);
		bst.delete(9);
		System.out.println(bst.sort());
		System.out.println(bst.min());
		System.out.println(bst.max());
	}
}