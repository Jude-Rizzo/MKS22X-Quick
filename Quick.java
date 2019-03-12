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
    start++;
    while(end > start){
      //after start is in the beginning
      if(data[start] >= data[n]){
        swap(data, start, end);
        end--;
      }else{
        if(data[start] < data[n]){
          swap(data, n, start);
          start++;
          n++;

        } else{
          start++;
        }
      }
    }
    return n;
  }



}
