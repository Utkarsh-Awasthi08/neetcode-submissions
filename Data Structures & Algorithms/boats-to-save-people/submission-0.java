class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int c = 0;
        for(int i = 0; i < people.length; i++)
        {
            if(people[i] == Integer.MAX_VALUE)
            continue;
            int j = people.length - 1;
            while(j > i)
            {
                if(people[j] == Integer.MAX_VALUE)
                {
                    j--;
                    continue;
                }
                int sum = people[i] + people[j];
                if(sum <= limit)
                {
                    c++;
                    people[j] = Integer.MAX_VALUE;
                    break;
                }
                j--;
            }
            if(i == j)
            c++;
        }
        return c;
    }
}