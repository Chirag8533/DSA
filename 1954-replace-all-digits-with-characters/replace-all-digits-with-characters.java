class Solution {
    public String replaceDigits(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<n){
            char letter=s.charAt(i);
            sb.append(letter);
            if(i+1<n){
                char digit=s.charAt(i+1);
                int num=digit-'0';
                char ans=(char)(letter+num);
                sb.append(ans);
            }
            i=i+2;
        }
        String str=sb.toString();
        return str;
        
    }
}