class Solution {

    boolean canPlace(long k, int n) {

        return (k * (k + 1)) / 2 <= n;
    }

    public int arrangeCoins(int n) {

        long low = 1;
        long high = n;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canPlace(mid, n)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return (int) high;
    }
}