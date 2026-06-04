class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            ArrayList<Integer>adj=new ArrayList<>();
            count+=solve(i,adj);
        }
        return count;
        
    }
    public static int solve(int n,ArrayList<Integer>adj){
        int waviness=0;
        while(n>0){
            int digit=n%10;
            adj.add(digit);
            n=n/10;
        }
        Collections.reverse(adj);
        int i=1;
        while(i<adj.size()-1){
            if(adj.get(i)>adj.get(i-1) && adj.get(i)>adj.get(i+1)){
                waviness++;
            }else if(adj.get(i)<adj.get(i-1) && adj.get(i)<adj.get(i+1)){
                waviness++;
            }
            i++;
        }
        return waviness;
    }
}