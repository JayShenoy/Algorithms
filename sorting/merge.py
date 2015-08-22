def merge(left, right):
	# Merged array
	a = []

	# Iterators for left and right arrays
	l = 0
	r = 0

	while l < len(left) and r < len(right):
		if left[l] <= right[r]:
			a.append(left[l])
			l += 1
		elif right[r] < left[l]:
			a.append(right[r])
			r += 1

	# Add remaining values to the merged array
	a.extend(left[l:])
	a.extend(right[r:])

	return a

def merge_sort(a):
	if len(a) == 1:
		return a

	mid = len(a) / 2

	left = merge_sort(a[:mid])
	right = merge_sort(a[mid:])
	return merge(left, right)

a = []
length = input('Please enter the number of values you wish to sort: ')

for i in range(0, length):
	a.append(input('Number %s: ' % (i + 1)))

a = merge_sort(a)
print a