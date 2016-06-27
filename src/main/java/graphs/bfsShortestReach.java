package graphs;

import java.util.*;

/**
 * Created by gs on 2016-06-19.
 */
public class bfsShortestReach {

    static final String input = "2\n" +
            "4 2\n" +
            "1 2\n" +
            "1 3\n" +
            "1\n" +
            "3 1\n" +
            "2 3\n" +
            "2";

    public static void main(String[] args) {
        Scanner in = new Scanner(input);

        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {

            int numV = in.nextInt();

            GraphNode[] nodes = new GraphNode[numV];
            int numE = in.nextInt();

            for (int k = 0; k < numV; k++) {
                nodes[k] = new GraphNode(k);
            }

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt() -1 ;
                int b = in.nextInt() - 1;
                nodes[a].addEdge(b);
                nodes[b].addEdge(a);
            }

            int start = in.nextInt();

            bfsShortest(nodes, nodes[start - 1]);
        }

        in.close();
    }

    private static void bfsShortest(GraphNode[] graph, GraphNode node) {
        boolean[] visited = new boolean[graph.length];
        int[] shortest = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            shortest[i] = -1;
        }

        Queue<GraphPair> q = new ArrayDeque<>();
        visited[node.id] = true;
        q.add(new GraphPair(node, 0));

        while (!q.isEmpty()) {

            GraphPair ce = q.remove();
           // shortest[ce.node.id] = ce.dist;

            Iterator<GraphNode> iter = ce.node.edges.iterator();
            while (iter.hasNext()){
                GraphNode edge = graph[iter.next().id];
                    if (!visited[edge.id]) {
                        visited[edge.id] = true;
                        shortest[edge.id] = ce.dist + 1;
                        q.add(new GraphPair(edge, ce.dist + 1));
                    }
                }
        }

        for(int i=0; i<graph.length; i++ ) {
            if(node.id != i) {
                if(shortest[i]==-1) {
                    System.out.print("-1" + " ");
                } else {
                    System.out.print(shortest[i] * 6 + " ");
                }
            }
        }
        System.out.println();

    }

    static class GraphPair {
        GraphPair(GraphNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        GraphNode node;
        int dist;
    }

    static class GraphNode {
        GraphNode(int id) {
            this.id = id;
        }

        int id;

        LinkedList<GraphNode> edges = new LinkedList<>();

        void addEdge(int to) {
            edges.add(new GraphNode(to));
        }
    }
}
