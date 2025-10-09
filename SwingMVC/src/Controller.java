
import javax.swing.JOptionPane;
 
public class Controller {
	 private Model model;
	 private View view;
	 private CashRegister cashRegister;
	 private Scanner scanner;
	 private Display display;
	 
	 public Controller(Model m, View v) {
	  model = m;
	  view = v;
	  initView();
	 }

	 // New constructor for CashRegister, Display, and Scanner
	public Controller(CashRegister cash, Display v, Scanner scanner) {
	  this.cashRegister = cash;
	  this.display = v;
	  this.scanner = scanner;
	  
      scanner.getScanButton().addActionListener(e -> handleScan());
	 }
	 
	 public void initView() {
	  view.getFirstnameTextfield().setText(model.getFirstname());
	  view.getLastnameTextfield().setText(model.getLastname());
	 }
	 
	 public void initController() {
	  view.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
	  view.getLastnameSaveButton().addActionListener(e -> saveLastname());
	  view.getHello().addActionListener(e -> sayHello());
	  view.getBye().addActionListener(e -> sayBye());
	 }
	 
	 private void saveFirstname() {
	  model.setFirstname(view.getFirstnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void saveLastname() {
	  model.setLastname(view.getLastnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayHello() {
	  JOptionPane.showMessageDialog(null, "Hello " + model.getFirstname() + " " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayBye() {
	  System.exit(0);
	 }

	 private void handleScan() {
		// Generate a random UPC and add the corresponding item to the cash register
        int upc = scanner.generateRandomUPC(cashRegister.getAvailableUPCs());
        cashRegister.addItem(upc);
		// Update the display with the scanned items and subtotal
        display.updateDisplay(cashRegister.getScannedItems(), cashRegister.getSubtotal());
    }

	 
}

