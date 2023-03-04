package LinkedList.DesignTwitter;

import java.util.HashSet;
import java.util.Set;

public class User {
  public int id;
  public Set<Integer> followed;
  public Tweet head;

  public User(int id) {
    this.id = id;
    this.followed = new HashSet<>();
    this.follow(id); //先关注自己
    this.head = null;
  }

  public void follow(int id) {
    this.followed.add(id);
  }

  public void unfollow(int id) {
    this.followed.remove(id);
  }

  public void post(int id) {
    Tweet t = new Tweet(id);
    t.next = this.head;  //最新发的作为新head,连接到老head上
    this.head = t;
  }
}
