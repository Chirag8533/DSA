class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int originalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                originalOnes++;
            }
        }
        String t = "1" + s + "1";
        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();
        int i = 0;
        while(i < t.length()){
            char cur = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == cur) {
                j++;
            }
            ch.add(cur);
            len.add(j - i);
            i = j;
        }
        int ans = originalOnes;
        for (i = 1; i + 1 < ch.size(); i++) {
            if (ch.get(i) == '1'
                    && ch.get(i - 1) == '0'
                    && ch.get(i + 1) == '0') {
                ans = Math.max(ans,
                        originalOnes + len.get(i - 1) + len.get(i + 1));
            }
        }
        return ans;
    }
}