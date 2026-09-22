class Solution {

    class Node {
        int product;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
        }
    }

    int n;
    int k;
    int[] nums;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.nums = nums;
        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            nums[index] = value;

            update(1, 0, n - 1, index);

            Node node = query(1, 0, n - 1, start, n - 1);

            result[q] = node.cnt[x];
        }

        return result;
    }

    void build(int node, int left, int right) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (left + right) / 2;

        build(2 * node, left, mid);
        build(2 * node + 1, mid + 1, right);

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    void update(int node, int left, int right, int index) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(2 * node, left, mid, index);
        } else {
            update(2 * node + 1, mid + 1, right, index);
        }

        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    Node query(int node, int left, int right, int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = (left + right) / 2;

        if (qr <= mid) {
            return query(2 * node, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(2 * node + 1, mid + 1, right, ql, qr);
        }

        Node leftNode = query(2 * node, left, mid, ql, qr);
        Node rightNode = query(2 * node + 1, mid + 1, right, ql, qr);

        return merge(leftNode, rightNode);
    }

    Node merge(Node a, Node b) {

        Node result = new Node(k);

        result.product = (a.product * b.product) % k;

        for (int r = 0; r < k; r++) {
            result.cnt[r] += a.cnt[r];
        }

        for (int r = 0; r < k; r++) {

            int newRemainder = (a.product * r) % k;

            result.cnt[newRemainder] += b.cnt[r];
        }

        return result;
    }
}