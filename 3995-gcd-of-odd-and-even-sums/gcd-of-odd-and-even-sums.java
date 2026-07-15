class Solution {
    public int gcdOfOddEvenSums(int n) {
       int sumOdd=n*(n+1);
       int sumEven=n*n;
        while(sumOdd>0 && sumEven>0){
            if(sumOdd>sumEven){
                sumOdd=sumOdd%sumEven;
            }else{
                sumEven=sumEven%sumOdd;
            }
        }
        if(sumOdd==0){
                return sumEven;
            }
            if(sumEven==0){
                return sumOdd;
            }
            return -1;
        
    }
}