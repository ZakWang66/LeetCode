import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 *
 * https://leetcode.com/problems/design-twitter/description/
 *
 * algorithms
 * Medium (28.63%)
 * Likes:    625
 * Dislikes: 157
 * Total Accepted:    41.5K
 * Total Submissions: 144.8K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * 
 * 
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's
 * news feed. Each item in the news feed must be posted by users who the user
 * followed or by the user herself. Tweets must be ordered from most recent to
 * least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * 
 * 
 * 
 * Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id
 * 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * 
 * 
 */

// @lc code=start
class Twitter {
    private class Tweet implements Comparable<Tweet>{
        int id;
        int author;
        int time;
        public Tweet(int id, int author, int time) {
            this.id = id;
            this.author = author;
            this.time = time;
        }

        public int compareTo(Tweet anotherTweet) {
            return anotherTweet.time - this.time;
        } 
    }

    Map<Integer, Set<Integer>> followUsers;
    Map<Integer, Set<Tweet>> authorToTweets;
    int systemTime;

    /** Initialize your data structure here. */
    public Twitter() {
        followUsers = new HashMap<>();
        authorToTweets = new HashMap<>();
        systemTime = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {

        if (!authorToTweets.containsKey(userId)) {
            authorToTweets.put(userId, new HashSet<>());
        }
 
        Tweet t = new Tweet(tweetId, userId, systemTime);
        authorToTweets.get(userId).add(t);
        systemTime += 1;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> allTweetsSub = new PriorityQueue<>();
        
        if (authorToTweets.containsKey(userId)) {
            allTweetsSub.addAll(authorToTweets.get(userId));
        }
        
        if (followUsers.containsKey(userId)) {
            for (int followee : followUsers.get(userId)) {
                if (authorToTweets.containsKey(followee)) {
                    allTweetsSub.addAll(authorToTweets.get(followee));
                }
            }
        }

        int i = 0;
        while (!allTweetsSub.isEmpty()) {
            if (i >= 10) break;
            res.add(allTweetsSub.poll().id);
            i += 1;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (!followUsers.containsKey(followerId)) {
            followUsers.put(followerId, new HashSet<>());
        }

        followUsers.get(followerId).add(followeeId);

    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followUsers.containsKey(followerId)) {
            return;
        }

        followUsers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

