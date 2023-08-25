public interface ItemEntry {
    void addItem(Item newItem);
    void editItem(String itemCode, Item updatedItem);
    void deleteItem(String itemCode);
}
