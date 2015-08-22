#include <iostream>
using namespace std;

// Global variable for traversing BST and modifying array
int i;

struct node {
	int key;
	node* parent;
	node* left;
	node* right;
};

void insert(node* root, int key) {
	if(key < root->key) {
		if(root->left == nullptr) {
			root->left = new node;
			root->left->key = key;
			root->left->parent = root;
			root->left->left = nullptr;
			root->left->right = nullptr;
		}
		else
			insert(root->left, key);
	}
	else {
		if(root->right == nullptr) {
			root->right = new node;
			root->right->key = key;
			root->right->parent = root;
			root->right->left = nullptr;
			root->right->right = nullptr;
		}
		else
			insert(root->right, key);
	}
}

node* find(node* root, int key) {
	if(key < root->key) {
		if(root->left == nullptr)
			return nullptr;
		else if(root->left->key == key)
			return root->left;
		else
			return find(root->left, key);
	}
	else {
		if(root->right == nullptr)
			return nullptr;
		else if(root->right->key == key)
			return root->right;
		else
			return find(root->right, key);
	}
}

node* find_min(node* root) {
	node* min = root;
	while(min->left != nullptr)
		min = min->left;
	return min;
}

// Find minimum value in BST and delete that node
// root parameter is a pointer passed by reference because we may modify the root node
int delete_min(node*& root) {
	node* min = find_min(root);

	if(min->parent != nullptr)
		min->parent->left = min->right;
	else // In the case that min node is root
		root = min->right;

	if(min->right != nullptr)
		min->right->parent = min->parent;

	return min->key;
}

node* next_larger(node* current) {
	if(current->right != nullptr)
		return find_min(current->right);
	else {
		node* y = current->parent;
		while(y != nullptr && current == y->right) {
			current = y;
			y = y->parent;
		}
		return y;
	}
}

// Builds a binary search tree from an array and returns the root node
node* build_binary_tree(int* list, int length) {
	if(length == 0)
		return nullptr;

	node* root = new node;
	root->key = list[0];
	root->parent = nullptr;
	root->left = nullptr;
	root->right = nullptr;

	for(int i = 1; i < length; ++i)
		insert(root, list[i]);

	return root;
}

void traverse(node* current, int* list) {
	if(current == nullptr)
		return;

	traverse(current->left, list);
	list[i++] = current->key;
	traverse(current->right, list);
}

void bst_sort(int* list, int length) {
	// Build BST
	node* root = build_binary_tree(list, length);

	// Traverse the BST in order
	i = 0;
	traverse(root, list);
}

int main() {
	int length;

	cout << "Enter the number of values you wish to input: ";
	cin >> length;
	int list[length];

	for(int i = 0; i < length; ++i) {
		cout << "Number " << (i + 1) << ": ";
		cin >> list[i];
	}
	bst_sort(list, length);

	for(int i = 0; i < length; ++i)
		cout << list[i] << " ";
	cout << "\n";

	return 0;
}