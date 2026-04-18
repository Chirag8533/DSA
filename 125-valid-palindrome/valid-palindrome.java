class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        String ans=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ans.length();i++){
            char ch=ans.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
          }
          String str=sb.toString();
          int i=0;
          int j=str.length()-1;
          while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
          }
          return true;
    }
}