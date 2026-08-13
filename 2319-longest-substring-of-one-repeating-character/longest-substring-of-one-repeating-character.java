class Solution {

    class Node {
        int leftChar;
        int rightChar;
        int prefix;
        int suffix;
        int best;
        int length;

        Node(int ch) {
            leftChar = ch;
            rightChar = ch;
            prefix = 1;
            suffix = 1;
            best = 1;
            length = 1;
        }

        Node() {
        }
    }

    Node[] tree;
    char[] s;

    Node merge(Node a, Node b) {
        Node res = new Node();

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;
        res.length = a.length + b.length;

        res.prefix = a.prefix;
        res.suffix = b.suffix;
        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {
            res.best = Math.max(res.best, a.suffix + b.prefix);

            if (a.prefix == a.length) {
                res.prefix = a.length + b.prefix;
            }

            if (b.suffix == b.length) {
                res.suffix = b.length + a.suffix;
            }
        }

        return res;
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(s[start] - 'a');
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            tree[node] = new Node(ch - 'a');
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s.toCharArray();

        int n = s.length();
        int k = queryIndices.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update the character at this index
            this.s[idx] = ch;

            update(1, 0, n - 1, idx, ch);

            // Root contains the answer for the whole string
            ans[i] = tree[1].best;
        }

        return ans;
    }
}