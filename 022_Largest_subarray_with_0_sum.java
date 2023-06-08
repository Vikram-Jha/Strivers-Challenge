//Brute: TC: O(N^2) & SC: O(1)

/*
    for(i = 0 to n)
      for(j = i to n)
        sum = sum + arr[i]
          if sum == 0  set maxSub as j-i + 1 but only if this value is greater that maxSub
*/

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		    int maxSub = 0;
        for(int i=0; i<arr.size(); i++){
            int sum = 0;
            for(int j=i; j<arr.size(); j++){
                sum = sum + arr.get(j);
                if(sum == 0){
                    int temp = j - i + 1;
                    maxSub = temp > maxSub? temp : maxSub;
                }
            }
        }
        return maxSub;
	}
}

// Better

