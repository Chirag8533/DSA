class Solution {
    public boolean validDigit(int n, int x) {
        int original=n;
        int digit=0;
        while(n>=10){
            n=n/10;
        }
        if(n!=x && find(original,x)){
            return true;
        }
        return false;
        
    }
    public static boolean find(int n,int x){
        int curr=Integer.MIN_VALUE;
        while(n!=0){
            curr=n%10;
            if(curr==x){
                return true;
            }
            n=n/10;
        }
        return false;

    }
}