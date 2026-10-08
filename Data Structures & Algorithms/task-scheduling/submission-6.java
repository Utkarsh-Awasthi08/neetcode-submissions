class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(freq.values());

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> remaining = new ArrayList<>();

            int slots = n + 1;

            while (slots > 0 && !pq.isEmpty()) {
                int count = pq.poll();

                if (count > 1) {
                    remaining.add(count - 1);
                }

                time++;
                slots--;
            }

            pq.addAll(remaining);

            // If tasks remain, unused slots are idle time
            if (!pq.isEmpty()) {
                time += slots;
            }
        }

        return time;
    }
}