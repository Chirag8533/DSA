class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    boolean[] visited=new boolean[n+1];
    Queue<Integer>q=new LinkedList<>();
    visited[source]=true;
    q.add(source);
    while(!q.isEmpty()){
        int node=q.poll();
        if(node==destination){
            return true;
        }
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                visited[neigh]=true;
                q.add(neigh);
            }
        }
    }
    return false;
    }
    
}