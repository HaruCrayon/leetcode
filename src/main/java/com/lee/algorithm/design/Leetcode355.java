package com.lee.algorithm.design;

import java.util.*;

/**
 * 355. 设计推特
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode355 {
    /*
        推特 Twitter  ---包含--->  用户 User   ---发布--->   推文 Tweet
                                       |
                                     关注
                                      |
                                  用户 User
     */

    static class Twitter {

        private final Map<Integer, User> userMap = new HashMap<>();
        private int time; // 发布时间，数字越大，时间越新

        static class Tweet {
            Integer id;
            Integer time;
            Tweet next;

            public Tweet(Integer id, Integer time, Tweet next) {
                this.id = id;
                this.time = time;
                this.next = next;
            }

            public Integer getTime() {
                return time;
            }
        }

        static class User {
            Integer id;
            Tweet head = new Tweet(-1, -1, null);
            Set<Integer> followees = new HashSet<>();

            public User(Integer id) {
                this.id = id;
            }
        }

        public Twitter() {

        }

        // 发布推文
        public void postTweet(int userId, int tweetId) {
            User user = userMap.computeIfAbsent(userId, User::new);
            user.head.next = new Tweet(tweetId, time++, user.head.next);
        }

        // 获取最新10篇推文（包括自己和关注用户）
        public List<Integer> getNewsFeed(int userId) {
            User user = userMap.get(userId);
            if (user == null) {
                return Collections.emptyList();
            }
            // 利用大顶堆合并多个有序链表
            PriorityQueue<Tweet> queue = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime).reversed());
            // 初始化堆
            if (user.head.next != null) {
                queue.offer(user.head.next);
            }
            for (Integer id : user.followees) {
                User followee = userMap.get(id);
                if (followee.head.next != null) {
                    queue.offer(followee.head.next);
                }
            }
            List<Integer> res = new ArrayList<>();
            int count = 0;
            while (!queue.isEmpty() && count < 10) {
                Tweet tweet = queue.poll();
                res.add(tweet.id);
                if (tweet.next != null) {
                    queue.offer(tweet.next);
                }
                count++;
            }
            return res;
        }

        // 新增关注
        public void follow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, User::new);
            User followee = userMap.computeIfAbsent(followeeId, User::new);
            follower.followees.add(followee.id);
        }

        // 取消关注
        public void unfollow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user != null) {
                user.followees.remove(followeeId);
            }
        }
    }
}
