class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions,int[] healths,String directions) {
        int n=positions.length;

        int[][] robots=new int[n][4];
       

        for(int i=0;i<n;i++){
            robots[i][0]=positions[i];
            robots[i][1]=healths[i];
            robots[i][2]=(directions.charAt(i)=='R')?1:0;
            robots[i][3]=i;
        }

        Arrays.sort(robots,(a,b)->a[0]-b[0]);

        Stack<int[]> st=new Stack<>();

        for(int i=0;i<n;i++){

            if(robots[i][2]==1){
                st.push(robots[i]);
            }
            else{
                while(!st.isEmpty() && robots[i][1]>0){

                    int[] top=st.peek();

                    if(top[1]<robots[i][1]){
                        robots[i][1]--; 
                        st.pop();
                    }
                    else if(top[1]>robots[i][1]){
                        top[1]--;
                        robots[i][1]=0;
                    }
                    else{
                        st.pop();
                        robots[i][1]=0;
                        break;
                    }
                }
            }
        }

        int[] res=new int[n];
        Arrays.fill(res,-1);
        while(!st.isEmpty()){
            int[] r=st.pop();
            res[r[3]]=r[1];
        }
        for(int i=0;i<n;i++){
            if(robots[i][2]==0 && robots[i][1]>0){
                res[robots[i][3]]=robots[i][1];
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res[i]!=-1){
                ans.add(res[i]);
            }
        }

        return ans;
    }
}