public class CountingSort {
	public static int[] countingSort(int[] unsorted) {
		int minValue = min(unsorted);
		int maxValue = max(unsorted);

		// Adjust max so that min equals zero
		int offset = -minValue;
		int adjustedMax = maxValue + offset;

		// Count occurrences of each value in unsorted
		int[] counts = new int[adjustedMax + 1];

		for(int value : unsorted)
			counts[value + offset]++;

		for(int i = 1; i < counts.length; i++)
			counts[i] += counts[i - 1];

		// Reorder values in unsorted
		int[] sorted = new int[unsorted.length];
		for(int value : unsorted) {
			int index = --counts[value + offset];
			sorted[index] = value;
		}

		return sorted;
	}

	private static int min(int[] array) {
		int min = Integer.MAX_VALUE;

		for(int value : array)
			if(value < min) min = value;

		return min;
	}

	private static int max(int[] array) {
		int max = Integer.MIN_VALUE;

		for(int value : array)
			if(value > max) max = value;

		return max;
	}

	public static void main(String[] args) {
		int[] unsorted = {5, 5, 5, 4, 3, 2, 1, 0, -1, -2, -3, -3, -3};
		int[] sorted = countingSort(unsorted);
		for(int value : sorted)
			System.out.println(value);
	}
}