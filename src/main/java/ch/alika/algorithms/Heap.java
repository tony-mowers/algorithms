package ch.alika.algorithms;

import java.util.Comparator;

public class Heap<T> {
    private T[] data;
    private int lastHeapIndex;
    private Comparator<T> comparator;

    public Heap(T[] data, Comparator<T> c) {
        this.data = data;
        this.comparator = c;
        this.lastHeapIndex = data.length - 1;
        buildHeap();
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

    private void heapify(int rootIndex) {
        int highest = highestPriorityItem(rootIndex, leftChildIndex(rootIndex),
                rightChildIndex(rootIndex));

        if (highest != rootIndex) {
            swap(highest, rootIndex);
            heapify(highest);
        }

    }

    private int highestPriorityItem(int i, int j, int k) {
        int highest = i;

        if (isHigherPriorityItem(i, j))
            highest = j;

        if (isHigherPriorityItem(highest, k))
            highest = k;

        return highest;
    }

    private boolean isInHeap(int i) {
        return i <= lastHeapIndex;
    }

    private boolean isHigherPriorityItem(int referenceIndex, int index) {
        return isInHeap(index)
                && comparator.compare(data[index], data[referenceIndex]) == 1;
    }

    private int parent(int childIndex) {
        return (childIndex + 1) / 2 - 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    private int leftChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2 - 1;
    }

    public int size() {
        return lastHeapIndex + 1;
    }

    public T top() {
        if (size() < 1)
            throw new HeapUnderflowException();

        return data[0];
    }

    public T pop() {
        if (size() < 1)
            throw new HeapUnderflowException();

        T top = data[0];
        data[0] = data[lastHeapIndex--];
        heapify(0);

        return top;
    }
}
