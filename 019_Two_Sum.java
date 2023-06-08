//Brute: TC: O(N^N) & SC: O(1)

/*
      arr = {1,2,3,4,5,6} iterate from i=0 to n-1
                          iterate form j=i+1 to n
                          if arr[i] + arr[j] == target return value
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        int n = nums.length;
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {};
    }
}

//Better: TC: O(N) & SC: O(N)

/*
  Store the given element into hashmap along with its index.
  when ever an element comes such that HashMap contains the target - element print the indexes of those two elements.
*/

    public static int[] twoSum(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(arr[i], i);
        }
        return ans;
    }

//Optimal: TC: O(N) & SC: O(1)

/*
  Sort the array and take two pointer form low= 0 and end = n-1;
  untill low>end if arr[low] + arr[end] == target then print else if(sum > s) end --; else low++
*/
public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> sol = new ArrayList<>();

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == s) {
                sol.add(new int[]{arr[left], arr[right]});
            }
            else if (sum < s) left++;
            else right--;
        }

        return sol;
    }
