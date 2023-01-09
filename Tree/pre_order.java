package Tree;

import java.util.LinkedList;
import java.util.List;

public class pre_order {

        public static void main(String[] args) {
            pre_order lc = new pre_order();
            int[] root = new int[]{1,2,2,3};
            TreeNode tree = new TreeNode(1);
            tree.right = new TreeNode(2);


        }
        public static class TreeNode {
          int val;
         TreeNode left;
         TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
        }
        List<Integer> ls = new LinkedList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            traverse(root);
            return ls;
        }
        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            ls.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
}
