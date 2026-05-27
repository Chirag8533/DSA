class Solution {
    public char nextGreatestLetter(char[] s, char target) {
        int n=s.length;
        int start=0;
        int end=n-1;
        char ans=s[0];
        while(start<=end){
            int mid=(start+end)/2;
            if(s[mid]>target){
                ans=s[mid];
                end=mid-1;
            }else{
                start=mid+1;

            }
        }
        return ans;
    }
}