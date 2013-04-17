package ch.alika.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    public static <T> void sort(T[] data, Comparator<T> comparator) {
        mergeSort(data, comparator, 0, data.length - 1);
    }

    private static <T> void mergeSort(T[] data, Comparator<T> comparator,
            int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(data, comparator, leftIndex, middleIndex);
            mergeSort(data, comparator, middleIndex + 1, rightIndex);
            merge(data, comparator, leftIndex, middleIndex, rightIndex);
        }
    }

    private static <T> void merge(T[] a, Comparator<T> comparator,
            int leftIndex, int middleIndex, int rightIndex) {
        T leftData[] = Arrays.copyOfRange(a, leftIndex, middleIndex + 1);
        T rightData[] = Arrays.copyOfRange(a, middleIndex + 1, rightIndex + 1);
        int i = 0;
        int j = 0;
        for (int k = leftIndex; k <= rightIndex; k++) {
            if (leftGreaterThanRight(comparator, leftData, i, rightData, j)) {
                a[k] = leftData[i++];
            } else {
                a[k] = rightData[j++];
            }
        }
    }

    private static <T> boolean leftGreaterThanRight(Comparator<T> c,
            T[] leftData, int leftIndex, T[] rightData, int rightIndex) {
        return rightIndex == rightData.length
                || (leftIndex < leftData.length && c.compare(
                        rightData[rightIndex], leftData[leftIndex]) == 1);
    }
}
