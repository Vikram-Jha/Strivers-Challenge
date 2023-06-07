//Brute:  TC: O(N*N) & SC: O(N*N)

/*
  1. Understand the pattern and create a formula according to it.
  2. Create a new 2D temp array and store elements into new array as per formula.
  3. Finally set given matrix as temp matrix.
  
  Here we had to rotate by 90 clockwise:
  
  1 2 3           7 4 1                             00  ->  02      10  ->  01
  4 5 6     -->   8 5 2           -> Pattern        01  ->  12  &&  11  ->  11            
  7 8 9           9 6 3                             02  ->  22      12  ->  21
 
  1. Hence j which moves form 0 to 2 in each row can become new i.
  2. j = N-1-i from 2 to 1 to 0.
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int temp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[j][n-1-i] = matrix[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = temp[i][j];
            }
        }

    }
}

//Optimal: TC: O(N*N) & SC: O(1) -> In place

/*
    1. Transpose the matrix;
    2. Reverse each row elements of the array.
*/

class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++){              // Transpose means except the element i == j are swapped such that a[i][j] = [j][i]
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }

        for(int i=0; i<n; i++){
            reverse(mat[i]);
        }
    }

    public void reverse(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low<high){
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
    }
}

// Coding ninja problem is different its about rotation of one element.

/*
    Here are we are shift one row at a time and one column at a time with two additional variable
*/

public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int u = 0;
        int d = n-1;
        int l = 0;
        int r = m-1;

        while (l<r && u<d) {
            int prev = mat.get(u+1).get(l);
            for (int i=l;i<=r;i++) { 
               int curr = mat.get(u).get(i);
                mat.get(u).set(i,prev);
                prev = curr;
            }
            u++; 
            for (int i=u;i<=d;i++) {
                int curr = mat.get(i).get(r);
                mat.get(i).set(r,prev); 
               prev = curr;
            }
            r--;

            for (int i=r;i>=l;i--) {
                int curr = mat.get(d).get(i);
                mat.get(d).set(i,prev);
                prev = curr; 
            }
            d--;
            for (int i=d;i>=u;i--) {
                int curr = mat.get(i).get(l);
                mat.get(i).set(l,prev);
                prev = curr;
            }
            l++;
        }
    }
