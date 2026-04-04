class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        
        StringBuilder sb = new StringBuilder();
        
        for(int startCol=0;startCol<cols;startCol++){
            
            int i = 0;
            int j = startCol;
            
            while(i < rows && j < cols){
                int index = i * cols + j;
                sb.append(encodedText.charAt(index));
                i++;
                j++;
            }
        }
        int end = sb.length()-1;
        while(end >= 0 && sb.charAt(end) == ' '){
            end--;
        }
        
        return sb.substring(0, end+1);
    }
}