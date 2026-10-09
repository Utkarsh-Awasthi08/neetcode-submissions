

class Twitter {
    private static final int FEED_LIMIT = 10;
    private int timestamp = 0;

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time, Tweet next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    private final Map<Integer, Tweet> tweets;
    private final Map<Integer, Set<Integer>> following;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.put(
            userId,
            new Tweet(tweetId, timestamp++, tweets.get(userId))
        );
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Include the user's own tweets.
        if (tweets.containsKey(userId)) {
            maxHeap.offer(tweets.get(userId));
        }

        // Include the latest tweet of each followed user.
        for (int followeeId :
                following.getOrDefault(userId, Collections.emptySet())) {
            if (tweets.containsKey(followeeId)) {
                maxHeap.offer(tweets.get(followeeId));
            }
        }

        // Extract up to 10 most recent tweets.
        while (!maxHeap.isEmpty() && feed.size() < FEED_LIMIT) {
            Tweet current = maxHeap.poll();
            feed.add(current.id);

            if (current.next != null) {
                maxHeap.offer(current.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        following
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}