import java.util.ArrayList;
import java.util.List;

public class SalesManager extends Administrator implements ItemEntry {
    List<Item> itemList = new ArrayList<>();
    List<User> userList = new ArrayList<>();

    private List<Supplier> supplierList = new ArrayList<>();
    // Constructor
    public SalesManager(String username, String password, List<Item> itemList, List<User> userList) {
        super(username, password, itemList, userList);
    }




    // Setter methods for itemList and userList
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    // ItemEntry Interface methods

    // Implement the methods from ItemEntry interface
    @Override
    public void addItem(Item newItem) {
        addItemToItemList(newItem);
    }

    @Override
    public void editItem(String itemCode, Item updatedItem) {
        editItemInItemList(itemCode, updatedItem);
    }

    @Override
    public void deleteItem(String itemCode) {
        deleteItemFromItemList(itemCode);
    }


    public void deleteItemFromItemList(String itemCode) {
        Item itemToDelete = null;
        for (Item item : itemList) {
            if (item.getItemCode().equals(itemCode)) {
                itemToDelete = item;
                break;
            }
        }

        if (itemToDelete != null) {
            itemList.remove(itemToDelete);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found for deletion: " + itemCode);
        }
    }

    public void editItemInItemList(String itemCode, Item updatedItem) {
        Item itemToEdit = null;
        for (Item item : itemList) {
            if (item.getItemCode().equals(itemCode)) {
                itemToEdit = item;
                break;
            }
        }

        if (itemToEdit != null) {
            itemToEdit.setItemName(updatedItem.getItemName());
            itemToEdit.setSupplierId(updatedItem.getSupplierId());
            System.out.println("Item edited successfully.");
        } else {
            System.out.println("Item not found for editing: " + itemCode);
        }
    }

    public void addSupplier(Supplier newSupplier) {
        supplierList.add(newSupplier);
        System.out.println("Supplier added successfully.");
    }

    public void editSupplier(String supplierId, Supplier updatedSupplier) {
        Supplier foundSupplier = findSupplierById(supplierId);
        if (foundSupplier != null) {
            // Update the existing supplier with updated attributes
            foundSupplier.setSupplierName(updatedSupplier.getSupplierName());
            System.out.println("Supplier edited successfully.");
        } else {
            System.out.println("Supplier not found. Edit failed.");
        }
    }

    public void deleteSupplier(String supplierId) {
        Supplier foundSupplier = findSupplierById(supplierId);
        if (foundSupplier != null) {
            supplierList.remove(foundSupplier);
            System.out.println("Supplier deleted successfully.");
        } else {
            System.out.println("Supplier not found. Delete failed.");
        }
    }

    // Helper method to find a supplier by ID
    private Supplier findSupplierById(String supplierId) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierId().equals(supplierId)) {
                return supplier;
            }
        }
        return null;
    }

    public void recordDailySales(String itemCode, double amountSold) {
        Item item = findItemByCode(itemCode);
        if (item != null) {
            item.updateTotalSales(amountSold);
            System.out.println("Daily sales recorded for item: " + item.getItemName());
        } else {
            System.out.println("Item not found for recording daily sales: " + itemCode);
        }
    }


    private Item findItemByCode(String itemCode) {
        for (Item item : itemList) {
            if (item.getItemCode().equals(itemCode)) {
                return item;
            }
        }
        return null;
    }


    public String getSupplierCodeForItem(String itemCode) {
        Item item = findItemByCode(itemCode);
        if (item != null) {
            Supplier supplier = findSupplierById(item.getSupplierId());
            if (supplier != null) {
                return supplier.getSupplierId();
            }
        }
        return null; // Return null if item or supplier not found
    }



    public List<Supplier> getSupplierList() {
        return supplierList;
    }

}
