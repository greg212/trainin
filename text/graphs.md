
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

## Topological sort

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordereing of vertices
such that for every directed edge uv vertex u comes before v in the ordering.

Topological sorting is possible only for DAG.

Depth-first search based algorithm loops through each node of the graph, in an arbitrary order,
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
