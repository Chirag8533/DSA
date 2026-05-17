class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k==1){
            return r-l+1;
        }
        int count=0;
        int base=0;
        while(true){
            long val=power(base,k);
            if(val>r){
                break;
            }
            if(val>=l){
                count++;
            }
            base++;
        }
        return count;
        
    }
    public static long power(long base,int exp){
        long result=1;
        for(int i=0;i<exp;i++){
            result=result*base;
            if(result>1000000000L){
                return result;
            }
        }
        return result;
    }
}