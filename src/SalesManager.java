public class SalesManager extends User {
    public SalesManager(String username, String password) {
        super(username, password, "SalesManager");
    }

    // Additional attributes and methods specific to Sales Managers
    public void addItemEntry(String itemCode, String itemName, String supplierId) {
        // Implement logic to add item entry
        System.out.println("Item added: " + itemCode + " - " + itemName);
    }

    public void addSupplierEntry(String supplierCode, String supplierName, String itemId) {
        // Implement logic to add supplier entry
        System.out.println("Supplier added: " + supplierCode + " - " + supplierName);
    }

    public void addDailySalesEntry(String itemCode, double salesAmount) {
        // Implement logic to add daily sales entry
        System.out.println("Daily sales added for item: " + itemCode + ", Amount: " + salesAmount);
    }

    public void createPurchaseRequisition(String itemCode, int quantity, String requiredDate) {
        // Implement logic to create purchase requisition
        System.out.println("Purchase requisition created for item: " + itemCode + ", Quantity: " + quantity);
    }

    public void displayRequisition() {
        // Implement logic to display requisition
        System.out.println("Displaying purchase requisitions");
    }

    public void displayPurchaseOrders() {
        // Implement logic to display purchase orders
        System.out.println("Displaying purchase orders");
    }
}
