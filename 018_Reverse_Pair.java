// Brute: TC: O(N*N) & SC:O(1)

class Solution {
    public int reversePairs(int[] nums) {
        int count =0;
        for(int i = 0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > 2 * nums[j]){
                    count++;
                }
            }
        }

        return count;
    }
}

//Optimal: TC: O(N log N) & SC:O(N)

