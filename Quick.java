import java.util.*;
import java.lang.*;

public class Quick{
  private static void swap(int[] data, int i, int j){
    int k = data[i];
    data[i] = data[j];
    data[j] = k;
  }
    public static int partition(int[] data, int start, int end){
      int pivot = (int)(Math.random() * (end - start + 1)) + start;
      //swap pivot to the first number of index
      if (pivot != start){
        swap(data,start,pivot);
        pivot = start;
        start++;
      }
      while (start != end){

        if (data[start] > data[pivot]){
          swap(data,start, end);
          end--;
        }

        else{
          start++;

        }
      }
      //swap pivot with start if pivot is less than
      if (data[start] <= data[pivot]) {
       swap(data,pivot,start);
       pivot = start;
      }
      else {
       swap(data,pivot,start-1);
       pivot = start-1;
      }

      return pivot;
    }

public static int quickselect(int[] data, int n){
  int lo = 0;
  int hi = data.length - 1;

  int pivot = partition(data,lo,hi);
  while(n != pivot) {

    if (n < pivot){
      hi = pivot-1;
    }

    if (n > pivot){
      lo = pivot+1;
    }
    pivot = partition(data,lo,hi);
  }
  return data[n];
}



  public static void quicksort(int[] data, int low, int hi){
    if(low >= hi){
      return;
    }
    int p = partition(data, low, hi);
    quicksort(data, low, p -1);
    quicksort(data, p + 1, hi);
  }

  public static void quicksort(int[] data){
    quicksort(data,0,data.length - 1);
  }





}
