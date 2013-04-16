package ch.alika.algorithms;

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

	
	public static <T> void heapSort(T[] a, Comparator<T> c) {
		Heap<T> heap = new Heap<T>(a,c);
		heap.sort();
	}
	
	public static <T> void mergeSort(T[] a, Comparator<T> c) {
		MergeSort.sort(a,c);
	}

}
