package LinkedList.DesignTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Twitter {

  public HashMap<Integer, User> map;
  public Twitter() {
    map = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!map.containsKey(userId)) { //不包含该userID, 创建一个新的user放在map里
      User user = new User(userId);
      map.put(userId, user);
    }
    map.get(userId).post(tweetId); //该userID对应的user执行一次post
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
        (n1,n2)-> n2.time - n1.time  //按照每个User所post的tweet(head)的时间戳来排序
    );
    if (!map.containsKey(userId)) {
      return res;
    }
    User user = map.get(userId);
    //把该userid的所有followed的人post的tweet的头节点添加到maxheap中
    for (int followedId : user.followed) {
      if (map.get(followedId).head != null) {
        maxHeap.add(map.get(followedId).head);
      }
    }

    int cnt = 0;
    while (!maxHeap.isEmpty() && cnt < 10) { //小于10条时全加入，大于等于10条post时只加入最大时间戳的10个
      Tweet latestPost = maxHeap.poll();
      if (latestPost.next != null) {
        Tweet next = latestPost.next;
        maxHeap.add(next);
      }
      res.add(latestPost.id);
      cnt++;
    }
    return  res;
  }

  public void follow(int followerId, int followeeId) {
    if (!map.containsKey(followerId)) { //不存在就新建user并放入map
      User user = new User(followerId);
      map.put(followerId, user);
    }
    if (!map.containsKey(followeeId)) { //不存在就新建user并放入map
      User user = new User(followeeId);
      map.put(followeeId, user);
    }
    map.get(followerId).follow(followeeId); //user follow
  }

  public void unfollow(int followerId, int followeeId) {
    if (!map.containsKey(followerId)){
      return;
    }
    map.get(followerId).unfollow(followeeId); //user unfollow
  }
}
