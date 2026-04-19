class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int edges=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);   
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(ans.size()!=numCourses){
            return new int[] {};
        }
        int [] num=new int[ans.size()];
        for(int i=0;i<num.length;i++){
            num[i]=ans.get(i);
        }
        return num;
        
        

    }
}