//BFS in a directed graph

/*
  Take a look at graph
                
                1         -> Level 0
               2 3        -> Level 1    
             8 4 5 6      -> Level 2
               7          -> Level 3
               
      BFS: 1 2 3 8 4 5 6 7
      
      
  Steps:  
    1. Create a visted boolean array to track if that element is traversed on not.
    2. Create a queue to store the elements of BFS in LIFO manner.
    3. Create an array to store the final solution.
    4. Initial node eitheir 0 or 1 must be stored in queue and its boolean index must be marked as true.
    5. Now iterate while queue is not empty and poll element form stack and add it to solution array.
    6. If that polled element has neighbour node then iterate through them and check there indexes into visited array if they are not visited then
       mark their index in visited array as true and add them to stack.
          
*/

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>ans=new ArrayList<>();    
        Queue<Integer>q=new LinkedList<>();
        
        boolean[] vis=new boolean[V];
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            int u=q.poll();
            
            ans.add(u);
            for(int i=0; i<adj.get(u).size(); i++){
                if(!vis[adj.get(u).get(i)]){
                  vis[adj.get(u).get(i)]=true;
                  q.add(adj.get(u).get(i));
                }
            }
        }
        return ans;
    }
}
