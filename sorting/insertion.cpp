#include <iostream>
using namespace std;

void insertionSort(int* a, int sizeOfArray) {
  for(int i = 1; i < sizeOfArray; ++i) {
    int current = a[i];

    for(int j = i - 1; j >= 0; --j) {
      int previous = a[j];

      if(current < previous) {
	a[j] = current;
	a[j + 1] = previous;
      }
      else
	break;
    }
  }
}

int main() {
  int sizeOfArray;
  cout << "Enter the number of values to be sorted:\n";
  cin >> sizeOfArray;

  int a[sizeOfArray];

  for(int i = 0; i < sizeOfArray; ++i) {
    cout << "Number " << (i + 1) << ":\n";
    cin >> a[i];
  }

  insertionSort(a, sizeOfArray);

  // Print out sorted array
  for(int i = 0; i < sizeOfArray; ++i)
    cout << a[i] << " ";
  cout << "\n";

  return 0;
}
