class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        int[] freqL=new int[26];
        int[] freqU=new int[26];
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(Character.isLowerCase(ch)){
                freqL[ch-'a']++;
            }else{
                freqU[ch-'A']++;
            }
        }
        int j=0;
        int count=0;
        for(int i=0;i<freqL.length;i++){
            if(freqL[i]!=0 && freqU[j]!=0){
                count++;
            }
            j++;
        }
        return count;


    }
}