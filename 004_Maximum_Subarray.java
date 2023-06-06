/*
    Brute:
*/

/*
    Better:
*/

/*
    Optimal: TC: 0(N) & SC: O(1)
    
    Kadane's Algorithm:
      1. Calculate sum value in each iteration. if sum > maxsum assign maxsum = sum
      2. If in any iteration sum < 0 then assign sum = 0.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum= Integer.MIN_VALUE;
        int sum =0;
        
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            maxSum = maxSum > sum ? maxSum : sum;
            sum = sum<0 ? 0 : sum;
        }
        
        return maxSum > 0 ? maxSum : sum;
    }
}
