package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc257 {

    public static void main(String[] args) {
        lc257 lc = new lc257();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(5);
        String r = lc.binaryTreePaths(tree).toString();
        System.out.println(r);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        traverse(root, "", res);
        return res;
    }
    public void traverse(TreeNode root, String path, List<String> res) {
        if (root == null) {return;}
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
        }
        if (root.left != null) {
            traverse(root.left, path + "->", res);
        }
        if (root.right != null) {
            traverse(root.right, path + "->", res);
        }
    }
}


