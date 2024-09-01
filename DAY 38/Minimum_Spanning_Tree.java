// Java Program to Implement MST
// Using Kruskal's Algorithm
import java.util.*;

// Class to represent an edge in a graph
class Edge implements Comparable<Edge> {
   int source, destination, weight;

   // Constructor to initialize an edge
   public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
   }

   // Method to compare edges based on their weight
   public int compareTo(Edge compareEdge) {
      return this.weight - compareEdge.weight;
   }
}

// Driver Class
public class Main {

   // Method to find the parent of a node in the disjoint set
   private int findParent(int[] parent, int i) {
      if (parent[i] == -1)
         return i;
      return findParent(parent, parent[i]);
   }

   // Method to perform union of two subsets
   private void union(int[] parent, int x, int y) {
      int xSet = findParent(parent, x);
      int ySet = findParent(parent, y);
      parent[xSet] = ySet;
   }

   // Method to find the Minimum Spanning Tree (MST) using Kruskal's algorithm
   public List<Edge> findMST(List<Edge> edges, int numberOfVertices) {
      List<Edge> result = new ArrayList<>();
      int[] parent = new int[numberOfVertices];
      Arrays.fill(parent, -1);

      // Sort all the edges based on their weight
      Collections.sort(edges);
      int edgeCount = 0;
      int index = 0;

      // Iterate through sorted edges and add
      // them to the MST if they don't form a cycle
      while (edgeCount < numberOfVertices - 1) {
         Edge nextEdge = edges.get(index++);
         int x = findParent(parent, nextEdge.source);
         int y = findParent(parent, nextEdge.destination);

         // If including this edge doesn't cause a cycle,
         // include it in the result
         if (x != y) {
            result.add(nextEdge);
            union(parent, x, y);
            edgeCount++;
         }
      }
      return result;
   }

   // Main Function
   public static void main(String[] args) {
      // Create a list of edges for testing
      List<Edge> edges = new ArrayList<>();
      edges.add(new Edge(0, 1, 2));
      edges.add(new Edge(0, 3, 6));
      edges.add(new Edge(1, 2, 3));
      edges.add(new Edge(1, 3, 8));
      edges.add(new Edge(1, 4, 5));
      edges.add(new Edge(2, 4, 7));
      edges.add(new Edge(3, 4, 9));

      int numberOfVertices = 5;

      // Create an instance of the Main class
      Main main = new Main();

      // Find the MST using Kruskal's algorithm
      List<Edge> mstEdges = main.findMST(edges, numberOfVertices);

      // Print the edges in the Minimum Spanning Tree
      System.out.println("Minimum Spanning Tree Edges:");
      for (Edge edge : mstEdges) {
         System.out.println("(" + edge.source + ", " + edge.destination +
                            ", " + edge.weight + ")");
      }
   }
}
