// A Java Program to detect
// cycle in an undirected graph
import java.util.*;

public class GfG {

    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    static boolean isCyclicUtil(int v, List<List<Integer>> adj, 
                                boolean[] visited, int parent) {
      
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices
        // adjacent to this vertex
        for (int i : adj.get(v)) {
          
            // If an adjacent vertex is not visited,
            // then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, v))
                    return true;
            }
          
            // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains
    // a cycle, else false.
    static boolean isCyclic(int V, List<List<Integer>> adj) {
      
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Call the recursive helper function
        // to detect cycle in different DFS trees
        for (int u = 0; u < V; u++) {
          
            // Don't recur for u if it is already visited
            if (!visited[u]) {
                if (isCyclicUtil(u, adj, visited, -1))
                    return true;
            }
        }
        return false;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(0);
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);

        System.out.println(isCyclic(V, adj) ? 
                 "Contains cycle" : "No Cycle");

        V = 3;
        List<List<Integer>> adj2 = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<>());
        }

        adj2.get(0).add(1);
        adj2.get(1).add(0);
        adj2.get(1).add(2);
        adj2.get(2).add(1);

        System.out.println(isCyclic(V, adj2) ? 
                "Contains Cycle" : "No Cycle");
    }
}
