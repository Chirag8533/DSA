import java.util.*;

class Solution {

    static class State {
        long score;
        List<Integer> list;

        State(long score, List<Integer> list) {
            this.score = score;
            this.list = list;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[3], b[3]);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][0] > arr[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }

        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new State(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

                State skip = dp[i + 1][k];

                State takeNext = dp[next[i]][k - 1];

                List<Integer> takeList = new ArrayList<>();
                takeList.add(arr[i][3]);
                takeList.addAll(takeNext.list);

                Collections.sort(takeList);

                State take = new State(
                    arr[i][2] + takeNext.score,
                    takeList
                );

                if (take.score > skip.score) {
                    dp[i][k] = take;
                } else if (take.score < skip.score) {
                    dp[i][k] = skip;
                } else {
                    if (isLexicographicallySmaller(take.list, skip.list)) {
                        dp[i][k] = take;
                    } else {
                        dp[i][k] = skip;
                    }
                }
            }
        }

        List<Integer> answer = dp[0][4].list;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean isLexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}