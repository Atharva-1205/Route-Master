import java.util.*;

class Graph {
    final Map<String, List<Edge>> adjList = new HashMap<>();

    // Add a node to the graph
    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Add an edge between two nodes
    public void addEdge(String from, String to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));
        adjList.get(to).add(new Edge(from, weight));
    }

    // Get neighbors of a node
    public List<Edge> getNeighbors(String node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // Shortest path using Dijkstra's algorithm
    public Map<String, Integer> shortestPath(String startNode) {
        // Map to store shortest distances from the startNode
        Map<String, Integer> distances = new HashMap<>();
        for (String node : adjList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);

        // Priority queue to process nodes in order of their distance
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        queue.add(new Node(startNode, 0));

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (visited.contains(currentNode.getName())) continue;
            visited.add(currentNode.getName());

            for (Edge edge : getNeighbors(currentNode.getName())) {
                String neighbor = edge.to;
                int newDist = distances.get(currentNode.getName()) + edge.weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    queue.add(new Node(neighbor, newDist));
                }
            }
        }

        return distances;
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
