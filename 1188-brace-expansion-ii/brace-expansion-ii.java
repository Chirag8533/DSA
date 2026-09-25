class Solution {

    String s;
    int i;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;

        Set<String> set = parse();

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    Set<String> parse() {

        Set<String> result = new HashSet<>();

        while(i < s.length() && s.charAt(i) != '}') {

            Set<String> part = new HashSet<>();

            if(s.charAt(i) == '{') {
                i++;
                part = parse();
                i++;
            } else {
                part.add(String.valueOf(s.charAt(i)));
                i++;
            }

            if(result.isEmpty()) {
                result.addAll(part);
            } else {
                Set<String> temp = new HashSet<>();

                for(String a : result) {
                    for(String b : part) {
                        temp.add(a + b);
                    }
                }

                result = temp;
            }
            if(i < s.length() && s.charAt(i) == ',') {
                i++;
                Set<String> next = parse();
                result.addAll(next);
                if(i < s.length() && s.charAt(i) == '}') {
                    break;
                }
            }
        }
        return result;
    }
}