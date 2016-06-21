## Types

### Unidirected
An undirected graphs.SnakesNladders is a graphs.SnakesNladders in which edges have no orientation.
 The edge (x, y) is identical to the edge (y, x), i.e., they are not ordered pairs,
  but sets {x, y} (or 2-multisets) of vertices.
  The maximum number of edges in an undirected graphs.SnakesNladders without a loop is n(n − 1)/2.

## Directed graphs.SnakesNladders

A directed graphs.SnakesNladders or digraph is a graphs.SnakesNladders in which edges have orientations. It is written as an ordered pair G = (V, A) (sometimes G = (V, E)) with

    V a set whose elements are called vertices, nodes, or points;
    A a set of ordered pairs of vertices, called arrows, directed edges (sometimes simply edges with the corresponding set named E instead of A), directed arcs, or directed lines.

An arrow (x, y) is considered to be directed from x to y; y is called the head and x is called the tail of the arrow; y is said to be a direct successor of x and x is said to be a direct predecessor of y. If a path leads from x to y, then y is said to be a successor of x and reachable from x, and x is said to be a predecessor of y. The arrow (y, x) is called the inverted arrow of (x, y).

A directed graphs.SnakesNladders G is called symmetric if, for every arrow in G, the corresponding inverted arrow also belongs to G. A symmetric loopless directed graphs.SnakesNladders G = (V, A) is equivalent to a simple undirected graphs.SnakesNladders G′ = (V, E), where the pairs of inverse arrows in A correspond one-to-one with the edges in E; thus the number of edges in G′ is | E  | = | A  |/2, that is half the number of arrows in G.
## Depth-First

```
procedure DFS(G,v):
      label v as discovered
      for all edges from v to w in G.adjacentEdges(v) do
          if vertex w is not labeled as discovered then
              recursively call DFS(G,w)
```

```
procedure DFS-iterative(G,v):
    let S be a stack
    S.push(v)
    while S is not empty
        v = S.pop()
        if v is not labeled as discovered:
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do
                S.push(w)
```

## Breadth-First

```
Breadth-First-Search(Graph, root):
    for each node n in Graph:
        n.distance = INFINITY
        n.parent = NIL

    create empty queue Q

    root.distance = 0
    Q.enqueue(root)

    while Q is not empty:
        current = Q.dequeue()

        for each node n that is adjacent to current:

            if n.distance == INFINITY:
                n.distance = current.distance + 1
                n.parent = current
                Q.enqueue(n)

```

http://algs4.cs.princeton.edu/41graph/


## Topological sort

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordereing of vertices
such that for every directed edge uv vertex u comes before v in the ordering.

Topological sorting is possible only for DAG.

Depth-first search based algorithm loops through each node of the graphs.SnakesNladders, in an arbitrary order,
initiating a depth-first search that terminates when it hits any node that has already been visited since
the beginning of the topological sort or the node has no outgoing edges (i.e. a leaf node):

- run depth-first search
- return vertices in reverse postorder

https://www.youtube.com/watch?v=jksMzq4LgfM

```
L ← Empty list that will contain the sorted nodes
while there are unmarked nodes do
    select an unmarked node n
    visit(n)

function visit(node n)
    if n has a temporary mark then stop (not a DAG)
    if n is not marked (i.e. has not been visited yet) then
        mark n temporarily
        for each node m with an edge from n to m do
           visit(m)
        mark n permanently
        unmark n temporarily
        add n to head of L
```

## Dijkstra shortest path

### Basic

```
function Dijkstra(Graph, source):
2      dist[source] ← 0                                    // Initialization
3
4      create vertex set Q
5
6      for each vertex v in Graph:
7          if v ≠ source
8              dist[v] ← INFINITY                          // Unknown distance from source to v
9              prev[v] ← UNDEFINED                         // Predecessor of v
10
11         Q.add_with_priority(v, dist[v])
12
13
14     while Q is not empty:                              // The main loop
15         u ← Q.extract_min()                            // Remove and return best vertex
16         for each neighbor v of u:                       // only v that is still in Q
17             alt = dist[u] + length(u, v)
18             if alt < dist[v]
19                 dist[v] ← alt
20                 prev[v] ← u
21                 Q.decrease_priority(v, alt)
22
23     return dist[], prev[]
```

### Using a priority queue

```
function Dijkstra(Graph, source):
2      dist[source] ← 0                                    // Initialization
3
4      create vertex set Q
5
6      for each vertex v in Graph:
7          if v ≠ source
8              dist[v] ← INFINITY                          // Unknown distance from source to v
9              prev[v] ← UNDEFINED                         // Predecessor of v
10
11         Q.add_with_priority(v, dist[v])
12
13
14     while Q is not empty:                              // The main loop
15         u ← Q.extract_min()                            // Remove and return best vertex
16         for each neighbor v of u:                       // only v that is still in Q
17             alt = dist[u] + length(u, v)
18             if alt < dist[v]
19                 dist[v] ← alt
20                 prev[v] ← u
21                 Q.decrease_priority(v, alt)
22
23     return dist[], prev[]
```

## Prim MSP

1) Create a set mstSet that keeps track of vertices already included in MST.
2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the first vertex so that it is picked first.
3) While mstSet doesn’t include all vertices
….a) Pick a vertex u which is not there in mstSet and has minimum key value.
….b) Include u to mstSet.
….c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v