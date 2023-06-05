// Brute: TC: O(NLOGN) & SC: O(1)

/*
  1. Sort the array and iterate the array from 0 to n-1 and check if arr[i] == arr[i+1].
  2. Store the element on meeting the condition and return it from the function.
*/

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        Collections.sort(arr);

        int temp = 0;;
        for(int i=0; i<n-1; i++){
            if(arr.get(i) == arr.get(i+1)){
                temp = arr.get(i);
            }
        }

        return temp;
    }
}

