/*- Brute: TC: O( N*M*(N+M)) & SC: O(1)
      1. Travese through each element of an array and check for element to be 0. 
      2. If zero mark the entire column as -1 and row as -1 for that i and j except for zeros.
      Note: If we change the array elements as zero then future iteration might be affected.
      3. Travese through each element of an array and check for element to be -1 and convert them to zero.
*/
public class Solution {
    public static void setZeros(int matrix[][]) {
        
        int N = matrix.length;
        int M = matrix[0].length;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 0){
                    traverseColumn(matrix, i);
                    traverseRow(matrix, j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void traverseRow(int arr[][], int j){
        for(int i =0; i<arr.length; i++){
            if(arr[i][j] != 0)
                arr[i][j] = -1;
        }
    }

    public static void traverseColumn(int arr[][], int i){
        for(int j =0; j<arr[0].length; j++){
            if(arr[i][j] != 0)
                arr[i][j] = -1;
        }
    }

}
/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

/*- Better: TC: O( N*M)) & SC: O(N*M)
      1. Travese through each element of an array and check for element to be 0. 
      2. Take two dummy array markRow and markColumn for marking if particular row/column has 0 in it. Mark row/column using those arrays.
      3. Travese through each element of an array and check if markRow or markColumn is set true. If use set the element as zero.
*/
public class Solution {
    public void setZeroes(int matrix[][]) {
        int N = matrix.length;
        int M = matrix[0].length;

        boolean markRow[] = new boolean[N];
        boolean markColumn[] = new boolean[M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 0){
                    markRow[i] = true;
                    markColumn[j] = true;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(markRow[i] == true){
                    matrix[i][j] = 0;
                }else if(markColumn[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
/*
            - Optimal:  TC: O(N*M) & SC: O(1)
            1. Instead of taking dummy variable now my first row and first column will be used to mark rows and columns.
            2. There is overlapping for martix[0][0] it will mark both column and row. So, lets take another variable to mark 1st column i.e col0.
            3. Iterate from 0 to N in rows and 1 to M in columns. If element is zero mark the row as matrix[i][0] and the column as if as col0 and column[0][j] as 0.
            4. Iterate from 1 to N in rows and 1 to M in columns again if matrix[0][j] or matrix[i][0] == 0 set the element zero.
            5. Check for 1st row and column now. See column value is dependent on row. So, first column should be set. 
            6. if matrix[0][0] then set first row as zero similarly if col0 is 0 set first column as zero.
*/

public class Solution {
    public static void setZeros(int matrix[][]) {
          
        int N = matrix.length;
        int M = matrix[0].length;

        int col0 = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 0){
                    //Mark row
                    matrix[i][0] = 0;

                    //Mark column
                    if(j == 0)
                        col0 =0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                //Checking for row and column
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0; j<M; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i=0; i<N; i++){
                matrix[i][0] = 0;
            }
        }
    }

}
