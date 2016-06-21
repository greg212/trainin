package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * http://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-7-dijkstras-algorithm-for-adjacency-list-representation/
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * <p>
 * <p>
 * Created by gs on 2016-06-19.
 */

@SuppressWarnings("unchecked")
public class dijkstraShortestReach {

    static final String input = "1\n" +
            "6 5\n" +
            "1 2 24\n" +
            "1 4 20\n" +
            "3 1 3\n" +
            "4 3 12\n" +
            "5 6 111\n" +
            "1";


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:/gs/input04.txt"));

        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {

            int numV = in.nextInt();
            int numE = in.nextInt();

            Graph graph = new Graph(numV);

            for (int k = 0; k < numE; k++) {
                int a = in.nextInt() - 1 ;
                int b = in.nextInt() - 1;
                int w = in.nextInt();
                graph.addEdge(a, b, w);
            }

            int start = in.nextInt();

            graph.dijkstraShortest(start - 1);
        }

        in.close();
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

    static public class DijkstraVert {
        int v;
        int dist;
        public DijkstraVert(int v, int dist) {
            this.v = v;
            this.dist = dist;
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
            adj[to].add(new GraphEdge(to, from, w)); //undirected
        }

        void dijkstraShortest(int vStart) {
            int[] distTo = new int[adj.length];
            GraphEdge[] edgeTo = new GraphEdge[adj.length];

            boolean[] visited = new boolean[adj.length];

            PriorityQueue<DijkstraVert> pq = new PriorityQueue<>((Comparator<DijkstraVert>) (p1, p2) -> {
                if(p1.dist < p2.dist) {
                    return -1;
                } else if(p1.dist > p2.dist){
                    return 1;
                }
                return 0;
            });

            distTo[vStart] = 0;
            for (int i = 0; i < adj.length; i++) {
                if (i != vStart) {
                    distTo[i] = Integer.MAX_VALUE;
                }
            }

            pq.add( new DijkstraVert(vStart, distTo[vStart]));

            visited[vStart] = true;

            while (!pq.isEmpty()) {

                DijkstraVert dijVert = pq.remove();



                visited[dijVert.v] = true;

                System.out.println(pq.size());

                for (GraphEdge edge : adj[dijVert.v]) {

                    if(!visited[edge.to]) {
                        int newDist = distTo[edge.from] + edge.w;
                        if (distTo[edge.to] > newDist) {
                            distTo[edge.to] = newDist;
                            edgeTo[edge.to] = edge;
                        }

                        pq.add(new DijkstraVert(edge.to, distTo[edge.to]));
                    }
                }
            }


            System.out.println("finished");

            for(int i=0 ; i< adj.length ; i++) {
                int goal = i;
                int currV = goal;
                int dist = 0;
                if(i == vStart) continue;

                while (true) {
                    GraphEdge curr = edgeTo[currV];
                    if(curr == null) { dist = -1 ; break; }
                    dist += curr.w;
                    currV = curr.from;
                    if (curr.from == vStart) {
                        break;
                    }

                }
             //   System.out.println(goal + " dist= " + dist);
                System.out.print(dist + " ");
            }
        }
    }
}
