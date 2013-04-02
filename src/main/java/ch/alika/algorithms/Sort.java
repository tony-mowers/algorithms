package ch.alika.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

	public static <T> void insertionSort(T[] a, Comparator<T> c) {
		for (int i = 1; i < a.length; i++) {
			T key = a[i];
			int j = i - 1;
			while (j >= 0 && c.compare(a[j], key) == 1) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public static <T> void mergeSort(T[] a, Comparator<T> c) {
		mergeSort(a, c, 0, a.length - 1);
	}

	private static <T> void mergeSort(T[] a, Comparator<T> c, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, c, p, q);
			mergeSort(a, c, q + 1, r);
			merge(a, c, p, q, r);
		}
	}

	private static <T> void merge(T[] a, Comparator<T> c, int p, int q, int r) {
		T left[] = Arrays.copyOfRange(a, p, q + 1);
		T right[] = Arrays.copyOfRange(a, q + 1, r + 1);
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (j == right.length || (i < left.length && c.compare(right[j], left[i]) == 1)) {
				a[k] = left[i++];
			} else {
				a[k] = right[j++];
			}
		}
	}
}
