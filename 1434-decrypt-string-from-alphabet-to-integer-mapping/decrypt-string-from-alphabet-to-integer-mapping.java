class Solution {
    public String freqAlphabets(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<n){
            if(i+2<n && s.charAt(i+2)=='#'){
                int num=(s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                char ch=(char)('a'+num-1);
                sb.append(ch);
                i=i+3;
            }else{
                char ch=s.charAt(i);
                int num=((ch)-'0');
                char letter=(char)('a'+num-1);
                i++;
                sb.append(letter);
            }
        }
        String str=sb.toString();
        return str;
        
        
    }
}