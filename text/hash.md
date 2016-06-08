

// hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

Open adressing (closed hashing) - method of collision resolution in hash tables - each collision is resolved by probin until
target record is found or unused array slod is found



Linear probing
    in which the interval between probes is fixed — often at 1.
Quadratic probing
    in which the interval between probes increases linearly (hence, the indices are described by a quadratic function).
Double hashing
    in which the interval between probes is fixed for each record but is computed by another hash function.


    http://algs4.cs.princeton.edu/34hash/LinearProbingHashST.java.html

    http://www.algolist.net/Data_structures/Hash_table/Open_addressing