class Solution {
    public int reverseDegree(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int revCount=26-(s.charAt(i)-'a');
            count+=revCount*(i+1);
        }
        return count;
        
    }
}