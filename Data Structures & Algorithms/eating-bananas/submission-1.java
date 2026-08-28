class Solution {
    boolean canEat(int[] piles, int k, int h)
    {
        int c = 0;
        for(int i = 0; i < piles.length; i++)
        {
            int a = piles[i] / k;
            int b = piles[i] % k;

            if(b == 0)
            c+= a;

            else
            c+= (a + 1);
        }
        return c <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while(low < high)
        {
            int mid = (low + high) / 2;
            if(mid != 0 && canEat(piles, mid, h))
            high = mid;

            else
            low = mid + 1;
        }
        if(canEat(piles, high, h))
        return high;

        return low;
    }
}
