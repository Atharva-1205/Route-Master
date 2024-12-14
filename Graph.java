import java.util.*;

class Graph {
    // Adjacency list to store graph edges
    final Map<String, List<Edge>> adjList = new HashMap<>();

    // Add a node to the graph
    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Add an edge between two nodes (bidirectional)
    public void addEdge(String from, String to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));
        adjList.get(to).add(new Edge(from, weight)); // Reverse edge
    }

    // Retrieve neighbors of a node
    public List<Edge> getNeighbors(String node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // Implement Dijkstra's algorithm for shortest paths
    public Map<String, Integer> shortestPath(String startNode) {
        // Map to store shortest distances
        Map<String, Integer> distances = new HashMap<>();
        for (String node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE); // Initialize all distances to infinity
        }
        distances.put(startNode, 0);

        // Priority queue for processing nodes by distance
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        queue.add(new Node(startNode, 0));

        // Set to track visited nodes
        Set<String> visited = new HashSet<>();

        // Process nodes in the graph
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // Skip already visited nodes
            if (visited.contains(currentNode.getName())) continue;
            visited.add(currentNode.getName());

            // Update distances to neighbors
            for (Edge edge : getNeighbors(currentNode.getName())) {
                String neighbor = edge.to;
                int newDist = distances.get(currentNode.getName()) + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    queue.add(new Node(neighbor, newDist));
                }
            }
        }

        return distances; // Return map of shortest distances
    }

    // Display the graph (optional debugging method)
    public void printGraph() {
        for (Map.Entry<String, List<Edge>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Edge edge : entry.getValue()) {
                System.out.print(edge.to + " (" + edge.weight + "), ");
            }
            System.out.println();
        }
    }

    // Nested class to represent an edge
    static class Edge {
        String to;
        int weight;

        Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Nested class to represent a node in the priority queue
    static class Node {
        private final String name;
        private final int distance;

        Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }
    }
}
