#include <iostream>
using namespace std;

int length;

int left(int i) {
	return 2 * i;
}

int right(int i) {
	return 2 * i + 1;
}

// Fix violation of heap property at a particular index
void max_heapify(int* S, int i) {
	// If node is a leaf, terminate
	if(i > length / 2)
		return;

	// Indices of children
	int l = left(i);
	int r = right(i);

	int largest = i;

	// Test left child
	if(l <= length && S[l] > S[i])
		largest = l;

	// Test right child
	if(r <= length && S[r] > S[largest])
		largest = r;

	// Only swap if there is a violation (current node < child)
	if(largest != i) {
		// Swap parent and child
		int child = S[largest];
		S[largest] = S[i];
		S[i] = child;

		// Recurse on child
		max_heapify(S, largest);
	}
}

void build_max_heap(int* S) {
	for(int i = length / 2; i >= 1; --i) {
		max_heapify(S, i);
	}
}

void heapsort(int* S) {
	build_max_heap(S);

	int heapSize = length;

	int sorted[length + 1];
	int i = 1;

	while(length > 0) {
		int max = S[1];
		sorted[i] = max;
		++i;

		// Swap first and last elements in heap
		S[1] = S[length];
		S[length] = max;

		// Decrement heap size by 1
		--length;

		// Fix possible violation in root node
		max_heapify(S, 1);
	}

	length = heapSize;

	// Copy sorted array into original
	for(int j = 1; j <= length; ++j)
		S[j] = sorted[j];
}

int main() {
	cout << "Enter the number of values you wish to input: ";
	cin >> length;

	// Create array with extra element to preserve one-based counting of heap
	int S[length + 1];
	// Set extra element to zero
	S[0] = 0;

	for(int i = 1; i <= length; ++i) {
		cout << "Number " << i << ": ";
		cin >> S[i];
	}

	heapsort(S);

	for(int i = 1; i <= length; ++i) {
		cout << S[i] << " ";
	}
	cout << "\n";

	return 0;
}