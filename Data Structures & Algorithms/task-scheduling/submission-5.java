class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int time = 0;

        while (!freq.isEmpty()) {

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

            Iterator<Map.Entry<Character, Integer>> iterator =
                    map.entrySet().iterator();

            while (iterator.hasNext() && slots > 0) {

                Map.Entry<Character, Integer> entry = iterator.next();

                int count = entry.getValue();

                if (count == 1) {
                    iterator.remove();
                } else {
                    entry.setValue(count - 1);
                }

                time++;
                slots--;
            }

            if (!map.isEmpty()) {
                time += slots;
            }

            // map now contains the remaining tasks
            freq = new HashMap<>(map);
        }

        return time;
    }
}