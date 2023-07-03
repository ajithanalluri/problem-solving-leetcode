package org.example.DS.LeetCode.p102;

import java.util.ArrayList;
import java.util.List;

public class TreeLevelOrderPrinter {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        } else {
            if (root.left == null && root.right == null) {
                lists.add(List.of(root.val));
                return lists;
            }
            TreeNode currentNode = root;
            lists.add(List.of(currentNode.val));
            while (currentNode != null) {
                List<Integer> li = new ArrayList<>();
                if (currentNode.left != null && currentNode.right != null) {
                    li.add(currentNode.left.val);
                    li.add(currentNode.right.val);
                    lists.add(li);
                } else {
                    if (currentNode.left != null) {
                        li.add(currentNode.left.val);
                    } else if (currentNode.right != null) {
                        li.add(currentNode.right.val);
                    }
                    lists.add(li);
                }
                if (currentNode.left != null && (currentNode.left.left != null || currentNode.left.right != null)) {
                    currentNode = currentNode.left;
                } else if (currentNode.right != null && (currentNode.right.left != null || currentNode.right.right != null)) {
                    currentNode = currentNode.right;
                } else {
                    currentNode = null;
                }
            }
            return lists;
        }
    }

    public static void main(String[] args) {

        TreeNode input1 = new TreeNode(3,
                new TreeNode(9), //left
                new TreeNode(20, new TreeNode(15), new TreeNode(7)) //right
        ); //output - [[3],[9,20],[15,7]]
        TreeNode input2 = new TreeNode(1); //output - [[1]]
        TreeNode input3 = null; //output - []
        TreeNode input4 = new TreeNode(1,
              new TreeNode(2, new TreeNode(4), null),
              new TreeNode(3, null, new TreeNode(5))
        ); //output - [[1],[2,3],[4,5]]

        var levelOrder1 = levelOrder(input1);
        var levelOrder2 = levelOrder(input2);
        var levelOrder3 = levelOrder(input3);
        var levelOrder4 = levelOrder(input4);
        System.out.println(levelOrder1);
        System.out.println(levelOrder2);
        System.out.println(levelOrder3);
        System.out.println(levelOrder4);
    }
}
