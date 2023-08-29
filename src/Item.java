public class Item {
    private String itemCode;
    private String itemName;
    private String supplierId;
    private double totalSales;



    public Item(String itemCode, String itemName, String supplierId) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.supplierId = supplierId;
        this.totalSales = 0.0; // Initialize totalSales to 0.0

    }

    public double getTotalSales() {
        return totalSales;
    }

    public void updateTotalSales(double amountSold) {
        totalSales += amountSold;
    }

    // Getters and setters for item attributes
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }



    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }

    // Additional methods and logic related to items
}
