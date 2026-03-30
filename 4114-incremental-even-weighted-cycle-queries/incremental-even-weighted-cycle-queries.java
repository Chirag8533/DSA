class Solution {
    int[] parent;
    int[] dist;
    public int numberOfEdgesAdded(int n, int[][] edges) {
        int len=edges.length;
        parent=new int[n];
        dist=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            dist[i]=0;
        }
        int count=0;
        for(int i=0;i<len;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            int ru=find(u);
            int rv=find(v);
            if(ru!=rv){
                union(ru,rv,dist[u]^dist[v]^w);
                count++;
            }else{
                int cycleParity=dist[u]^dist[v]^w;
                if(cycleParity==0){
                    count++;
                }
            }
        }
        return count;  
    }
    private int find(int x){
        if(parent[x]!=x){
            int root=find(parent[x]);
            dist[x]^=dist[parent[x]];
            parent[x]=root;
        }
        return parent[x];
    }
    private void union(int ru,int rv,int w){
        parent[rv]=ru;
        dist[rv]=w;
    }
}