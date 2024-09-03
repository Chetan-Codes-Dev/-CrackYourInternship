import java.util.*;

public class CharacterOrder {

    // Function to add a directed edge between characters u and v
    static void addEdge(ArrayList<Integer>[] adj, char u, char v) {
        adj[u - 'a'].add(v - 'a');
    }

    // Depth-First Search (DFS) function to check for cycles in the graph
    static void dfs(ArrayList<Integer>[] adj, int[] col, int curr, boolean[] isCyclic) {
        col[curr] = 1;

        for (int i = 0; i < adj[curr].size(); i++) {
            int x = adj[curr].get(i);
            if (col[x] == 1) {
                isCyclic[0] = true;
                return;
            } else if (col[x] == 0) {
                dfs(adj, col, x, isCyclic);
            }
        }

        col[curr] = 2;
    }

    // Function to check if a cycle exists in the graph using DFS
    static boolean checkCycle(ArrayList<Integer>[] adj, int[] col, int k) {
        boolean[] isCyclic = { false };
        for (int i = 0; i < k; i++) {
            if (col[i] == 0) {
                dfs(adj, col, i, isCyclic);
            }
        }
        return isCyclic[0];
    }

    // DFS-based topological sorting utility function
    static void topologicalSortUtil(ArrayList<Integer>[] adj, int u, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (!visited[v]) {
                topologicalSortUtil(adj, v, visited, st);
            }
        }
        st.push(u);
    }

    // Function to perform topological sorting
    static void topologicalSort(ArrayList<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(adj, i, visited, st);
            }
        }

        // Print the characters in topological order
        while (!st.isEmpty()) {
            System.out.print((char) (st.pop() + 'a') + " ");
        }
    }

    // Function to process the words and find the character order
    static void printOrder(String[] words, int n) {
        // To track the frequency of characters
        int[] frq = new int[26];

        // Count of unique characters
        int k = 0;

        // Count unique characters and their frequencies
        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                frq[s.charAt(j) - 'a']++;
                if (frq[s.charAt(j) - 'a'] == 1)
                    k++;
            }
        }

        // Create adjacency list for the graph
        ArrayList<Integer>[] adj = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the graph by iterating through adjacent words
        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int j = 0;
            while (j < word1.length() && j < word2.length()) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    // Add edges based on character order
                    addEdge(adj, word1.charAt(j), word2.charAt(j));
                    break;
                }
                j++;
            }
        }

        // Color array for cycle detection
        int[] col = new int[k];
        if (checkCycle(adj, col, k)) {
            // Detect and handle cycles
            System.out.println("Valid Order is not possible");
            return;
        }

        // Perform topological sorting and print character order
        topologicalSort(adj, k);
    }

    // Driver Code
    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        int n = words.length;

        printOrder(words, n);
    }
}
