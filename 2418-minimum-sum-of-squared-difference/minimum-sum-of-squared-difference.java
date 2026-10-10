class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;

        for(int i=0;i<n;i++){
            max = Math.max(max, Math.abs(nums1[i]-nums2[i]));
        }

        long k = (long)k1 + k2;
        long[] freq = new long[max+1];

        for(int i=0;i<n;i++){
            int d = Math.abs(nums1[i]-nums2[i]);
            freq[d]++;
        }

        for(int d=max;d>0 && k>0;d--){
            if(freq[d]==0) continue;

            long cnt = Math.min(freq[d], k);

            freq[d] -= cnt;
            freq[d-1] += cnt;
            k -= cnt;
        }

        long ans = 0;

        for(int d=1;d<=max;d++){
            ans += freq[d] * d * d;
        }

        return ans;
    }
}