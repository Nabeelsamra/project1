public class PurchaseManager extends User {
    public PurchaseManager(String username, String password) {
        super(username, password, "PurchaseManager");
    }

    // Additional attributes and methods specific to Purchase Managers
    public void generatePurchaseOrder(String prId) {
        // Implement logic to generate a purchase order based on PR
        System.out.println("Purchase order generated for PR: " + prId);
    }

    public void listPurchaseOrders() {
        // Implement logic to list purchase orders
        System.out.println("Listing purchase orders");
    }

    public void displayRequisition() {
        // Implement logic to display requisition (common with Sales Managers)
        System.out.println("Displaying purchase requisitions");
    }
}
