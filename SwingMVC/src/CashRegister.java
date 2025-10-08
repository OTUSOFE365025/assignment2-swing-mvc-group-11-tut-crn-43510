import java.io.*;
import java.util.*;


public class CashRegister {
    private Map<Integer, Product> productMap = new HashMap<>();
    private List<Product> scannedItems = new ArrayList<>();

    // Inner class to represent a product
    public CashRegister(String filename) {
        loadProducts(filename);
    }

    // Load products from the given file
    private void loadProducts(String filename) {
        // Load products from a txt file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();

            String line;
            // Read each line of the file
            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 3) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }
                // Parse the product information
                String upcStr = parts[0];
                int upc = Integer.parseInt(upcStr);

                String name = parts[1];

                String priceString = parts[2].trim();
                if (priceString.startsWith("$")) {
                    priceString = priceString.substring(1);
                }
                double price = Double.parseDouble(priceString);

                productMap.put(upc, new Product(upc, name, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add an item to the scanned items list
    public void addItem(int upc) {
        Product product = productMap.get(upc);
        if (product != null) {
            scannedItems.add(product);
        }
    }

    // Get the list of scanned items
    public List<Product> getScannedItems() {
        return scannedItems;
    }

    // Calculate the subtotal of scanned items
    public double getSubtotal() {
        double subtotal = 0.0;
        for (Product item : scannedItems) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    // Get the set of available UPCs
    public Set<Integer> getAvailableUPCs() {
        return productMap.keySet();
    }
}