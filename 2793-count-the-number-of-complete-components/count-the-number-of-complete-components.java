class Solution {
    int nodes;
    int edge;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                nodes=0;
                edge=0;
                dfs(i,adj,edges,visited);
                edge=edge/2;
                if(edge==nodes*(nodes-1)/2){
                    count++;
                }
            }

        }
        return count;

        
    }
    public  void dfs(int start,ArrayList<ArrayList<Integer>>adj,int[][] edges,boolean[] visited){
        visited[start]=true;
        nodes++;
        for(int neigh:adj.get(start)){
            edge++;
            if(!visited[neigh]){
               dfs(neigh,adj,edges,visited);
            }
        }


    }

}