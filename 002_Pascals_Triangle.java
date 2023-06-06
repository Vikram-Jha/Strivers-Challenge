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

    static long nCr(int n, int r){
        // nCr = n! / r! (n-r)! = nCn-r = n!/(n-r)! (n-(n-r))! 
        // So, if r > n/2 then r should be n-r. Example: 10C7 then 7 > 5 that means 10C7 should be 10C3
        //Now, 10C3 = 10!/ 3! * 7! = 10 * 9 * 8 /3 * 2 * 1
        
        long res = 1;
        for(int i =0; i<r; i++){
            res = res * (n-i);
            res = res / (i + 1);
        }
        
        return res;
    }

//  2. Since each row has exactly n elements --> Iterate from 1 to n and calculate element using n-1Cc-1. ex for 5th row 4C0 4C1 4C2 4C3 4C4

    public static ArrayList<Long> nthRowArr(int n) {
      ArrayList<Long> nthRow = new ArrayList<Long>();
  
      for (int c = 1; c <= n; c++) {
        nthRow.add(nCr(n - 1, c - 1));
      }
      return nthRow;
    }

//  3. There can be two approach to solve the problem: 1. Formula Based 2. Intuition based

//1st Approach is to get all the element of pascal triangle using the n-1Cr-1 formula: TC: O(N^2 * R) & SC: O(N^2)

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> sol = new ArrayList<>();

        for (int row = 1; row <= n; row++) {                
            ArrayList<Long> temp = new ArrayList<>(); 
            for (int col = 1; col <= row; col++) {            // The no. of elements in a row  in a pascal triangle is equals to the row number.
                temp.add(nCr(row - 1, col - 1));
            }
            sol.add(tempLst);
        }
        return sol;
	}

	public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}

// 2nd Approach is to optimise the formula.

// Lets observe: 1 4 6 4 1 this was our fifth row(1 index as first). See pattern  1, 4/1, (4 * 3)/(1 *2), (4*3*2)/(1*2*3), (4*3*2*1)/(1*2*3*4).
// If we take zero base indexing then ans =1 in each iteration ans = ans * (rows - columns) / columns if we follow zero based indexing.
// So instead of using a nCr function we can append a temp list in each iteration based on this formula and get each row.

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++){
            ans.add(getRow(row));
        }
        return ans;
	}

	public static ArrayList<Long> getRow(int row) {
        ArrayList<Long> temp = new ArrayList<>();
		temp.add(1L);

		long ans = 1;
        for (int col = 1; col <row ; col++) {
            ans = ans * (row - col);
			ans = ans / col;
			temp.add(ans);
        }
        return temp;
    }
}
