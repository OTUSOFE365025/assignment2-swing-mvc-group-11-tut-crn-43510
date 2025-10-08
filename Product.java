public class Product {
    private int upc;
    private String name;
    private double price;

    public Product(int upc, String name, double price) {
        this.upc = upc;
        this.name = name;
        this.price = price;
    }

    public int getUpc() { 
        return upc; 
    }
    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }

    @Override
    public String toString() {
        if (name.contains("_")) {
            name = name.replace("_", " ");
        }
        return upc + "\t" + name + "\t$" + String.format("%.2f", price);
    }
}
