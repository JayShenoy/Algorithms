#include <iostream>
using namespace std;

void merge(int* a, int start, int mid, int end) {
  int* b = new int[end - start];

  // Indices for left and right arrays
  int l = start;
  int r = mid;

  // Index for merged array
  int i = 0;

  while(l < mid && r < end) {
    if(a[l] <= a[r]) {
      b[i] = a[l];
      l++;
    }
    else if(a[r] < a[l]) {
      b[i] = a[r];
      r++;
    }

    i++;
  }

  // Add the remaining values to the end of the merged array
  while(l < mid) {
    b[i] = a[l];
    l++;
    i++;
  }

  while(r < end) {
    b[i] = a[r];
    r++;
    i++;
  }

  // Copy the merged array into the original array
  for(i = 0; i < end - start; i++)
    a[i + start] = b[i];
}

void mergeSort(int* a, int start, int end) {
  if(end == start + 1)
    return;

  int mid = (start + end) / 2;

  mergeSort(a, start, mid);
  mergeSort(a, mid, end);
  merge(a, start, mid, end);
}

int main() {
  int length;
  cout << "Enter the number of values to be sorted:\n";
  cin >> length;

  int a[length];

  for(int i = 0; i < length; ++i) {
    cout << "Number " << (i + 1) << ":\n";
    cin >> a[i];
  }

  mergeSort(a, 0, length);

  // Display sorted array
  for(int i = 0; i < length; ++i)
    cout << a[i] << " ";
  cout << "\n";

  return 0;
}
