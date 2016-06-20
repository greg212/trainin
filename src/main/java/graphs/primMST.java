package graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * UNIDIRECTED
 *
 *
 * <p>
 * <p>
 * Created by gs on 2016-06-19.
 */
public class primMST {

    static final String input = "5 6\n" +
            "1 2 3\n" +
            "1 3 4\n" +
            "4 2 6\n" +
            "5 2 2\n" +
            "2 3 5\n" +
            "3 5 7\n" +
            "1";

    public static void main(String[] args) {
        Scanner in = new Scanner(input);


            int numV = in.nextInt();
            int numE = in.nextInt();

            Graph graph = new Graph(numV);

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int w = in.nextInt();
                graph.addEdge(a, b, w);
            }

            int start = in.nextInt()-1;

            graph.primMST(start);

        in.close();
    }


    static class GraphPair {
        int from;
        int key;
        GraphPair(int from, int key) {
            this.from = from;
            this.key = key;
        }
    }

    static class GraphEdge {
        int from;
        int to;
        int w;
        GraphEdge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static class Graph {
        LinkedList<GraphEdge>[] adj;

        Graph(int V) {
            this.adj = (LinkedList<GraphEdge>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<GraphEdge>();
            }
        }

        void addEdge(int from, int to, int w) {
            adj[from].add(new GraphEdge(from, to, w));
        }

        void primMST(int vStart) {
            int[] key = new int[adj.length]; //cokolwiek to znaczy ale tak nazywaja
            int[] prev = new int[adj.length];
            boolean[] inMST = new boolean[adj.length];

            PriorityQueue<GraphPair> q = new PriorityQueue<>(new Comparator<GraphPair>() {
                @Override
                public int compare(GraphPair p1, GraphPair p2) {
                    if(p1.key < p2.key) {
                        return -1;
                    } else if(p1.key > p2.key){
                        return 1;
                    }

                    return 0;
                }
            });

            key[vStart] = 0;
            for (int i = 0; i < adj.length; i++) {
                inMST[i] = false;
                if (i != vStart) {
                    key[i] = Integer.MAX_VALUE;
                }
                prev[i] = -1;
                q.add(new GraphPair(i, key[i])); // add all verts
            }

            int sum = 0;

            while (!q.isEmpty()) {
                GraphPair pair = q.remove();

                inMST[pair.from] = true;

                for (GraphEdge edge : adj[pair.from]) {
                    if (inMST[edge.to] == false) {
                        if (edge.w < key[edge.to]) {
                            key[edge.to] = edge.w;
                            prev[edge.to] = pair.from;

                            q.add(new GraphPair(edge.to, key[edge.to]));
                            sum += edge.w;
                        }
                    }
                }
            }

            System.out.print(sum);
        }
    }
}
