public class CountingSort {
	public static int[] countingSort(int[] unsorted) {
		int maxValue = max(unsorted);

		// Count occurrences of each value in unsorted
		int[] counts = new int[maxValue + 1];

		for(int value : unsorted)
			counts[value]++;

		for(int i = 1; i < counts.length; i++)
			counts[i] += counts[i - 1];

		// Reorder values in unsorted
		int[] sorted = new int[unsorted.length];
		for(int value : unsorted) {
			counts[value] -= 1;
			int index = counts[value];
			sorted[index] = value;
		}

		return sorted;
	}

	private static int max(int[] array) {
		int max = Integer.MIN_VALUE;

		for(int value : array) {
			if(value > max) max = value;
		}

		return max;
	}

	public static void main(String[] args) {
		int[] unsorted = {5, 5, 5, 4, 3, 2, 1, 0};
		int[] sorted = countingSort(unsorted);
		for(int value : sorted)
			System.out.println(value);
	}
}