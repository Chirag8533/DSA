class Solution {
    public int countCommas(int n) {
        int ans=0;

        for(int i=1;i<=n;i++) {
            int x=i;
            int digits=0;

            while(x>0) {
                digits++;
                x=x/10;
            }

            if(digits>=4) {
                ans+=(digits-1)/3;
            }
        }

        return ans;
    }
}