import java.util.*;
import java.lang.*;

public class Quick{
  private static void swap(int[] data, int i, int j){
    int k = data[i];
    data[i] = data[j];
    data[j] = k;
  }
  public static int partition(int[] data, int start, int end){
    int n = (int)Math.random()*(end - start)+ start;
    swap(data, start, n);
    int pivot = start;
    int dupcounter = 0;
    //make an index at the beginning for the pivot point
    start++;
    while(end != start){
      if(data[start] > data[pivot]){
        if(data[end] < data[pivot]){
          swap(data, end, start);
          start++;
        }
        end--;
      } else {
        start++;

    }

  }
  return start;
}


public static int quickselect(int[] data, int k){
  int lo = 0;
  int hi = data.length - 1;
  
  int pivot = partition(data,lo,hi);
  while(k != pivot) {
    //if k is less than pivot look from beginning to the pivot
    if (k < pivot){
      hi = pivot-1;
    }
    //else start at the pivot and go to the hi
    if (k > pivot){
      lo = pivot+1;
    }
    pivot = partition(data,lo,hi);
    //System.out.println("Index: " + idx + " k: " + k + " lo: " + lo + " hi:" + hi);
    //System.out.println("toString: " + Arrays.toString(data));
  }
  return data[k];
}



  public static void quicksort(int[] data, int low, int hi){
    if(low >= hi){
      return;
    }
    int p = partition(data, low, hi);
    quicksort(data, low, p -1);
    quicksort(data, p + 1, hi);
  }


}
