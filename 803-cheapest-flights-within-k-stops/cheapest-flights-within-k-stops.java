class Solution {
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k) {  
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adj.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,src,0});   
        int[] minStops=new int[n];
        Arrays.fill(minStops,Integer.MAX_VALUE); 
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0];
            int node=cur[1];
            int stops=cur[2];
            if(node==dst){
                return cost;
            }
            if(stops>k) continue;
            if(stops>minStops[node]) continue;
            minStops[node]=stops;
            for(int[] edge:adj.get(node)){
                int next=edge[0];
                int price=edge[1];
                pq.add(new int[]{cost+price,next,stops+1});
            }
        }
        return -1;
    }
}