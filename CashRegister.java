import java.io.*;
import java.util.*;

public class CashRegister {
    private Map<Integer, Product> productMap = new HashMap<>();
    private List<Product> scannedItems = new ArrayList<>();

    public CashRegister(String filename) {
        loadProducts(filename);
    }

    private void loadProducts(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 3) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }
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

    public void addItem(int upc) {
        Product product = productMap.get(upc);
        if (product != null) {
            scannedItems.add(product);
        }
    }

    public List<Product> getScannedItems() {
        return scannedItems;
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (Product item : scannedItems) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public Set<Integer> getAvailableUPCs() {
        return productMap.keySet();
    }
}