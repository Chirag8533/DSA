class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            st.push(nums[i]);
        }
        for(int i=0;i<k-1;i++){
            st.pop();
        }
        return st.peek();
    }
}