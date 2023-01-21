package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class lc297 {

  public static void main(String[] args) {
    lc297 lc = new lc297();
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.right.left = new TreeNode(4);
    tree.right.right = new TreeNode(5);
    StringBuilder sb = new StringBuilder();
    System.out.println(lc.serialize(tree, sb));
    System.out.println(lc.deserialize(lc.serialize(tree, sb)));
  }

  public String serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("X,");
      return sb.toString();
    }
    sb.append(root.val);
    sb.append(",");
    serialize(root.left, sb);
    serialize(root.right, sb);
    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    for (String s : data.split(",")) {  //以逗号为间隔分开，s只能是val或者X
      queue.offer(s);
    }
    return rebuildTree(queue);
  }
  public TreeNode rebuildTree(Queue<String> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    String s = queue.poll();
    if (s.equals("X")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(s));
    root.left = rebuildTree(queue);
    root.right = rebuildTree(queue);
    return root;
  }
}
