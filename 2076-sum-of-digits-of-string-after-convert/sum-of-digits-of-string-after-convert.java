class Solution {
    public int getLucky(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            sb.append((ch-'a')+1);
        }
        String str=sb.toString();
        int sum=0;
        for(int i=0;i<str.length();i++){
            sum+=str.charAt(i)-'0';
        }
        k--;
        while(k>0){
            int temp=0;
            while(sum>0){
                temp+=sum%10;
                sum=sum/10;
            }
            sum=temp;
            k--;
        }
        return sum;
    }
}