import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JTextArea itemList;
    private JLabel subtotalLabel;

    public Display() {
        // Set up the GUI components
        frame = new JFrame("Cash Register");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
	    frame.setVisible(true);

        // Item list area
        itemList = new JTextArea();
        itemList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemList);

        // Subtotal label
        subtotalLabel = new JLabel("Subtotal: $0.00", SwingConstants.CENTER);

        // Add components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(subtotalLabel, BorderLayout.NORTH);
        frame.setVisible(true);

        // Initialize display
        itemList.setText("UPC\tName\tPrice\n");
    }

    public void updateDisplay(java.util.List<Product> items, double subtotal) {
        // Update the item list and subtotal label
        itemList.setText("UPC\tName\tPrice\n");
        for (Product p : items) {
            itemList.append(p.toString() + "\n");
        }
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
    }
}
