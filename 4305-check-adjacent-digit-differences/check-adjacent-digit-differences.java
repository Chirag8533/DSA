class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n=s.length();
        for(int i=0;i<n-1;i++){
            char ch1=s.charAt(i);
            char ch2=s.charAt(i+1);
            int cur1=(int)ch1;
            int cur2=(int)ch2;
            if(Math.abs(cur1-cur2)>2){
                return false;
            }

        }
        return true;
    }
}