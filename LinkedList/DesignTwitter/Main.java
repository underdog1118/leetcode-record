package LinkedList.DesignTwitter;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Twitter twitter = new Twitter();
    List<Integer> res = new ArrayList<>();

    twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).

    res = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
    System.out.println(res);

    twitter.follow(1, 2);    // User 1 follows user 2.
    twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).

    res = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    System.out.println(res);

    twitter.unfollow(1, 2);  // User 1 unfollows user 2.
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
  }
}
