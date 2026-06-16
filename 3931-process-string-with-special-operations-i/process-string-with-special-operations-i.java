class Solution {
    public String processStr(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch)){
                sb.append(ch);
            }else if(ch=='%'){
                sb.reverse();
            }else if(ch=='*'){
                if(sb.length()>0){
                   sb.deleteCharAt(sb.length()-1);
                }

            }else if(ch=='#'){
                sb.append(sb.toString());
            }

        }
        String str=sb.toString();
        return str;
    }
}