//Brute: TC:0(N^2) & SC: 0(1)

/*
  We will run a loop that will select the elements of the array one by one.
  Now, for each element, we will run another loop and count its occurrence in the given array.
  If any element occurs more than the floor of (N/2), we will simply return it.
*/

public class Solution {
	public static int findMajority(int[] arr, int n) {
	  for (int i = 0; i < n; i++) {
          int count = 0;
          for (int j = 0; j < n; j++) {
            if (arr[j] == arr[i]) {
              count++;
            }
          }
          if (count > (n / 2))                        // check if frquency is greater than n/2:
          return arr[i];
    }
    return -1;
  }
}

//Better: TC: O(N)  & SC: O(arr[i]~10^5)

/*
  Hashing we can find the occurrence of each element and check if occurence is greater than n/2. If yes return the element.
*/

    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int temp[] = new int[100001];

        for(int i=0; i<arr.size(); i++){
            temp[arr.get(i)]++;
        }

        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < 100001; i++) {
            if(temp[i] > arr.size()/3)
                sol.add(i);
        }

        return sol;
    }

public class Solution {
	public static int findMajority(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
	}
}

//Optimal:   Moore’s Voting Algorithm: TC: O(N) & SC: O(1)

/*
      1. Take two variable majEle and count. Iterate from 0 to n-1.
      2. If count  = 0 take majEle = arr[i] and count = 1, else if(arr[i] == majEle) count++, else count--.
      3. take another count2 and check if for majEle the count2 > n/2 if true return majEle.
      4. Else return -1.
*/

class Solution {
  public int majorityElement(int[] arr) {
		int n = arr.length;
    int count = 0;
		int majEle =0;
	
    for (int i = 0; i < n; i++) {
    	if(count == 0){
			  majEle = arr[i];
					count = 1;
				}
			else if(arr[i] == majEle)
				count++;
			else
				count--;
    }
		
		int count2 = 0;
    for (int i = 0; i < n; i++) 
      if (arr[i] == majEle)
				count2++;
        
		if(count2 > n/2)
			return majEle;

    return -1;
  }
}
