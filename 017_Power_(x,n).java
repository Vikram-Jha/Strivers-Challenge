//Brute: TC: O(N) & SC: O(1)

/*
  cause some test case to fail as passes 301/306 passed.
*/

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;

        if(x == 1)
            return 1;
        for (int i = 0; i < Math.abs(n); i++)
            ans = ans * x;
            
        return n<0 ? 1/ans : ans; 
    }
}

// Optimal: TC: O(N) & SC: O(1)

/*
  Avoiding the edge cases when we invert a no. from negative to positive we cause overflow because -2147483648 get converted to 2147483647.
  We can take long to avoid this case. Convert a negative number to positive using this x = -1 * x;
  
  X^N if N is even then ans = ans * n;
      else N is odd then x = x * x; at last 2/2 become 1 which is even and finally it will be multiplied by ans.
*/

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;

        nn = nn<0 ? -1*nn : nn;

        while(nn>0){
            if(nn%2 == 1){
                ans = x * ans;
                nn = nn -1;
            }
            else{
                x = x * x;
                nn = nn/2;
            }
        }
            
        return n<0 ? (double)(1)/(double)(ans) : ans; 
    }
}
