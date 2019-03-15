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
    while(end > start){
      if(data[start] > data[pivot]){
        if(data[end] < data[pivot]){
          swap(data, end, start);
          start++;
        }
        end--;
      }
      //after start is in the beginning
      /*if(data[start] >= data[pivot]){
        if(data[start] == data[pivot]){
          dupcounter ++;
        }
        //if start is bigger than or equal to pivot
        if(data[end] < data[pivot]){
          //if end is lower sqap start and end
          swap(data, start, end);
          //then move start up (end moves at the end anyway)
          start++;
        }
      end--;
      }else{
        start++;
      }
    }
    swap(data, start, pivot);
    return pivot;
    //return value is off

  }*/


  public static void quickSort(int[] data, int low, int hi){
    if(low >= hi){
      return;
    }
    int p = partition(data, low, hi);
    quickSort(data, low, p -1);
    quickSort(data, p + 1, hi);
  }


}
