//Brute: TC: O(N^2) & SC: O(1)

/*
  1. Iterate from 0 to n-1 as i.
  2. Iterate from i+1 to n as j.
  3. When arr[j] > arr[i] calculate diff and compare with maxDiff.
 */

  public static int maximumProfit(ArrayList<Integer> prices){
        int maxDiff = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.size()-1; i++){
            int diff =0;
            for(int j=i+1; j<prices.size(); j++){
                if(prices.get(i)<prices.get(j)){
                    diff = prices.get(j) - prices.get(i);
                    maxDiff = maxDiff < diff ? diff : maxDiff;
                }
            }
        }


        return maxDiff < 0 ? 0: maxDiff;
    }

//Optimal: TC: O(N) & SC: O(1)

/*
  1. Take a variable which will store the subsequent minPrice and set it to max Positive value.
  2. Take a variabe which wil store the maxProfit.
  3. For i =0 - n if arr[i] < minPrice set minPrice = arr[i].
  4. For each iteration check maxProfit > arr[i] - minPrice if yes set maxProfit as arr[i] - minPrice
 */

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.size(); i++){
            minPrice = prices.get(i) < minPrice? prices.get(i) : minPrice;
            maxProfit = (prices.get(i) - minPrice) > maxProfit ? 
                        (prices.get(i) - minPrice) : maxProfit;
        }


        return maxProfit< 0 ? 0: maxProfit;
    }
}
