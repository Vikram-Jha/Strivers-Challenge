/*
  Pascal triangle:  first and last element of a particular row is zero. And middle element is sum of above row element value.
            1                 0C0
           1 1              1C0 1C1
          1 2 1           2C0 2C1 2C2
         1 3 3 1
        1 4 6 4 1
      1 5 10 10 5 1
      
  Question based on pascal triangle:
    1. Find the element at rth column in nth row.
    2. Print the nth row of pascal triangle.
    3. Print the whole pascal triangle.
*/


//  1. Can be calculated using permutation n-1Cr-1 formula.  TC: 0(n) and SC: O(1)

static int nCr(int n, int r){
        // nCr = n! / r! (n-r)! = nCn-r = n!/(n-r)! (n-(n-r))! 
        // So, if r > n/2 then r should be n-r. Example: 10C7 then 7 > 5 that means 10C7 should be 10C3
        //Now, 10C3 = 10!/ 3! * 7! = 10 * 9 * 8 /3 * 2 * 1
        
        long res = 1;
        for(int i =0; i<r; i++){
            res = res * (n-i);
            res = res / (i + 1);
        }
        
        return (int)res;
}

//  2. 
