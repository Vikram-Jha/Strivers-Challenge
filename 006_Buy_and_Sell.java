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
