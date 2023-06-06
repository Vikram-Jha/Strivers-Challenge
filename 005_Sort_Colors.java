/*
    Brute:  TC: O(NLOGN) & SC: O(N)
    Sort the array, in this case, elements align in ascending sorting order.
*/

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

/*
    Better: TC: O(N) & SC: O(!)
    Counting sort, take 3 variables as count0, count1 and count2 then traverse through the array and count the numbers of zeros, ones and twos and print it using another traversal.
*/

public class Solution 
{
    public static void sort012(int[] arr)
    {
        int n = arr.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                count0++;
            }
            if(arr[i] == 1){
                count1++;
            }
            if(arr[i] == 2){
                count2++;
            }
        }

        int j =0;
        while(count0>0){
            arr[j++] = 0;
            count0--;
        }

        while(count1>0){
            arr[j++] = 1;
            count1--;
        }

        while(count2>0){
            arr[j++] = 2;
            count2--;
        }
    }
}

/*
    Optimal: TC: O(N) & SC: O(1)
    We start with the assumption that :

    All the elements form 0 to low-1 : 0
    All the elements from low to mid-1 : 1 
    All the elements from high+1 to N : 2

    Implementation:
    Initially start with low, mid = 0 and high = nums.length-1;

    Case 1: When an element is zero
    Swap(mid,low)
    Increment mid and low;

    Case 2: When an element is one
    Increment mid

    Case 3: When an element is two
    swap(mid,high)
    Decrement high
    
    Ex: nums = 2,0,2,1,1,0

			       low,m 			                      high
Pass 1: 			2     0     2      1      1      0

			       low,m 		                high
Pass 2: 			0     0     2      1      1      2		→ swap(0,2) , dec high

			             low,m              high
Pass 3: 			0     0     2      1      1      2		→ swap(0,0) , inc low and mid

			                   low,m         high
Pass 4: 			0     0     2      1      1      2		→ swap(2,1) , dec high

			                   low,m  high
Pass 4: 			0     0     1      1      2      2		→ inc mid

			                   low   m,high
Pass 5: 			0     0     1      1      2      2		→ inc mid

			                    low   high    m
Pass 6: 			0     0     1      1      2      2		→ mid>high stop iteration
*/


class Solution {
    public void sortColors(int[] nums) {
        
        int mid =0, low =0;
        int high = nums.length-1;
        
        while(mid<=high){
            if(nums[mid] == 0){
                int temp  = nums[mid];
                nums[mid++] = nums[low];
                nums[low++] = temp;
            } else if(nums[mid] == 2){
                int temp  = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            } else mid++;
        }
    }

}
