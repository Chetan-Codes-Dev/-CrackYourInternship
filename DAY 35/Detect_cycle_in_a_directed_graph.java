import java.util.ArrayList;
import java.util.List;

class GfG {
    
    // Utility function to detect cycle in a directed graph
    private static boolean isCyclicUtil(List<List<Integer>> adj, int u, 
                              boolean[] visited, boolean[] recStack) {
      
        if (!visited[u]) {
          
            // Mark the current node as visited 
            // and part of recursion stack
            visited[u] = true;
            recStack[u] = true;

            // Recur for all the vertices adjacent
            // to this vertex
            for (int x : adj.get(u)) {
                if (!visited[x] && 
                    isCyclicUtil(adj, x, visited, recStack)) {
                    return true;
                } else if (recStack[x]) {
                    return true;
                }
            }
        }

        // Remove the vertex from recursion stack
        recStack[u] = false;
        return false;
    }

    // Function to detect cycle in a directed graph
    public static boolean isCyclic(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to 
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    // Driver function
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Function call
        if (isCyclic(adj, V)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }
}
