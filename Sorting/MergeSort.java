package Sorting;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] arr = new int[]{4,3,2,1,5};
    mergeSort(arr);
    for (int a : arr) {
      System.out.println(a);
    }
  }

  public static void mergeSort(int[] arr) {
    int n = arr.length;
    if (n <= 1) {
      return;
    }
    int mid = n / 2;

    int[] Left = Arrays.copyOfRange(arr, 0, mid);
    int[] Right = Arrays.copyOfRange(arr, mid, n);

    mergeSort(Left);
    mergeSort(Right);

    int i = 0, j = 0, k = 0;
    while (i < Left.length && j < Right.length) {
      if (Left[i] < Right[j]) {
        arr[k] = Left[i++];
      } else {
        arr[k] = Right[j++];
      }
      k++;
    }

    while (i < Left.length) {
      arr[k++] = Left[i++];
    }

    while (j < Right.length) {
      arr[k++] = Right[j++];
    }
  }

}
