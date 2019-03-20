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


///DUTCH
public static int[] partitionDutch(int[] data, int lo, int hi){
    int l = lo;
    int g = hi;
    int i = l + 1;
    int pivot = lo;
    while (i <= g) {
      if (data[i] < data[pivot]) {
        //basically the same algo as origionally, except now we jiust inceremnt i when equal
        swap(data,l,i);
        l++;
        i++;
        pivot++;
      } else if (data[i] == data[pivot]) {
        i++;
      }
      else {
        swap(data,g,i);
        g--;
      }
    }
    return new int[] {l,g};
  }
  public static void quicksort(int[] data){
    quicksortD(data,0,data.length - 1);
  }




  public static void quicksort(int[] data, int low, int hi){
    if(low >= hi){
      return;
    }
    int p = partition(data, low, hi);
    quicksort(data, low, p -1);
    quicksort(data, p + 1, hi);
  }

  public static void quicksortD(int[] data, int lo, int hi){
      if (lo >= hi) {
        return;
      }

      if (lo > hi - 20){
        insertionSort(data, lo, hi);
      } else {
      int[] pivot = partitionDutch(data, lo, hi);
      quicksortD(data, lo, pivot[0]-1);
      quicksortD(data, pivot[1]+1, hi);
    }
    }


    public static void insertionSort(int[] ary, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
          int orig = ary[i];
          int cur = i;
          while(cur != 0 && ary[cur-1] > orig){
            ary[cur] = ary[cur - 1]; //shift
            cur --;
          }
          ary[cur] = orig;
        }
        //System.out.prinln(ary);
      }






}
