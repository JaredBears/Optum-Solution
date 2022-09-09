package com.jaredbears.optum;

import java.util.Arrays;
import java.util.HashSet;

public class CheckElements {

  /*
   * sortSolution uses less memory, but takes more time because it has to sort and then
   * loop through the array 
   */
  boolean sortSolution(int[] arr) {
    if (arr.length <= 2) {
      return baseCase(arr);
    } else {
      Arrays.sort(arr);
      if(arr.length % 2 == 0 && Math.abs(arr[arr.length-1] - arr[arr.length-2]) == 1) {
        return true;
      }
      /* 
       * Since the loop only checks every other number, it will miss the last elements if even.
       * The above conditional takes care of that.  This will cut the time in half, or better.
       */
      for (int i = 1; i < arr.length - 1; i+=2) {
        if (Math.abs(arr[i] - arr[i - 1]) == 1 || Math.abs(arr[i] - arr[i + 1]) == 1) {
          return true;
        }
      }
      return false;
    }
  }

  /*
   * hashSolution takes less time, but uses more memory because it jumps straight to the loop but
   * stores the values in a set in addition to the array
   */

  boolean hashSolution(int[] arr) {
    if (arr.length <= 2) {
      return baseCase(arr);
    } else {
      HashSet<Integer> set = new HashSet<>();
      for(int i : arr) {
        set.add(i);
        if(set.contains(i-1) || set.contains(i+1)) {
          return true;
        }
      }
    }
    return false;
  }

  /*
   * base case for simple (length<=2) arrays.  Returns false for an array length of 1, or if the 
   * only two elements aren't adjacent
   */
  boolean baseCase(int[] arr) {
    if (arr.length == 2 && Math.abs(arr[1] - arr[0]) == 1) {
      return true;
    }
    return false;
  }
}
