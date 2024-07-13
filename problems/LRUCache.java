package problems;

import java.util.*;

//链表节点
class ListNode {
  int key;
  int val;
  ListNode next;
  ListNode prev;

  public ListNode(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

public class LRUCache {

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
  }
  int capacity;
  Map<Integer, ListNode> dic;
  ListNode head;
  ListNode tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    dic = new HashMap<>();
    head = new ListNode(-1, -1);
    tail = new ListNode(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public void add(ListNode node) {  //add to the back of the double ll
    ListNode previousEnd = tail.prev;
    previousEnd.next = node;
    node.prev = previousEnd;
    node.next = tail;
    tail.prev = node;
  }

  public void remove(ListNode node) { // remove
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public int get(int key) {
    if (!dic.containsKey(key)) {
      return -1;
    }

    ListNode node = dic.get(key);
    remove(node);
    add(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (dic.containsKey(key)) {
      ListNode oldNode = dic.get(key);
      remove(oldNode);
    }

    ListNode node = new ListNode(key, value);
    dic.put(key, node);
    add(node);

    if (dic.size() > capacity) {
      ListNode nodeToDelete = head.next;
      remove(nodeToDelete);
      dic.remove(nodeToDelete.key);
    }
  }


}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
