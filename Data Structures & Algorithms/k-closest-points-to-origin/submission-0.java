class Solution {

    private class Pair {
        int key;
        double value;

        Pair(int k, double v) {
            this.key = k;
            this.value = v;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Double.compare(a.value, b.value));

        for (int i = 0; i < points.length; i++) {
            double dist = Math.sqrt(
                Math.pow(points[i][0], 2) +
                Math.pow(points[i][1], 2)
            );

            pq.add(new Pair(i, dist));
        }

        int[][] ans = new int[k][2];

        int i = 0;

        while (i < k) {
            Pair pair = pq.poll();

            int[] point = points[pair.key];

            ans[i][0] = point[0];
            ans[i][1] = point[1];

            i++;
        }

        return ans;
    }
}