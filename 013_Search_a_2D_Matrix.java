//Brute: TC: O(N*M) & SC: 0(1)

/*
  Traverse to each element of the array and check if target = arr[i][j] if yes print true else false. -> Linear Traversal
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}

//Better

/*
  Use the property that row and column are sorted in the array.
  1. take i = 0; and j = m
  2. If arr[i][j] < target inc i.
  3. else dec. j till both pointer moves out of bound i.e i<n and j>=0 return false.
*/

public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int i=0;
        int j = mat.get(0).size()-1;

        while(i<mat.size() && j>=0){
            if(mat.get(i).get(j) == target)
                return true;
            else if(mat.get(i).get(j) < target)
                i++;
            else
                j--;
        }
        return false;
    }
}

//Optimal

/*
  if elements are sorted in such a way that arr[i][j] < arr[i+1][j+1]. Then, we can use binary search.
  
  size = n*m -1;
  low = 0;
  high = n*m -1
  
  mid's index => i = mid/m    and   j = mid%m
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int high = (n * m) - 1;
        
        while(low <= high) {
            int mid = (low + (high - low) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
