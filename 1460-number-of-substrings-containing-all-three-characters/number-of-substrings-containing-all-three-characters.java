class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] countArr=new int[3]; 
        int left=0;
        int count=0;
        for(int right=0;right<n;right++){
            countArr[s.charAt(right)-'a']++;
            while(countArr[0]>0 && countArr[1]>0 && countArr[2]>0){
                count +=(n-right);
                countArr[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
    }
}