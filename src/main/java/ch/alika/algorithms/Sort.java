package ch.alika.algorithms;

import java.util.Comparator;

public class Sort {

	public static <T> void insertionSort(T[] data, Comparator<T> comparator) {
		for (int i = 1; i < data.length; i++) {
			T key = data[i];
			int j = i - 1;
			while (j >= 0 && comparator.compare(data[j], key) == 1) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = key;
		}
	}

	
	public static <T> void heapSort(T[] data, Comparator<T> comparator) {
		Heap<T> heap = new Heap<T>(data,comparator);
		while (heap.size() > 1) {
			data[heap.size() - 1] = heap.pop();
		}
	}
	
	public static <T> void mergeSort(T[] a, Comparator<T> comparator) {
		MergeSort.sort(a,comparator);
	}

}
