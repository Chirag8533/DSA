class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[] ans=new int[len1+len2];
        int k=0;
        int i=0;
        int j=0;
        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                ans[k++]=nums1[i++];
            }else{
                ans[k++]=nums2[j++];
            }
        }
        while(i<len1){
            ans[k++]=nums1[i++];
        }
        while(j<len2){
            ans[k++]=nums2[j++];
        }
        int length=ans.length;
        if(length%2==1){
            return ans[length/2];
        }else{
            return (ans[length/2]+ans[(length/2)-1])/2.0;
        }
        
    }
}