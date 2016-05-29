# Tree

## Traversal

### In-order

First traverse the left subtree by recursively calling the in-order function. Then display the data part of root element (or current element). THen traverses the right subtree.

## BST: Binary Search Tree

A BST is binary tree if, for every tree node n with a key, all keys in the left subtree of n are less than the key of n,
and all keys in the right subtree of n are greater than the key of n.

## Binary tree used for sorting

A tree sort is a sort algorithm that builds a BST from the elements to be sorted, and then traverses the tree (**in-order**) so that the elements come out in sorted order.

https://en.wikipedia.org/wiki/Tree_sort

## Using trees to create Reverse Polish (postfix)expression

infix -> (3+4)*5 (in-order)
prefix -> +34
postfix -> 34+ (post order)

## Most likely questions

### The lookup method

The average time complexity is O(logN).
Worst case O(N) - when the whole tree becomes a linked list.


### Breadth-first traversal

Level by level, also called level-order.

Use queue.
start with root, push into queue
while queue is not empty
    visit
    push children


### Insert in binary tree

TODO

### Depth and height of node. Height of tree

**The depth** of a node is the number of edges from the node to the tree's root node.
A root node will have a depth of 0.

**The height** of a node is the number of edges on **the longest path** from the node to a leaf.
A leaf node will have a height of 0.

The height of a tree would be the height of its root node.

Depth of root is 0
Height of leaf is 0.

FindHeight(root)
{
    if(root is null) return -1

    leftHeight <- FindHeight(root->left)
    rightHeight <- FindHeight(root->right)

    return max (leftHeight,rightHeight)+1;
 }

Level – The level of a node is defined by 1 + the number of connections between the node and the root.

Level = Depth + 1

```c
int getLevel( struct node* h , int n)
{
if(!h)
return 0;
if(h->data == n)
return 1;
int l = getLevel (h->left,n);
int r= getLevel (h->right,n);
if (l)
return l+1;
else if (r)
return r+1;
else return 0;

}
```

    Lowest common ancestor(LCA) http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    isBinarySearchTree
    Left-child right-sibling binary tree Populating next right pointers in each node

### Inorder Successor
Inorder successor is a node which would be visited as next during in-order traversal.

```
define BST_FIND_SUCCESSOR(Node):
    if (Node->right != NULL)
        return BST_SEARCH_MIN_KEY(Node->right)
    Node_tmp = Node->parent
    while (Node_tmp != NULL and Node_tmp->left != Node)
        Node = Node_tmp
        Node_tmp = Node_tmp->parent
    return Node_tmp
```
```
define BST_FIND_PREDECESSOR(Node):
    if (Node->left != NULL)
        return BST_SEARCH_MAX_KEY(Node->left)
    Node_tmp = Node->parent
    while (Node_tmp != NULL and Node_tmp->right != Node)
        Node = Node_tmp
        Node_tmp = Node_tmp->parent
    return Node_tmp

```


    Compact Tree
    Sum Exists in Binary Tree
    All paths in Tree
    DFS
###  Binary Search
```
define BST_TREE_SEARCH (Node, Key):
    if (Node == NULL) or (Node->Key == Key)
        return Node
    if Key < Node->Key
        return BST_TREE_SEARCH (Node->Left, Key)
    return BST_TREE_SEARCH (Node->Right, Key)
```

```
define ITERATIVE_BST_TREE_SEARCH (Node, Key):
    while ((Node != NULL) and (Node->Key != Key))
        if (Key < Node->Key)
            Node = Node->left
        else
            Node = Node->right
    return Node
```

###  Mirror image of tree

http://www.geeksforgeeks.org/check-if-two-trees-are-mirror/



## Number of Distinct Binary trees

TODO


## Binary tree maximum path sum

```java
public int maxPathSum(TreeNode root) {
	int max[] = new int[1];
	max[0] = Integer.MIN_VALUE;
	calculateSum(root, max);
	return max[0];
}

public int calculateSum(TreeNode root, int[] max) {
	if (root == null)
		return 0;

	int left = calculateSum(root.left, max);
	int right = calculateSum(root.right, max);

	int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

	max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

	return current;
}

```

## Other

## Find min/max value

Follow down to left subtree. Iterative version:

```
define BST_SEARCH_MIN_KEY(Node):
    while (Node->left != NULL)
        Node = Node->left
    return Node
```

For max - follow down right subtree

### Kth smallest

We could display all the nodes in order by in-order traversals.


private void helper(TreeNode root) {
if(root != null) {
helper(root.left)

### Serialize / deserialize binary tree

http://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

#### BST deserialization

If the given Binary Tree is Binary Search Tree, we can store it by either storing preorder or postorder traversal.
In case of Binary Search Trees, only **preorder** or **postorder** traversal is sufficient to store structure information.

#### BST deserialization O(n^2)

create (sub)root
return it if single element
search for first greater than root
recurse left and right


##### O(1) solution

```
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {

    // The main function that constructs BST from pre[]
    Node constructTree(int pre[], int size) {

     // The first element of pre[] is always root
     Node root = new Node(pre[0]);

     Stack<Node> s = new Stack<Node>();

     // Push root
     s.push(root);

     // Iterate through rest of the size-1 items of given preorder array
      for (int i = 1; i < size; ++i) {
            Node temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() and pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
     }

     return root;
 }
 ```

#### Complete Tree
Lever order traversal is sufficient (like binary heap).

### Full Tree
A full Binary is a Binary Tree where every node has either 0 or 2 children.

It is not possible to construct a general Binary Tree from preorder and postorder traversals (See this).
But if know that the Binary Tree is Full, we can construct the tree without ambiguity.

http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/

TODO

### General Binary Tree
How to store a general Binary Tree?
A simple solution is to store both Inorder and Preorder traversals. This solution requires requires space twice the size of Binary Tree.
We can save space by storing Preorder traversal and a marker for NULL pointers.

http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
http://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/

TODO