class BST:
	def __init__(self, list=[]):
		self.root = None

		for value in list:
			self.insert(value)

	def insert(self, key):
		new_node = Node(key)

		if self.root is None:
			self.root = new_node
			return

		current = self.root

		while True:
			if key < current.key:
				if current.left is None:
					current.left = new_node
					new_node.parent = current
					break
				else:
					current = current.left
			else:
				if current.right is None:
					current.right = new_node
					new_node.parent = current
					break
				else:
					current = current.right

	def find(self, key):
		current = self.root

		while current is not None:
			if current.key == key:
				return current
			elif key < current.key:
				current = current.left
			else:
				current = current.right

		# Return None if key could not be found
		return None

	# Deletes the minimum value in the BST and returns it
	def delete_min(self):
		"""Delete the minimum value in the BST and return it."""
		if self.root is None:
			return None

		# Navigate to leftmost node
		current = self.root
		while current.left:
			current = current.left

		if current.parent:
			current.parent.left = current.right
		else: # If current node is root
			self.root = current.right

		if current.right:
			current.right.parent = current.parent

		# Remove min node
		current.disconnect()
		# Return min value
		return current.key

	def sort(self):
		"""Return a sorted list of the BST's keys."""
		self.list = []
		# Traverse the BST using DFS, appending keys along the way 
		self.traverse(self.root)
		return self.list

	def traverse(self, node):
		if node is None:
			return

		self.traverse(node.left)
		self.list.append(node.key)
		self.traverse(node.right)

class Node:
	def __init__(self, key):
		self.key = key
		self.disconnect()

	def disconnect(self):
		self.parent = None
		self.left = None
		self.right = None

length = input('Enter the number of values you wish to sort: ')
unsorted = []
for i in range(length):
	unsorted.append(input('Number %s: ' % (i + 1)))

bst = BST(unsorted)
sorted = bst.sort()
print sorted