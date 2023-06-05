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

// Better: TC: 0(N) & SC: O(N)

/*
  1. Use hashing. Since we know value of arr[i] in the range [0,N-1]. So, declare a new array temp of size n.
  2. for each occurance of an element increase the index of that element by one.
  3. traverse through temp array if temp[i] > 1 then that's repeating element return that element.
*/

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int temp[] = new int[n];
      
        for(int i=0; i<n; i++){
            temp[arr.get(i)]++;
        }
      
        int reqNo =0;
      
        for(int i=0; i<n; i++){
            if(temp[i] > 1){
                reqNo = i;
            }
        }
        return reqNo;
    }
}
