package graphs;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * http://algs4.cs.princeton.edu/44sp/
 * Created by gs on 2016-06-19.
 *
 */
public class dijkstraShortestReach {

    static final String input = "1\n" +
            "8\n" +
            "15\n" +
            "4 5 35\n" +
            "5 4 35\n" +
            "4 7 37\n" +
            "5 7 28\n" +
            "7 5 28\n" +
            "5 1 32\n" +
            "0 4 38\n" +
            "0 2 26\n" +
            "7 3 39\n" +
            "1 3 29\n" +
            "2 7 34\n" +
            "6 2 40\n" +
            "3 6 52\n" +
            "6 0 58\n" +
            "6 4 93";

    public static void main(String[] args) {
        Scanner in = new Scanner(input);

        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {

            int numV = in.nextInt();
            int numE = in.nextInt();

            Graph graph = new Graph(numV);

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt();// -1 ;
                int b = in.nextInt();// - 1;
                int w = in.nextInt();
                graph.addEdge(a, b, w);
            }

            int start = 0;//TODO in.nextInt();

            graph.dijkstraShortest(start /* - 1*/);
        }

        in.close();
    }



    static class GraphPair {
        GraphPair(int from, int dist) {
            this.from = from;
            this.dist = dist;
        }

        int from;
        int dist;
    }

    static class GraphEdge {
        GraphEdge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        int from;
        int to;
        int w;
    }

    static class Graph {
        LinkedList<GraphEdge>[] adj;

        Graph(int V) {
            this.adj = (LinkedList<GraphEdge>[])new LinkedList[V];
            for(int v=0;v<V; v++) {
                adj[v] = new LinkedList<GraphEdge>();
            }
        }

        void addEdge(int from, int to, int w) {
           adj[from].add(new GraphEdge(from, to, w));
        }

        void dijkstraShortest(int vStart) {
            boolean[] visited = new boolean[adj.length];
            int[] shortest = new int[adj.length];

            for (int i = 0; i < adj.length; i++) {
                shortest[i] = Integer.MAX_VALUE;
            }

            Queue<GraphPair> q = new ArrayDeque<>();
            visited[vStart] = true;
            q.add(new GraphPair(vStart, 0));

            while (!q.isEmpty()) {
                GraphPair ce = q.remove();

                for( GraphEdge edge : adj[ce.from]) {
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        shortest[edge.to] = ce.dist + 1;
                        q.add(new GraphPair(edge.to, ce.dist + 1));
                    }
                }
            }

            for(int i=0; i<adj.length; i++ ) {
                if(vStart != i) {
                    if(shortest[i]==-1) {
                        System.out.print("-1" + " ");
                    } else {
                        System.out.print(shortest[i] * 6 + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
