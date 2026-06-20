class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=digits.length;
        int carry=1;
        for(int i=n-1;i>=0;i--){
            if(digits[i]+carry<=9){
                ans.add(digits[i]+carry);
                carry=0;
            }else{
                ans.add(0);
                carry=1;
            }
            
        }
        if(carry!=0){
                ans.add(carry);
            }
        Collections.reverse(ans);
       int[] nums=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            nums[i]=ans.get(i);
        }
        return nums;
    }
}