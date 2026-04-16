class Solution {
    public boolean isAnagram(String s, String t) {
        char[] num1=s.toCharArray();
        char[] num2=t.toCharArray();
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i=0;
        int j=0;
        if(num1.length!=num2.length){
            return false;
        }
        while(i<num1.length && j<num2.length){
                if(num1[i]==num2[j]){
                    i++;
                    j++;
                }else{
                    return false;
                }
            }
        
        return true;
    }
}