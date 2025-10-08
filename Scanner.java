
// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scanner {
	// Scanner uses Swing framework to create a UPC code
	private JFrame frame;
	private JPanel scannerPanel;
	private JButton scanButton;
	private List<String> productLines;

	public Scanner() {

		frame = new JFrame("Scanner");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setLocation(300, 50);
		frame.setVisible(true);

		try {
			productLines = Files.readAllLines(Path.of("products.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create UI elements
		scanButton = new JButton("Scan");
		scannerPanel = new JPanel();

		// Add UI element to frame
		scannerPanel.add(scanButton);
		frame.getContentPane().add(scannerPanel);
		frame.setVisible(true);

		scanButton.addActionListener(e -> generateUPC());


	}

	private void generateUPC() {
		Random random = new Random();
		String line = productLines.get(random.nextInt(productLines.size()));

		String[] parts = line.split("\\s+");
		String upc = parts[0];
		String product = parts[1];
		String price = parts[2];

		System.out.println("Scanned-  UPC: " + upc + " product: " + product + " price: " + price);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}

	// Method to generate a random UPC from the available set
	public int generateRandomUPC(Set<Integer> upcs) {
        List<Integer> list = new ArrayList<>(upcs);
        int randomIndex = new Random().nextInt(list.size());
        int upc = list.get(randomIndex);
        System.out.println("Scanned UPC: " + upc);
        return upc;
    }

}


