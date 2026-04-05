class Solution {
    public boolean judgeCircle(String moves) {
        int n=moves.length();
        int countL=0;
        int countR=0;
        int countD=0;
        int countU=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L'){
                countL++;
            }else if(moves.charAt(i)=='R'){
                countR++;
            }else if(moves.charAt(i)=='D'){
                countD++;
            }else{
                countU++;
            }
        }
        if(countL==countR && countD==countU){
            return true;
        }
        return false;
        
    }
}