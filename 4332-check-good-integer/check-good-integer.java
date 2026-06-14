class Solution {
    public boolean checkGoodInteger(int n) {
        int num=n;
        int sum=0;
        int squareSum=0;
        while(num>0){
            int digit=num%10;
            sum+=digit;
            squareSum+=digit*digit;
            num=num/10;
        }
        return squareSum-sum>=50;
    }
}