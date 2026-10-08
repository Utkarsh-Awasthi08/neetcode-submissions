class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int time = 0;

        while (!freq.isEmpty()) {

            // Sort by frequency descending
            Map<Character, Integer> map = freq.entrySet()
                .stream()
                .sorted(
                    Map.Entry.<Character, Integer>comparingByValue()
                        .reversed()
                )
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> a,
                    LinkedHashMap::new
                ));

            int slots = n + 1;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {

                if (slots == 0)
                    break;

                char task = entry.getKey();
                int count = entry.getValue();

                freq.put(task, count - 1);

                if (count == 1) {
                    freq.remove(task);
                }

                time++;
                slots--;
            }

            // Remaining slots are idle time
            if (!freq.isEmpty()) {
                time += slots;
            }
        }

        return time;
    }
}