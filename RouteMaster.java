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

        // Adding major cities
        // Adding major cities
        graph.addNode("New York");
        graph.addNode("Boston");
        graph.addNode("Philadelphia");
        graph.addNode("Chicago");
        graph.addNode("Atlanta");
        graph.addNode("Miami");
        graph.addNode("Houston");
        graph.addNode("Dallas");
        graph.addNode("San Antonio");
        graph.addNode("Denver");
        graph.addNode("Phoenix");
        graph.addNode("Las Vegas");
        graph.addNode("Los Angeles");
        graph.addNode("San Diego");
        graph.addNode("San Jose");
        graph.addNode("Seattle");

        // Adding edges (distances are in miles, approximate)
        graph.addEdge("New York", "Boston", 215);
        graph.addEdge("New York", "Philadelphia", 95);
        graph.addEdge("New York", "Chicago", 790);
        graph.addEdge("New York", "Atlanta", 870);
        graph.addEdge("New York", "Miami", 1280);
        graph.addEdge("New York", "Houston", 1630);
        graph.addEdge("New York", "Dallas", 1550);
        graph.addEdge("New York", "San Antonio", 1800);
        graph.addEdge("New York", "Denver", 1780);
        graph.addEdge("New York", "Phoenix", 2400);
        graph.addEdge("New York", "Las Vegas", 2530);
        graph.addEdge("New York", "Los Angeles", 2800);
        graph.addEdge("New York", "San Diego", 2900);
        graph.addEdge("New York", "San Jose", 2940);
        graph.addEdge("New York", "Seattle", 2850);

        graph.addEdge("Boston", "Philadelphia", 300);
        graph.addEdge("Boston", "Chicago", 850);
        graph.addEdge("Boston", "Atlanta", 1100);
        graph.addEdge("Boston", "Miami", 1500);
        graph.addEdge("Boston", "Houston", 1800);
        graph.addEdge("Boston", "Dallas", 1730);
        graph.addEdge("Boston", "San Antonio", 1980);
        graph.addEdge("Boston", "Denver", 1940);
        graph.addEdge("Boston", "Phoenix", 2460);
        graph.addEdge("Boston", "Las Vegas", 2590);
        graph.addEdge("Boston", "Los Angeles", 2960);
        graph.addEdge("Boston", "San Diego", 3050);
        graph.addEdge("Boston", "San Jose", 3100);
        graph.addEdge("Boston", "Seattle", 3000);

        graph.addEdge("Philadelphia", "Chicago", 760);
        graph.addEdge("Philadelphia", "Atlanta", 780);
        graph.addEdge("Philadelphia", "Miami", 1250);
        graph.addEdge("Philadelphia", "Houston", 1600);
        graph.addEdge("Philadelphia", "Dallas", 1500);
        graph.addEdge("Philadelphia", "San Antonio", 1750);
        graph.addEdge("Philadelphia", "Denver", 1720);
        graph.addEdge("Philadelphia", "Phoenix", 2330);
        graph.addEdge("Philadelphia", "Las Vegas", 2450);
        graph.addEdge("Philadelphia", "Los Angeles", 2700);
        graph.addEdge("Philadelphia", "San Diego", 2800);
        graph.addEdge("Philadelphia", "San Jose", 2850);
        graph.addEdge("Philadelphia", "Seattle", 2750);

        graph.addEdge("Chicago", "Atlanta", 720);
        graph.addEdge("Chicago", "Miami", 1370);
        graph.addEdge("Chicago", "Houston", 1080);
        graph.addEdge("Chicago", "Dallas", 970);
        graph.addEdge("Chicago", "San Antonio", 1170);
        graph.addEdge("Chicago", "Denver", 1000);
        graph.addEdge("Chicago", "Phoenix", 1750);
        graph.addEdge("Chicago", "Las Vegas", 1800);
        graph.addEdge("Chicago", "Los Angeles", 2010);
        graph.addEdge("Chicago", "San Diego", 2100);
        graph.addEdge("Chicago", "San Jose", 2130);
        graph.addEdge("Chicago", "Seattle", 2070);

        graph.addEdge("Atlanta", "Miami", 660);
        graph.addEdge("Atlanta", "Houston", 800);
        graph.addEdge("Atlanta", "Dallas", 780);
        graph.addEdge("Atlanta", "San Antonio", 920);
        graph.addEdge("Atlanta", "Denver", 1400);
        graph.addEdge("Atlanta", "Phoenix", 1600);
        graph.addEdge("Atlanta", "Las Vegas", 1700);
        graph.addEdge("Atlanta", "Los Angeles", 1900);
        graph.addEdge("Atlanta", "San Diego", 2000);
        graph.addEdge("Atlanta", "San Jose", 2050);
        graph.addEdge("Atlanta", "Seattle", 2200);

        graph.addEdge("Miami", "Houston", 1190);
        graph.addEdge("Miami", "Dallas", 1280);
        graph.addEdge("Miami", "San Antonio", 1430);
        graph.addEdge("Miami", "Denver", 1720);
        graph.addEdge("Miami", "Phoenix", 2000);
        graph.addEdge("Miami", "Las Vegas", 2100);
        graph.addEdge("Miami", "Los Angeles", 2300);
        graph.addEdge("Miami", "San Diego", 2400);
        graph.addEdge("Miami", "San Jose", 2500);
        graph.addEdge("Miami", "Seattle", 2900);

        graph.addEdge("Houston", "Dallas", 240);
        graph.addEdge("Houston", "San Antonio", 200);
        graph.addEdge("Houston", "Denver", 1020);
        graph.addEdge("Houston", "Phoenix", 1200);
        graph.addEdge("Houston", "Las Vegas", 1500);
        graph.addEdge("Houston", "Los Angeles", 1550);
        graph.addEdge("Houston", "San Diego", 1620);
        graph.addEdge("Houston", "San Jose", 1700);
        graph.addEdge("Houston", "Seattle", 1890);

        graph.addEdge("Dallas", "San Antonio", 270);
        graph.addEdge("Dallas", "Denver", 800);
        graph.addEdge("Dallas", "Phoenix", 1000);
        graph.addEdge("Dallas", "Las Vegas", 1050);
        graph.addEdge("Dallas", "Los Angeles", 1400);
        graph.addEdge("Dallas", "San Diego", 1460);
        graph.addEdge("Dallas", "San Jose", 1500);
        graph.addEdge("Dallas", "Seattle", 1700);

        graph.addEdge("San Antonio", "Denver", 900);
        graph.addEdge("San Antonio", "Phoenix", 990);
        graph.addEdge("San Antonio", "Las Vegas", 1030);
        graph.addEdge("San Antonio", "Los Angeles", 1200);
        graph.addEdge("San Antonio", "San Diego", 1300);
        graph.addEdge("San Antonio", "San Jose", 1350);
        graph.addEdge("San Antonio", "Seattle", 1600);

        graph.addEdge("Denver", "Phoenix", 830);
        graph.addEdge("Denver", "Las Vegas", 750);
        graph.addEdge("Denver", "Los Angeles", 1010);
        graph.addEdge("Denver", "San Diego", 1100);
        graph.addEdge("Denver", "San Jose", 1200);
        graph.addEdge("Denver", "Seattle", 1300);

        graph.addEdge("Phoenix", "Las Vegas", 300);
        graph.addEdge("Phoenix", "Los Angeles", 400);
        graph.addEdge("Phoenix", "San Diego", 500);
        graph.addEdge("Phoenix", "San Jose", 650);
        graph.addEdge("Phoenix", "Seattle", 1500);

        graph.addEdge("Las Vegas", "Los Angeles", 270);
        graph.addEdge("Las Vegas", "San Diego", 330);
        graph.addEdge("Las Vegas", "San Jose", 430);
        graph.addEdge("Las Vegas", "Seattle", 1250);

        graph.addEdge("Los Angeles", "San Diego", 120);
        graph.addEdge("Los Angeles", "San Jose", 340);
        graph.addEdge("Los Angeles", "Seattle", 950);

        graph.addEdge("San Diego", "San Jose", 450);
        graph.addEdge("San Diego", "Seattle", 1050);

        graph.addEdge("San Jose", "Seattle", 750);

        // Adding duplicate edges with higher costs to simulate alternative paths
        graph.addEdge("New York", "Boston", (int) (215 * 1.5));
        graph.addEdge("New York", "Philadelphia", (int) (95 * 1.5));
        graph.addEdge("New York", "Chicago", (int) (790 * 1.5));
        graph.addEdge("New York", "Atlanta", (int) (870 * 1.5));
        graph.addEdge("New York", "Miami", (int) (1280 * 1.5));
        graph.addEdge("New York", "Houston", (int) (1630 * 1.5));
        graph.addEdge("New York", "Dallas", (int) (1550 * 1.5));
        graph.addEdge("New York", "San Antonio", (int) (1800 * 1.5));
        graph.addEdge("New York", "Denver", (int) (1780 * 1.5));
        graph.addEdge("New York", "Phoenix", (int) (2400 * 1.5));
        graph.addEdge("New York", "Las Vegas", (int) (2530 * 1.5));
        graph.addEdge("New York", "Los Angeles", (int) (2800 * 1.5));
        graph.addEdge("New York", "San Diego", (int) (2900 * 1.5));
        graph.addEdge("New York", "San Jose", (int) (2940 * 1.5));
        graph.addEdge("New York", "Seattle", (int) (2850 * 1.5));

        graph.addEdge("Boston", "Philadelphia",(int) (300 * 1.5));
        graph.addEdge("Boston", "Chicago",(int) (850 * 1.5));
        graph.addEdge("Boston", "Atlanta",(int) (1100 * 1.5));
        graph.addEdge("Boston", "Miami",(int) (1500 * 1.5));
        graph.addEdge("Boston", "Houston",(int) (1800 * 1.5));
        graph.addEdge("Boston", "Dallas",(int) (1730 * 1.5));
        graph.addEdge("Boston", "San Antonio",(int) (1980 * 1.5));
        graph.addEdge("Boston", "Denver",(int) (1940 * 1.5));
        graph.addEdge("Boston", "Phoenix",(int) (2460 * 1.5));
        graph.addEdge("Boston", "Las Vegas",(int) (2590 * 1.5));
        graph.addEdge("Boston", "Los Angeles",(int) (2960 * 1.5));
        graph.addEdge("Boston", "San Diego",(int) (3050 * 1.5));
        graph.addEdge("Boston", "San Jose",(int) (3100 * 1.5));
        graph.addEdge("Boston", "Seattle",(int) (3000 * 1.5));

        graph.addEdge("Philadelphia", "Chicago",(int) (760 * 1.5));
        graph.addEdge("Philadelphia", "Atlanta",(int) (780 * 1.5));
        graph.addEdge("Philadelphia", "Miami",(int) (1250 * 1.5));
        graph.addEdge("Philadelphia", "Houston",(int) (1600 * 1.5));
        graph.addEdge("Philadelphia", "Dallas",(int) (1500 * 1.5));
        graph.addEdge("Philadelphia", "San Antonio",(int) (1750 * 1.5));
        graph.addEdge("Philadelphia", "Denver",(int) (1720 * 1.5));
        graph.addEdge("Philadelphia", "Phoenix",(int) (2330 * 1.5));
        graph.addEdge("Philadelphia", "Las Vegas",(int) (2450 * 1.5));
        graph.addEdge("Philadelphia", "Los Angeles",(int) (2700 * 1.5));
        graph.addEdge("Philadelphia", "San Diego",(int) (2800 * 1.5));
        graph.addEdge("Philadelphia", "San Jose",(int) (2850 * 1.5));
        graph.addEdge("Philadelphia", "Seattle",(int) (2750 * 1.5));

        graph.addEdge("Chicago", "Atlanta",(int) (720 * 1.5));
        graph.addEdge("Chicago", "Miami",(int) (1370 * 1.5));
        graph.addEdge("Chicago", "Houston",(int) (1080 * 1.5));
        graph.addEdge("Chicago", "Dallas",(int) (970 * 1.5));
        graph.addEdge("Chicago", "San Antonio",(int) (1170 * 1.5));
        graph.addEdge("Chicago", "Denver",(int) (1000 * 1.5));
        graph.addEdge("Chicago", "Phoenix",(int) (1750 * 1.5));
        graph.addEdge("Chicago", "Las Vegas",(int) (1800 * 1.5));
        graph.addEdge("Chicago", "Los Angeles",(int) (2010 * 1.5));
        graph.addEdge("Chicago", "San Diego",(int) (2100 * 1.5));
        graph.addEdge("Chicago", "San Jose",(int) (2130 * 1.5));
        graph.addEdge("Chicago", "Seattle",(int) (2070 * 1.5));

        graph.addEdge("Atlanta", "Miami",(int) (660 * 1.5));
        graph.addEdge("Atlanta", "Houston",(int) (800 * 1.5));
        graph.addEdge("Atlanta", "Dallas",(int) (780 * 1.5));
        graph.addEdge("Atlanta", "San Antonio",(int) (920 * 1.5));
        graph.addEdge("Atlanta", "Denver",(int) (1400 * 1.5));
        graph.addEdge("Atlanta", "Phoenix",(int) (1600 * 1.5));
        graph.addEdge("Atlanta", "Las Vegas",(int) (1700 * 1.5));
        graph.addEdge("Atlanta", "Los Angeles",(int) (1900 * 1.5));
        graph.addEdge("Atlanta", "San Diego",(int) (2000 * 1.5));
        graph.addEdge("Atlanta", "San Jose",(int) (2050 * 1.5));
        graph.addEdge("Atlanta", "Seattle",(int) (2200 * 1.5));

        graph.addEdge("Miami", "Houston",(int) (1190 * 1.5));
        graph.addEdge("Miami", "Dallas",(int) (1280 * 1.5));
        graph.addEdge("Miami", "San Antonio",(int) (1430 * 1.5));
        graph.addEdge("Miami", "Denver",(int) (1720 * 1.5));
        graph.addEdge("Miami", "Phoenix",(int) (2000 * 1.5));
        graph.addEdge("Miami", "Las Vegas",(int) (2100 * 1.5));
        graph.addEdge("Miami", "Los Angeles",(int) (2300 * 1.5));
        graph.addEdge("Miami", "San Diego",(int) (2400 * 1.5));
        graph.addEdge("Miami", "San Jose",(int) (2500 * 1.5));
        graph.addEdge("Miami", "Seattle",(int) (2900 * 1.5));

        graph.addEdge("Houston", "Dallas",(int) (240 * 1.5));
        graph.addEdge("Houston", "San Antonio",(int) (200 * 1.5));
        graph.addEdge("Houston", "Denver",(int) (1020 * 1.5));
        graph.addEdge("Houston", "Phoenix",(int) (1200 * 1.5));
        graph.addEdge("Houston", "Las Vegas",(int) (1500 * 1.5));
        graph.addEdge("Houston", "Los Angeles",(int) (1550 * 1.5));
        graph.addEdge("Houston", "San Diego",(int) (1620 * 1.5));
        graph.addEdge("Houston", "San Jose",(int) (1700 * 1.5));
        graph.addEdge("Houston", "Seattle",(int) (1890 * 1.5));

        graph.addEdge("Dallas", "San Antonio",(int) (270 * 1.5));
        graph.addEdge("Dallas", "Denver",(int) (800 * 1.5));
        graph.addEdge("Dallas", "Phoenix",(int) (1000 * 1.5));
        graph.addEdge("Dallas", "Las Vegas",(int) (1050 * 1.5));
        graph.addEdge("Dallas", "Los Angeles",(int) (1400 * 1.5));
        graph.addEdge("Dallas", "San Diego",(int) (1460 * 1.5));
        graph.addEdge("Dallas", "San Jose",(int) (1500 * 1.5));
        graph.addEdge("Dallas", "Seattle",(int) (1700 * 1.5));

        graph.addEdge("San Antonio", "Denver",(int) (900 * 1.5));
        graph.addEdge("San Antonio", "Phoenix",(int) (990 * 1.5));
        graph.addEdge("San Antonio", "Las Vegas",(int) (1030 * 1.5));
        graph.addEdge("San Antonio", "Los Angeles",(int) (1200 * 1.5));
        graph.addEdge("San Antonio", "San Diego",(int) (1300 * 1.5));
        graph.addEdge("San Antonio", "San Jose",(int) (1350 * 1.5));
        graph.addEdge("San Antonio", "Seattle",(int) (1600 * 1.5));

        graph.addEdge("Denver", "Phoenix",(int) (830 * 1.5));
        graph.addEdge("Denver", "Las Vegas",(int) (750 * 1.5));
        graph.addEdge("Denver", "Los Angeles",(int) (1010 * 1.5));
        graph.addEdge("Denver", "San Diego",(int) (1100 * 1.5));
        graph.addEdge("Denver", "San Jose",(int) (1200 * 1.5));
        graph.addEdge("Denver", "Seattle",(int) (1300 * 1.5));

        graph.addEdge("Phoenix", "Las Vegas",(int) (300 * 1.5));
        graph.addEdge("Phoenix", "Los Angeles",(int) (400 * 1.5));
        graph.addEdge("Phoenix", "San Diego",(int) (500 * 1.5));
        graph.addEdge("Phoenix", "San Jose",(int) (650 * 1.5));
        graph.addEdge("Phoenix", "Seattle",(int) (1500 * 1.5));

        graph.addEdge("Las Vegas", "Los Angeles",(int) (270 * 1.5));
        graph.addEdge("Las Vegas", "San Diego",(int) (330 * 1.5));
        graph.addEdge("Las Vegas", "San Jose",(int) (430 * 1.5));
        graph.addEdge("Las Vegas", "Seattle",(int) (1250 * 1.5));

        graph.addEdge("Los Angeles", "San Diego",(int) (120 * 1.5));
        graph.addEdge("Los Angeles", "San Jose",(int) (340 * 1.5));
        graph.addEdge("Los Angeles", "Seattle",(int) (950 * 1.5));

        graph.addEdge("San Diego", "San Jose",(int) (450 * 1.5));
        graph.addEdge("San Diego", "Seattle",(int) (1050 * 1.5));

        graph.addEdge("San Jose", "Seattle",(int) (750 * 1.5));

        // Adding alternative indirect connections
        // graph.addEdge("New York", "Seattle", 2850); // Indirect via other cities
        // graph.addEdge("Chicago", "Seattle", 2070); // Indirect higher-cost route
        // graph.addEdge("Phoenix", "Seattle", 1450); // Indirect higher-cost route
        // graph.addEdge("Boston", "Miami", 1600); // Indirect higher-cost route
        // graph.addEdge("Denver", "Miami", 1720); // Indirect higher-cost route

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
                JOptionPane.showMessageDialog(frame, "Start and End locations are required to add a route!", "Error",
                        JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(frame, "Deleted route: " + deletedRoute, "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            refreshDisplayArea(displayArea);
        });

        showRouteButton.addActionListener(e -> {
            String start = startField.getText().trim();
            String end = endField.getText().trim();
            String[] intermediates = intermediateField.getText().split(",");
            if (start.isEmpty() || end.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Start and End locations are required!", "Error",
                        JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(frame, "No path found from " + from + " to " + to, "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Minimum route: " + route + "\nTotal distance: " + totalDistance);
        });

        // Display the GUI
        frame.setVisible(true);
    }
}
