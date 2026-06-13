class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] arr = new char[26];
        for(int i=0;i<26;i++){
            arr[i] = (char)('z' - i);
        }
        StringBuilder sb =new StringBuilder();
        for(String word :words){
            int sum =0;
            for(char ch :word.toCharArray()){
                sum +=weights[ch -'a'];
            }
            sb.append(arr[sum %26]);
        }
        return sb.toString();
    }
}