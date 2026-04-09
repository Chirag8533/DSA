class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer>adj=new ArrayList<>();
        int k=0;
        int j=0;
        while(k<n && j<m){
            if(nums1[k]==nums2[j]){
                adj.add(nums1[k]);
                k++;
                j++;
            }else if(nums1[k]<nums2[j]){
                k++;
            }else{
                j++;
            }
        }
        int[] arr=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            arr[i]=adj.get(i);
        }
        return arr;
        
    }
}