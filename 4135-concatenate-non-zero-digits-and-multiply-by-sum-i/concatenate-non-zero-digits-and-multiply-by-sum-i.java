class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        int x=n;
        int sum=0;
        while(x!=0){
            int digit=x%10;
            if(digit!=0){
                sb.append(digit);
                sum+=digit;
            }
            x=x/10;

        }
        if(sb.length()==0){
            return 0;
        }
    sb.reverse();
    String s=sb.toString();
    long number=Long.parseLong(s)*sum;
    return number;
    }
    
}