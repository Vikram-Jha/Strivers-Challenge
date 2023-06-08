//Brute: TC:O(N^2) & SC:(1)

/*
  We will run a loop that will select the elements of the array one by one.
  Now, for each unique element, we will run another loop and count its occurrence in the given array.
  If any element occurs more than the floor of (N/3), we will include it in our answer. 
  While traversing if we find any element that is already included in our answer, we will just skip it.
*/
public class Solution {
    public static List<Integer> majorityElement(int []v) {
        int n = v.length; 
        List<Integer> ls = new ArrayList<>(); 

        for (int i = 0; i < n; i++) {
            if (ls.size() == 0 || ls.get(0) != v[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (v[j] == v[i]) {
                        cnt++;
                    }
                }
              
                if (cnt > (n / 3))
                    ls.add(v[i]);
               }
            if (ls.size() == 2) break;
        }

        return ls;
    }

//Better: TC:O(N) & SC:0(N)
  
/*
  HashMap or hashing concept used.
*/
  
class Solution {
    public List<Integer> majorityElement(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int value = freq.getOrDefault(arr[i], 0);
            freq.put(arr[i], value+1);
        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> element : freq.entrySet()){
            if(element.getValue() > arr.length/3)
                list.add(element.getKey());
        }

        return list;
    }
}
  
//Optimal: TC: O(N) & SC:O(1)
  
/*
  Moore's Voting algo's variation
*/

class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int el1 = 0;
        int cnt1 = 0;
        int el2 = 0;
        int cnt2 = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if (cnt1 == 0 && el2 != arr[i]) {
                cnt1 = 1;
                el1 = arr[i];
            }
            else if (cnt2 == 0 && el1 != arr[i]) {
                cnt2 = 1;
                el2 = arr[i];
            }
            else if (arr[i] == el1) cnt1++;
            else if (arr[i] == el2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<arr.length; i++){
            if(el1 == arr[i])  cnt1++;
            if(el2 == arr[i])  cnt2++;
        }
        
        if(el1 == el2 && el1 == 0){
            list.add(el1);
            return list;
        }
        if(cnt1 > arr.length/3) list.add(el1);
        if(cnt2 > arr.length/3) list.add(el2);

        return list;
    }
}
