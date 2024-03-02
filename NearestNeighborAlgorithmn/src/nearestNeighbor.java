import java.util.*;

public class nearestNeighbor {

    public static void nearestNeighborAlgorithm(int[][] graph) {
        int numVertices = graph.length;
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(visited, false);

        // Step 1: Initialize all vertices as unvisited
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // Step 2: Select an arbitrary vertex as the starting vertex
        int currentVertex = 0; // Choosing the first vertex arbitrarily
        visited[currentVertex] = true;

        System.out.println("Nearest Neighbor Algorithm Tour:");

        // Loop until all vertices are visited
        while (true) {
            System.out.print(currentVertex + " ");

            // Step 3: Find the nearest unvisited vertex
            int nearestVertex = findNearestVertex(graph[currentVertex], visited);
            if (nearestVertex == -1) {
                break; // All vertices visited
            }

            // Step 4: Set the nearest unvisited vertex as the current vertex
            currentVertex = nearestVertex;
            visited[currentVertex] = true;
        }
    }

    private static int findNearestVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int nearestVertex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                nearestVertex = i;
            }
        }

        return nearestVertex;
    }

    public static void main(String[] args) {
        int[][] distanceMatrix = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        nearestNeighborAlgorithm(distanceMatrix);
    }
}