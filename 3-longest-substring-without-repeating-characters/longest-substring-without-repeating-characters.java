class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int i=0;
        int maxLen=0;
        HashSet<Character>set=new HashSet<>();
        for(int j=0;j<n;j++){
            while(set.contains(s.charAt(j))){
                 set.remove(s.charAt(i));
                 i++;
            }
            set.add(s.charAt(j));
            int currLen=j-i+1;
            maxLen=Math.max(currLen,maxLen);
        }
        return maxLen;
    }
}