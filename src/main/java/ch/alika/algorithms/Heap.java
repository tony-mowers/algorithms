package ch.alika.algorithms;

import java.util.Comparator;

public class Heap<T> {
	private T[] data;
	private int lastHeapIndex;
	private Comparator<T> comparator;
	
	public Heap(T[] data,Comparator<T> c) 
	{
		this.data = data;
		this.comparator = c;
		this.lastHeapIndex = data.length - 1;
		buildHeap();
	}

	public void sort() {
		while (lastHeapIndex >= 1) 
		{
			swap(0,lastHeapIndex);
			lastHeapIndex--;
			heapify(0);
		}
	}

	
	private void swap(int i, int j) {
		T temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private void buildHeap() {
		for (int i = parent(lastHeapIndex); i >= 0; i--) {
			heapify(i);
		}
	}
	
	private int parent(int i) {
		return (i + 1) / 2 - 1;
	}

	private void heapify(int i) {
		int highest = i;
		int l = left(i);
		int r = right(i);
		if ( isInHeap(l) && isHigherPriority(data[l],data[i]) )
			highest = l;
		
		if ( isInHeap(r) && isHigherPriority(data[r],data[highest]) )
			highest = r;
		
		if (highest != i) {
			swap(highest,i);
			heapify(highest);
		}
		
	}

	private boolean isInHeap(int i) {
		return i <= lastHeapIndex; 
	}

	private boolean isHigherPriority(T t1, T t2) {
		return comparator.compare(t1,t2) == 1;
	}

	private int right(int i) {
		return (i + 1)*2;
	}

	private int left(int i) {
		return (i + 1)*2 - 1;
	}
}
