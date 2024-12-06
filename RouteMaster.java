import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Queue;

public class RouteMaster {
    private static Queue<String> routeQueue = new LinkedList<>();

    // Refresh Display Area
    private static void refreshDisplayArea(JTextArea displayArea) {
        StringBuilder routesDisplay = new StringBuilder();

        // Iterate through the queue and display routes in reverse order
        LinkedList<String> reverseOrder = new LinkedList<>(routeQueue);
        while (!reverseOrder.isEmpty()) {
            routesDisplay.insert(0, reverseOrder.pollLast() + "\n");
        }
        displayArea.setText(routesDisplay.toString());
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Create the graph
        Graph graph = new Graph();

        graph.addNode("Ambernath");
        graph.addNode("Kalyan");
        graph.addNode("Dombivali");
        graph.addNode("Diva");
        graph.addNode("Thane");
        graph.addNode("Mulund");
        graph.addNode("Matunga");
        graph.addEdge("Mulund", "Matunga", 10);
        graph.addEdge("Thane", "Mulund", 15);
        graph.addEdge("Thane", "Matunga", 20);
        graph.addEdge("Diva", "Thane", 25);
        graph.addEdge("Diva", "Mulund", 30);
        graph.addEdge("Diva", "Matunga", 35);
        graph.addEdge("Dombivali", "Diva", 40);
        graph.addEdge("Dombivali", "Thane", 45);
        graph.addEdge("Dombivali", "Mulund", 50);
        graph.addEdge("Dombivali", "Matunga", 55);
        graph.addEdge("Kalyan", "Dombivali", 60);
        graph.addEdge("Kalyan", "Diva", 65);
        graph.addEdge("Kalyan", "Thane", 70);
        graph.addEdge("Kalyan", "Mulund", 75);
        graph.addEdge("Kalyan", "Matunga", 80);
        graph.addEdge("Ambernath", "Kalyan", 85);
        graph.addEdge("Ambernath", "Dombivali", 90);
        graph.addEdge("Ambernath", "Diva", 95);
        graph.addEdge("Ambernath", "Thane", 100);
        graph.addEdge("Ambernath", "Mulund", 105);
        graph.addEdge("Ambernath", "Matunga", 110);

        // Create the GUI
        JFrame frame = new JFrame("Bus Route Management");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(20, 20)); // Add padding between components

        // Top panel for input
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 20, 20)); // Adjust spacing between fields
        inputPanel.setPreferredSize(new Dimension(1920, 150)); // Adjust the height
        JLabel startLabel = new JLabel("Start Location:");
        startLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font
        JTextField startField = new JTextField();
        startField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel endLabel = new JLabel("End Location:");
        endLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField endField = new JTextField();
        endField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel intermediateLabel = new JLabel("Intermediate Location (comma-separated):");
        intermediateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField intermediateField = new JTextField();
        intermediateField.setFont(new Font("Arial", Font.PLAIN, 18));

        inputPanel.add(startLabel);
        inputPanel.add(startField);
        inputPanel.add(endLabel);
        inputPanel.add(endField);
        inputPanel.add(intermediateLabel);
        inputPanel.add(intermediateField);

        // Center panel for display
        JTextArea displayArea = new JTextArea();
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 22)); // Adjust font for readability
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(1920, 650)); // Adjust height

        // Bottom panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20)); // Adjust spacing and alignment
        JButton addRouteButton = new JButton("Add Route");
        addRouteButton.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font
        JButton deleteRouteButton = new JButton("Delete Route");
        deleteRouteButton.setFont(new Font("Arial", Font.BOLD, 18));
        JButton showRouteButton = new JButton("Show Minimum Route");
        showRouteButton.setFont(new Font("Arial", Font.BOLD, 18));

        buttonPanel.add(addRouteButton);
        buttonPanel.add(deleteRouteButton);
        buttonPanel.add(showRouteButton);

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Event handling (same as before)
        addRouteButton.addActionListener(e -> {
            String from = startField.getText().trim();
            String to = endField.getText().trim();
            String[] intermediates = intermediateField.getText().split(",");
            if (from.isEmpty() || to.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Start and End locations are required to add a route!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            graph.addNode(from);
            graph.addNode(to);
            for (String intermediate : intermediates) {
                intermediate = intermediate.trim();
                if (!intermediate.isEmpty()) {
                    graph.addNode(intermediate);
                    graph.addEdge(from, intermediate, 10);
                    from = intermediate;
                }
            }
            routeQueue.add(startField.getText() + " -> " + intermediateField.getText() + " -> " + endField.getText());
            refreshDisplayArea(displayArea);
        });

        deleteRouteButton.addActionListener(e -> {
            if (routeQueue.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No routes to delete!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String deletedRoute = routeQueue.poll();
            JOptionPane.showMessageDialog(frame, "Deleted route: " + deletedRoute, "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshDisplayArea(displayArea);
        });

        showRouteButton.addActionListener(e -> {
            String start = startField.getText().trim();
            String end = endField.getText().trim();
            String[] intermediates = intermediateField.getText().split(",");
            if (start.isEmpty() || end.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Start and End locations are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<String> route = new ArrayList<>();
            route.add(start);
            for (String intermediate : intermediates) {
                if (!intermediate.trim().isEmpty()) {
                    route.add(intermediate.trim());
                }
            }
            route.add(end);

            int totalDistance = 0;
            for (int i = 0; i < route.size() - 1; i++) {
                String from = route.get(i);
                String to = route.get(i + 1);
                Map<String, Integer> distances = graph.shortestPath(from);
                if (distances.containsKey(to)) {
                    totalDistance += distances.get(to);
                } else {
                    JOptionPane.showMessageDialog(frame, "No path found from " + from + " to " + to, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Minimum route: " + route + "\nTotal distance: " + totalDistance);
        });

        // Display the GUI
        frame.setVisible(true);
    }
}
