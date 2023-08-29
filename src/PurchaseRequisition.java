
import java.time.LocalDate;



public class PurchaseRequisition {
    private String prId;
    private String itemCode;
    private int quantity;
    private LocalDate requiredDate;
    private String supplierId;
    private String smName;

    public PurchaseRequisition(String prId, String itemCode, int quantity, LocalDate requiredDate, String supplierCode, String smName) {
        this.prId = prId;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.requiredDate = requiredDate;
        this.supplierId = supplierCode;
        this.smName = smName;
    }

    // Add getters for the fields
    // You can also add other methods as needed
}
