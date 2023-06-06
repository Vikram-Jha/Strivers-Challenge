/*
  Optimal:
  
  Intuition:
      1.Find the longest prefix match to find the next subarray.
        Example:  2 1 5 4 3 0 0

        Here 2 is the longest prefix match. Why if we take 21345 longest prefix match the we need an element greater than 3 in remaining elements.
        Similarly, if we take 2154 longest prefix match the we need an element greater than 4 in remaining elements.
        Similarly, if we take 215 longest prefix match the we need an element greater than 5 in remaining elements.
        Similarly, if we take 21 longest prefix match the we need an element greater than 1 in remaining elements.
        So, 2 is longest prefix match because we have 5 , 4 and 3 greater than 2 to rearrange.

        Iterate form n-2 to 0 -> If arr[i] < a[i+1] and save the index = i.
      
      2.Find an element k > arr[index] but smaller in range [index, n].
      
        Iterate from n-1 to index if arr[i] > arr[index] swap those two element.
      
      3. Reverse the arr form index +1 to n.
        
      
*/
