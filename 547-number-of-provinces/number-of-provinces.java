class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int start,boolean[] visited,int[][] isConnected){
        visited[start]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[start][i]==1 && !visited[i]){
                dfs(i,visited,isConnected);
            }
        }
        
    }
}