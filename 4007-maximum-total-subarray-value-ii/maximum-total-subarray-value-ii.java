class Solution {

    int[][] maxST;
    int[][] minST;
    int[] log;

    private long getValue(int l,int r){
        int len=r-l+1;
        int k=log[len];

        int mx=Math.max(maxST[k][l],maxST[k][r-(1<<k)+1]);
        int mn=Math.min(minST[k][l],minST[k][r-(1<<k)+1]);

        return (long)mx-mn;
    }

    public long maxTotalValue(int[] nums,int k) {
        int n=nums.length;

        log=new int[n+1];
        for(int i=2;i<=n;i++){
            log[i]=log[i/2]+1;
        }

        int m=log[n]+1;

        maxST=new int[m][n];
        minST=new int[m][n];

        for(int i=0;i<n;i++){
            maxST[0][i]=nums[i];
            minST[0][i]=nums[i];
        }

        for(int j=1;j<m;j++){
            for(int i=0;i+(1<<j)<=n;i++){
                maxST[j][i]=Math.max(
                    maxST[j-1][i],
                    maxST[j-1][i+(1<<(j-1))]
                );

                minST[j][i]=Math.min(
                    minST[j-1][i],
                    minST[j-1][i+(1<<(j-1))]
                );
            }
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>(
            (a,b)->Long.compare(b[0],a[0])
        );

        for(int l=0;l<n;l++){
            long val=getValue(l,n-1);
            pq.offer(new long[]{val,l,n-1});
        }

        long ans=0;

        while(k-->0){
            long[] cur=pq.poll();

            long val=cur[0];
            int l=(int)cur[1];
            int r=(int)cur[2];

            ans+=val;

            if(r>l){
                pq.offer(new long[]{
                    getValue(l,r-1),
                    l,
                    r-1
                });
            }
        }

        return ans;
    }
}