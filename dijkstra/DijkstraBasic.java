package com.surenderthakran.codes.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * For a graph with N nodes and E edges, the time and space complexities for wost case (Complete
 * graph i.e. every node is connected to every other node) can be described as following:
 * <p>Time complexity: O(N^2)
 * <p>Space Complexity: O(N + E)
 */
class DijkstraBasic {

  /**
   * Returns the distances from source node to all nodes in the undirected graph.
   *
   * @param edges      Two-dimensional array representing edges between nodes in the undirected
   *                   graph. Format: [[n1,n2,d1], [n2,n3,d2]]
   * @param sourceNode Source node id.
   * @return Integer array of distances from source node to all nodes in the undirected graph.
   */
  static int[] findShortestPaths(int[][] edges, int sourceNode) {
    // Create map representing the graph with key as node and value a list of arrays representing
    // outgoing edges from the node. ex: {n1: [[n2, d1], [n3, d2]], n2: [[n4, d3]]}
    HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
    for (int[] edge : edges) {
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new ArrayList<int[]>());
      }
      if (!graph.containsKey(edge[1])) {
        graph.put(edge[1], new ArrayList<int[]>());
      }
      graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
      graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
    }

    int[] distances = new int[graph.keySet().size()];
    // Set minimum distances to all nodes from source nodes in the graph as infinity.
    for (int i = 0; i < distances.length; i++) {
      distances[i] = Integer.MAX_VALUE;
    }
    // Set minimum distance from source node to itself as 0.
    distances[sourceNode] = 0;

    // Track node visit status in a boolean array. Initially all nodes are false (unvisited).
    boolean[] visitedNodes = new boolean[graph.keySet().size()];

    while (true) {
      int currentNode = getNodeToProcess(distances, visitedNodes);
      // Exit when there are either no unvisited nodes left or when the unvisited node(s) are
      // unreachable from source node.
      if (currentNode == -1) {
        break;
      }

      int distanceFromSourceToCurrentNode = distances[currentNode];

      // Try to relax distance to every unvisited outgoing neighbour node of the current node.
      graph.get(currentNode).forEach(edge -> {
        int targetNode = edge[0];
        int edgeLength = edge[1];
        int candidateDistance = distanceFromSourceToCurrentNode + edgeLength;
        // Only try to relax distance if the target node is unvisited.
        if (!visitedNodes[targetNode]) {
          if (candidateDistance < distances[targetNode]) {
            distances[targetNode] = candidateDistance;
          }
        }
      });

      // Mark current node as visited.
      visitedNodes[currentNode] = true;
    }

    return distances;
  }

  /**
   * Return a node from the yet unvisited nodes with the smallest distance from source node. Return
   * -1 if no more unvisited nodes are left or if the node with the smallest distance still has
   * infinity as its distance.
   */
  private static int getNodeToProcess(int[] distances, boolean[] visitedNodes) {
    int resultNode = -1;
    int smallestDistance = Integer.MAX_VALUE;
    for (int node = 0; node < distances.length; node++) {
      if (distances[node] < smallestDistance && !visitedNodes[node]) {
        resultNode = node;
        smallestDistance = distances[node];
      }
    }
    return resultNode;
  }
}