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
