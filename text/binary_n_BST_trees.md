# Tree

## Types

### Complete binary tree (heap)

It is binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

## Full binary tree
A full binary tree (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has two children. ?

## BST: Binary Search Tree

A BST is binary tree if, for every tree node n with a key, all keys in the left subtree of n are less than the key of n,
and all keys in the right subtree of n are greater than the key of n.


## Traversal

### In-order

First traverse the left subtree by recursively calling the in-order function. Then display the data part of root element (or current element). THen traverses the right subtree.


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

### Lowest common ancestor(LCA)

http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

```

public class BinaryTree
{
    // Root of the Binary Tree
    Node root;
    static boolean v1 = false, v2 = false;

    // This function returns pointer to LCA of two given
    // values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    Node findLCAUtil(Node node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1)
        {
            v1 = true;
            return node;
        }
        if (node.data == n2)
        {
            v2 = true;
            return node;
        }

        // Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(node.left, n1, n2);
        Node right_lca = findLCAUtil(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    Node findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;

        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(root, n1, n2);

        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;

        // Else return NULL
        return null;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }
}
```

### isBinarySearchTree

Do In-Order Traversal of the given tree.
While traversal, we can keep track of previously visited node.
If the value of the currently visited node is less than the previous value,
then tree is not BST.

```
public class BinaryTree
{
    // Root of the Binary Tree
    Node root;

    // To keep tract of previous node in Inorder Traversal
    Node prev;

    boolean isBST()  {
        prev = null;
        return isBST(root);
    }

    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBST(Node node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;

            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
```
### Left-child right-sibling binary tree
https://en.wikipedia.org/wiki/Left-child_right-sibling_binary_tree

### Populating next right pointers in each node

Populate the nextRight pointers in each node.

You may assume that it is a full binary tree (ie, each node other than the leaves has two children.)

```
void connect(Node* p) {
  if (!p) return;
  if (p->leftChild)
  p->leftChild->nextRight = p->rightChild;
  if (p->rightChild)
    p->rightChild->nextRight = (p->nextRight) ?
                               p->nextRight->leftChild :
                               NULL;
  connect(p->leftChild);
  connect(p->rightChild);
}
```

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL

Also
http://www.geeksforgeeks.org/connect-nodes-at-same-level/

This approach works only for Complete Binary Trees. In this method we set nextRight in Pre Order fashion to make sure that the nextRight of parent is set before its children. When we are at node p, we set the nextRight of its left and right children. Since the tree is complete tree, nextRight of p’s left child (p->left->nextRight) will always be p’s right child, and nextRight of p’s right child (p->right->nextRight) will always be left child of p’s nextRight (if p is not the rightmost node at its level). If p is the rightmost node, then nextRight of p’s right child will be NULL.

```
class BinaryTree {

    static Node root;

    // Sets the nextRight of root and calls connectRecur() for other nodes
    void connect(Node p) {

        // Set the nextRight for root
        p.nextRight = null;

        // Set the next right for rest of the nodes (other than root)
        connectRecur(p);
    }

    /* Set next right of all descendents of p.
     Assumption:  p is a compete binary tree */
    void connectRecur(Node p) {

        // Base case
        if (p == null) {
            return;
        }

        // Set the nextRight pointer for p's left child
        if (p.left != null) {
            p.left.nextRight = p.right;
        }

        // Set the nextRight pointer for p's right child
        // p->nextRight will be NULL if p is the right most child at its level
        if (p.right != null) {
            p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;
        }

        // Set nextRight for other nodes in pre order fashion
        connectRecur(p.left);
        connectRecur(p.right);
    }
```

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

###  Compact Tree

?

### Sum Exists in Binary Tree

 Print All Paths From Root In a Binary Tree Whose Sum is Equal to a Given Number


    Cre­ate a global vari­able as String = path.
    Do the pre­order
    if root is greater than Sum required, return.
    If not then, add root to the path and update the required sum (sum=sum-root.data).
    if sum required =0, means we have found the path, print it.
    See the code for bet­ter understanding.

```
String path;
	public void hasPath(Node root, int sum, String path){
		if(root!=null){
			if(root.data>sum){ // if root is greater than Sum required, return
				return;
			}else{
				path+=" " + root.data; //add root to path
				sum=sum-root.data; // update the required sum
				if(sum==0){ //if sum required =0, means we have found the path
					System.out.println(path);
				}
				hasPath(root.left, sum, path);
				hasPath(root.right, sum, path);
			}
		}
	}
```

### Given a binary tree, print all root-to-leaf paths
```
class BinaryTree {

    static Node root;

    /*Given a binary tree, print out all of its root-to-leaf
     paths, one per line. Uses a recursive helper to do the work.*/
    void printPaths(Node node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }

    /* Recursive helper function -- given a node, and an array containing
     the path from the root node up to but not including this node,
     print out all the root-leaf paths.*/
    void printPathsRecur(Node node, int path[], int pathLen) {
        if (node == null) {
            return;
        }

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) {
            printArray(path, pathLen);
        } else {

            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
 ```

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

```
int areMirror(Node* a, Node* b)
{
    /* Base case : Both empty */
    if (a==NULL && b==NULL)
        return true;

    // If only one is empty
    if (a==NULL || b == NULL)
        return false;

    /* Both non-empty, compare them recursively
     Note that in recursive calls, we pass left
     of one tree and right of other tree */
    return  a->data == b->data &&
            areMirror(a->left, b->right) &&
            areMirror(a->right, b->left);
}
```



## Number of Distinct Binary trees

Let T(n) be the number of bsts of n elements.

Given n distinct ordered elements, numbered 1 to n, we select i as the root.

This leaves (1..i-1) in the left subtree for T(i-1) combinations and (i+1..n) in the right subtree for T(n-i) combinations.

Therefore:

T(n) = sum_i=1^n(T(i-1) * T(n-i))

and of course T(1) = 1

This recursion solves to Catalan number:
n
Pi (n+k)/k
k=2

TODO (solved as dynamic programming)

http://techieme.in/count-binary-search-trees/3/


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

It is not possible to construct a **general Binary Tree** from preorder and postorder traversals (See this).
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


### Binary from Postorder and inorder
http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
We find root (last element of post-order)
in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)

From the post-order array, we know that last element is the root. We can find the root in in-order array. Then we can identify the left and right sub-trees of the root from in-order array.

Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. Recursively, we can build up the tree.