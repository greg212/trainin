A trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes),
is an ordered tree data structure that is used to store a dynamic set or associative array
where the keys are usually strings.

Unlike a binary search tree, no node in the tree stores the key associated with that node;
instead, its position in the tree defines the key with which it is associated.

All the descendants of a node have a common prefix of the string associated with that node,
 and the root is associated with the empty string.
 Values are not necessarily associated with every node.

Rather, values tend only to be associated with leaves, and with some inner nodes that correspond to keys of interest.


Advantages over binary search trees.
A trie can also be used to replace a hash table, over which it has the following advantages:

    Looking up data in a trie is faster in the worst case, O(m) time (where m is the length of a search string), compared to an imperfect hash table. An imperfect hash table can have key collisions. A key collision is the hash function mapping of different keys to the same position in a hash table. The worst-case lookup speed in an imperfect hash table is O(N) time, but far more typically is O(1), with O(m) time spent evaluating the hash.
    There are no collisions of different keys in a trie.
    Buckets in a trie, which are analogous to hash table buckets that store key collisions, are necessary only if a single key is associated with more than one value.
    There is no need to provide a hash function or to change hash functions as more keys are added to a trie.
    A trie can provide an alphabetical ordering of the entries by key.

Tries do have some drawbacks as well:

    Tries can be slower in some cases than hash tables for looking up data, especially if the data is directly accessed on a hard disk drive or some other secondary storage device where the random-access time is high compared to main memory.[7]
    Some keys, such as floating point numbers, can lead to long chains and prefixes that are not particularly meaningful. Nevertheless, a bitwise trie can handle standard IEEE single and double format floating point numbers.
    Some tries can require more space than a hash table, as memory may be allocated for each character in the search string, rather than a single chunk of memory for the whole entry, as in most hash tables.


Sorting

Lexicographic sorting of a set of keys can be accomplished with a simple trie-based algorithm as follows:

    Insert all keys in a trie.
    Output all keys in the trie by means of pre-order traversal, which results in output that is in lexicographically increasing order. Pre-order traversal is a kind of depth-first traversal.

This algorithm is a form of radix sort.

http://www.geeksforgeeks.org/trie-insert-and-search/

Appications
- autocompletion, spell checkers
- partial matching basing on prefix
LONGEST PREFIX MATCHING


## Suffix tree



## Suffix array
A suffix array is a sorted array of all suffixes of a given string.
The definition is similar to Suffix Tree which is compressed trie of all suffixes of the given text.
Any suffix tree based algorithm can be replaced with an algorithm that uses a suffix array enhanced with additional information and solves the same problem in the same time complexity (Source Wiki).
A suffix array can be constructed from Suffix tree by doing a DFS traversal of the suffix tree.
In fact Suffix array and suffix tree both can be constructed from each other in linear time.
Advantages of suffix arrays over suffix trees include improved space requirements, simpler linear time construction algorithms (e.g., compared to Ukkonen’s algorithm) and improved cache locality (Source: Wiki)

http://www.geeksforgeeks.org/suffix-array-set-1-introduction/


http://www.geeksforgeeks.org/pattern-searching-set-8-suffix-tree-introduction/

###Applications of Suffix Tree (and array)
1) Pattern Searching
### Finding the longest repeated substring

This problem can be solved in linear time and space [ Θ(n) ] by building a suffix tree for the string,
and finding the deepest internal node in the tree.
Depth is measured by the number of characters traversed from the root.
The string spelled by the edges from the root to such a node is a longest repeated substring.
The problem of finding the longest substring with at least k {\displaystyle k} occurrences can be
solved by first preprocessing the tree to count the number of leaf descendants for each internal node,
and then finding the deepest node with at least k {\displaystyle k} leaf descendants that have no children.
3) Finding the longest common substring
4) Finding the longest palindrome in a string


## Sufix
array
A suffix array is a sorted array of all suffixes of a given string. The definition is similar to Suffix Tree which is compressed trie of all suffixes of the given text. Any suffix tree based algorithm can be replaced with an algorithm that uses a suffix array enhanced with additional information and solves the same problem in the same time complexity (Source Wiki).
A suffix array can be constructed from Suffix tree by doing a DFS traversal of the suffix tree. In fact Suffix array and suffix tree both can be constructed from each other in linear time.
Advantages of suffix arrays over suffix trees include improved space requirements, simpler linear time construction algorithms (e.g., compared to Ukkonen’s algorithm) and improved cache locality (Source: Wiki)

http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
http://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/