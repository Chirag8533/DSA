class Solution {
    public boolean checkDivisibility(int n) {
        int res=n;
        int sum=0;
        int prod=1;
        while(n>0){
            int lastdigit=n%10;
            sum+=lastdigit;
            prod=prod*lastdigit;
            n=n/10;
        }
        if(res%(sum+prod)==0){
            return true;
        }
        return false;
    }
}