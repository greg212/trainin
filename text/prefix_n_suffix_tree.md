In computer science, a trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes),
is an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings.
Unlike a binary search tree, no node in the tree stores the key associated with that node;
instead, its position in the tree defines the key with which it is associated.
 All the descendants of a node have a common prefix of the string associated with that node,
 and the root is associated with the empty string.
 Values are not necessarily associated with every node.

  Rather, values tend only to be associated with leaves, a
 nd with some inner nodes that correspond to keys of interest.

 For the space-optimized presentation of prefix tree, see compact prefix tree.


 Tries
 Smalles tree such that:
 - Each edge is labeled with a character from Sigma
 - A node has at most one outgoing edge labeled with c, for any c in Sigma
 - Each key is "spelled out" along some path starting at the root


As discussed below, a trie has a number of advantages over binary search trees.[6] A trie can also be used to replace a hash table, over which it has the following advantages:

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