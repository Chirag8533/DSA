class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] copy=new int[n];
        for(int i=0;i<n;i++){
            copy[i]=arr[i];
        }
        Arrays.sort(copy);
        HashMap<Integer,Integer>map=new HashMap<>();
        int rank = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i], rank);
                rank++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] =map.get(arr[i]);
        }
        return arr;
    }
}