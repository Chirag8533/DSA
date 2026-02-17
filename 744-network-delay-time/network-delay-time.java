class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] -b[1]);
        dist[k] =0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            if(d >dist[node]){
              continue;
            } 
            for(int[] edge : adj.get(node)){
                int next = edge[0];
                int weight = edge[1];
                if(dist[node] + weight < dist[next]){
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{next,dist[next]});
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}