import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JTextArea itemList;
    private JLabel subtotalLabel;

    public Display() {
        frame = new JFrame("Cash Register");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
	    frame.setVisible(true);

        itemList = new JTextArea();
        itemList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemList);

        subtotalLabel = new JLabel("Subtotal: $0.00", SwingConstants.CENTER);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(subtotalLabel, BorderLayout.NORTH);
        frame.setVisible(true);

        itemList.setText("UPC\tName\tPrice\n");
    }

    public void updateDisplay(java.util.List<Product> items, double subtotal) {
        itemList.setText("UPC\tName\tPrice\n");
        for (Product p : items) {
            itemList.append(p.toString() + "\n");
        }
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
    }
}
