import java.util.List;
import java.util.ArrayList;


public class Administrator extends User implements ItemEntry {

    List<Item> itemList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    // Constructor
    public Administrator(String username, String password, List<Item> itemList, List<User> userList) {
        super(username, password, "Administrator");
        this.itemList = itemList;
        this.userList = userList;
    }

    // Constructor without itemList and userList
    public Administrator(String username, String password) {
        super(username, password, "Administrator");
        this.itemList = null; // Or you can initialize it to an empty list
        this.userList = null; // Or you can initialize it to an empty list
    }

    // Setter methods for itemList and userList
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    // ItemEntry Interface methods
    public void addItem(Item newItem) {
        itemList.add(newItem); // Add the new item to the list
        System.out.println("Item added successfully.");
    }

    public void addItemToItemList(Item newItem) {
        itemList.add(newItem); // Add the new item to the list
        System.out.println("Item added successfully.");
    }

    @Override
    public void editItem(String itemCode, Item updatedItem) {
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.getItemCode().equals(itemCode)) {
                // Update the existing item with updated attributes
                item.setItemName(updatedItem.getItemName());
                item.setSupplierId(updatedItem.getSupplierId());
                System.out.println("Item edited successfully.");
                return;
            }
        }
        System.out.println("Item not found. Edit failed.");
    }

    @Override
    public void deleteItem(String itemCode) {
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.getItemCode().equals(itemCode)) {
                itemList.remove(i); // Remove the item from the list
                System.out.println("Item deleted successfully.");
                return;
            }
        }
        System.out.println("Item not found. Delete failed.");
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


    // Other methods and logic for Administrator
}

