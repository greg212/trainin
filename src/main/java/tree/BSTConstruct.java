package tree;

import stack.LinkedStack;

/**
 * BST can be constructed from PRE-ORDER (or POST ORDER)
 * <p>
 * http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 * <p>
 * Created by gs on 2016-05-29.
 */
public class BSTConstruct {

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root1 = insert(null, 2);
        insert(root1, 3);
        insert(root1, 1);
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = BSTConstruct.constructSlow(pre);
        printInorder(root);
    }

    static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    private static TreeNode constructBstTree(int[] pre) {
        TreeNode root = new TreeNode(pre[0]);
        LinkedStack<TreeNode> stack = new LinkedStack<>();

        stack.push(root);
        for (int i = 1; i < pre.length; i++) {
            TreeNode tmp = null;
            while (!stack.isEmpty() && pre[i] > stack.peek().value) {
                tmp = stack.pop();
            }

            if (tmp != null) {
                tmp.right = new TreeNode(pre[i]);
                stack.push(tmp.right);
            } else {
                tmp = stack.peek();
                tmp.left = new TreeNode(pre[i]);
                stack.push(tmp.left);
            }
        }

        return root;
    }

    public static TreeNode constructSlow(int[] pre) {
        return constructTree(pre, 0, pre.length - 1);
    }

    private static TreeNode constructTree(int[] pre, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(pre[start]);

        if ((end - start) < 1) {
            return root;
        }

        int greaterIdx = findFirstGreater(pre[start], pre, start + 1, end);

        root.left = constructTree(pre, start + 1, greaterIdx - 1);
        root.right = constructTree(pre, greaterIdx, end);

        return root;
    }

    private static int findFirstGreater(int value, int[] pre, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (pre[i] > value) {
                return i;
            }
        }

        return -1;
    }


}
