class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int[] indegree=new int[n+1];
        for(int i=0;i<edges.length;i++){
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==edges.length){
                return i;
            }
        }
        return -1;
    }
}