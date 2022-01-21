package com.surenderthakran.codes.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class DijkstraHeap {

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

    // Contains the shortest distance to every node from the source.
    // Only contains keys for nodes which have been visited.
    HashMap<Integer, Integer> nodeToDistanceMap = new HashMap<>();

    // A queue based on a min heap which contains distances to unvisited nodes from source node
    // in the format [node, distance].
    // When asked for a node's info, it would return the info for a node which is closest to the source.
    // It will contain multiple entries for a node since we do not update a node's distance on relaxation,
    // instead we simply add its latest distance while the old entry gets pushed downwards.
    PriorityQueue<int[]> unvisitedNodesHeap = new PriorityQueue<>(
        (edge1, edge2) -> edge1[1] - edge2[1]);

    // Set distance from source node to itself as 0.
    unvisitedNodesHeap.add(new int[]{sourceNode, 0});

    while (unvisitedNodesHeap.size() > 0) {
      int[] currentNodeInfo = unvisitedNodesHeap.remove();

      // If the current node is already visited, skip the node.
      if (nodeToDistanceMap.containsKey(currentNodeInfo[0])) {
        continue;
      }

      int currentNode = currentNodeInfo[0];
      int distanceToCurrentNodeFromSource = currentNodeInfo[1];
      // Mark current node as visited by storing its final distance to map.
      nodeToDistanceMap.put(currentNode, distanceToCurrentNodeFromSource);
      graph.get(currentNode).forEach((edge) -> {
        // If the node at the end of the edge is already visited, skip the edge.
        if (nodeToDistanceMap.containsKey(edge[0])) {
          return;
        }

        int targetNode = edge[0];
        int edgeLength = edge[1];
        unvisitedNodesHeap.add(new int[]{targetNode, distanceToCurrentNodeFromSource + edgeLength});
      });
    }

    return nodeToDistanceMap.values().stream().mapToInt(Integer::intValue).toArray();
  }
}