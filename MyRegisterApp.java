
public class MyRegisterApp {
    public static void main(String[] args) {
        String filePath = "products.txt";
        CashRegister model = new CashRegister(filePath);
        Display view = new Display();
        Scanner scanner = new Scanner();
        new Controller(model, view, scanner);
    }
}
