/*-Brute:
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
/* ------------------------------------------------------------------------------------------------------------------------------------ */
