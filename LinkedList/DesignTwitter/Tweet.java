package LinkedList.DesignTwitter;

public class Tweet {
  public static int timeStamp = 0;
  public int id;
  public int time;
  public Tweet next;

  public Tweet(int id) {
    this.id = id;
    this.time = timeStamp++;
    this.next = null;
  }
}
