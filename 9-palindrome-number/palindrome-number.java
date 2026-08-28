class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
        int rev=0;
        if(x<0){
            return false;
        }
        while(y!=0){
            int lastdigit=y%10;
            rev=rev*10+lastdigit;
            y=y/10;
        }
        if(x==rev){
            return true;
        }
        return false;
    }
}