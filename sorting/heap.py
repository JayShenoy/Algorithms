def left(i):
	return 2 * i

def right(i):
	return 2 * i + 1

def max_heapify(S, i):
	# If current node is leaf, terminate
	if i > length / 2:
		return

	l = left(i)
	r = right(i)

	largest = i

	if l <= length and S[l] > S[i]:
		largest = l

	if r <= length and S[r] > S[largest]:
		largest = r

	if largest != i:
		# Swap parent and child
		child = S[largest]
		S[largest] = S[i]
		S[i] = child

		# Recurse on child
		max_heapify(S, largest)

def build_max_heap(S):
	for i in range(length / 2, 0, -1):
		max_heapify(S, i)

def heapsort(S):
	build_max_heap(S)
	sorted = []

	# Allow reassignment of global variable
	global length

	while length > 0:
		max = S[1]
		sorted.append(max)

		# Swap first and last elements
		S[1] = S[length]
		S[length] = max

		# Decrement heap size by one
		length -= 1

		# Fix possible violation in root node
		max_heapify(S, 1)

	return sorted

length = input("Enter the number of values you wish to sort: ")
S = [0]
for i in range(length):
	S.append(input("Number %s: " % (i + 1)))

sorted = heapsort(S)
print sorted