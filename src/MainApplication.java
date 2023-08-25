import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
public class MainApplication {
    private static  List<User> userList = new ArrayList<>(); // Store registered users
    private static  List<Item> itemList = new ArrayList<>(); // Store items

    private static User loggedInUser = null;


    public static void main(String[] args) {
        initializeUsers(); // Initialize users (you can load from a file)
        // Initialize items if needed

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the POM System");
            System.out.println("1. Login");
            System.out.println("2. Register User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    loginUser(scanner);
                    break;
                case 2:
                    registerUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeUsers() {
        // You can load users from a file or manually add initial users here
        userList.add(new SalesManager("salesmanager1", "password1"));
        userList.add(new PurchaseManager("purchasemanager1", "password2"));
        userList.add(new Administrator("admin", "adminpassword", itemList, userList));
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Optional<User> matchedUser = userList.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();

        if (matchedUser.isPresent()) {
            User user = matchedUser.get();
            System.out.println("Login successful. Welcome, " + user.getUserType() + " " + user.getUsername() + "!");

            loggedInUser = user; // Set the loggedInUser

            // Menu for item entry actions
            if (user instanceof ItemEntry) {
                ItemEntry itemEntryUser = (ItemEntry) user;
                System.out.println("Item Entry Menu:");
                System.out.println("1. Add Item");
                System.out.println("2. Edit Item");
                System.out.println("3. Delete Item");
                System.out.println("4. List Items");
                System.out.println("5. Supplier Entry");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int itemEntryChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (itemEntryChoice) {
                    case 1:
                        Item newItem = createNewItem(scanner);
                        itemList.add(newItem);
                        itemEntryUser.addItem(newItem);
                        System.out.println("Item added successfully.");
                        break;
                    case 2:
                        if (user instanceof Administrator) {
                            editItem(scanner, (Administrator) user); // Pass the admin user
                        } else {
                            System.out.println("You don't have permission to edit items.");
                        }
                        break;
                    case 3:
                        if (user instanceof Administrator) {
                            deleteItem(scanner, (Administrator) user); // Pass the admin user
                        } else {
                            System.out.println("You don't have permission to delete items.");
                        }
                        break;
                    case 4:

                        listItems(itemList);
                        break;
                    case 5:
                        System.out.println("Supplier Entry Menu:");
                        System.out.println("1. Add Supplier");
                        System.out.println("2. Edit Supplier");
                        System.out.println("3. Delete Supplier");
                        System.out.println("4. List Suppliers");
                        // ... other options ...

                        Administrator admin = (Administrator) loggedInUser;
                        int supplierEntryChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (supplierEntryChoice) {
                            case 1:
                                Supplier newSupplier = createNewSupplier(scanner);
                                admin.addSupplier(newSupplier); // Call the addSupplier method in Administrator
                                break;
                            case 2:
                                editSupplier(scanner, admin); // Call the editSupplier method in Administrator
                                break;
                            case 3:
                                deleteSupplier(scanner, admin); // Call the deleteSupplier method in Administrator
                                break;

                            case 4: // Add this case
                                listSuppliers(admin.getSupplierList());
                                break;
                            // ... handle other cases ...
                        }



                    case 6:

                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

            // Depending on the user's type, you can provide more menu options here
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }


    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String newUsername = scanner.nextLine();

        if (isUsernameTaken(newUsername)) {
            System.out.println("Username already taken. Registration failed.");
            return;
        }

        System.out.print("Enter password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Enter user type (SalesManager/PurchaseManager/Administrator): ");
        String newUserType = scanner.nextLine();

        User newUser = null;
        if ("SalesManager".equalsIgnoreCase(newUserType)) {
            newUser = new SalesManager(newUsername, newPassword);
        } else if ("PurchaseManager".equalsIgnoreCase(newUserType)) {
            newUser = new PurchaseManager(newUsername, newPassword);
        } else if ("Administrator".equalsIgnoreCase(newUserType)) {
            newUser = new Administrator(newUsername, newPassword);
        } else {
            System.out.println("Invalid user type. Registration failed.");
            return;
        }

        userList.add(newUser);
        System.out.println(newUserType + " registered successfully.");
        saveUserListToFile(); // Save the updated user list to a text file
    }

    private static void listItems(List<Item> itemList) {
        System.out.println("List of Items:");
        for (Item item : itemList) {
            System.out.println("Item Code: " + item.getItemCode());
            System.out.println("Item Name: " + item.getItemName());
            System.out.println("Supplier ID: " + item.getSupplierId());
            System.out.println("------------------------------");
        }
    }


    private static void editItem(Scanner scanner, Administrator admin) {
        System.out.print("Enter item code to edit: ");
        String itemCode = scanner.nextLine();

        // Check if the logged-in user is an administrator
        if (loggedInUser instanceof Administrator) {
            Administrator adminUser = (Administrator) loggedInUser;
            Item foundItem = findItemByCode(itemCode);
            if (foundItem != null) {
                System.out.print("Enter new item name: ");
                String newItemName = scanner.nextLine();

                System.out.print("Enter new supplier ID: ");
                String newSupplierId = scanner.nextLine();

                Item updatedItem = new Item(itemCode, newItemName, newSupplierId);
                adminUser.editItem(itemCode, updatedItem);
                adminUser.editItemInItemList(itemCode, updatedItem); // Update item in itemList
                System.out.println("Item edited successfully.");
            } else {
                System.out.println("Item not found for editing: " + itemCode);
            }
        }
    }

    private static void deleteItem(Scanner scanner, Administrator admin) {
        System.out.print("Enter item code to delete: ");
        String itemCode = scanner.nextLine();

        // Check if the logged-in user is an administrator
        if (loggedInUser instanceof Administrator) {
            Administrator adminUser = (Administrator) loggedInUser;
            Item foundItem = findItemByCode(itemCode);
            if (foundItem != null) {
                adminUser.deleteItem(itemCode);
                adminUser.deleteItemFromItemList(itemCode); // Delete item from itemList
                System.out.println("Item deleted successfully.");
            } else {
                System.out.println("Item not found for deletion: " + itemCode);
            }
        }
    }

    private static Item findItemByCode(String itemCode) {
        for (Item item : itemList) {
            if (item.getItemCode().equals(itemCode)) {
                return item;
            }
        }
        return null;
    }


    private static Supplier createNewSupplier(Scanner scanner) {
        System.out.print("Enter supplier ID: ");
        String supplierId = scanner.nextLine();

        System.out.print("Enter supplier name: ");
        String supplierName = scanner.nextLine();

        return new Supplier(supplierId, supplierName);
    }


    private static void editSupplier(Scanner scanner, Administrator admin) {
        System.out.print("Enter supplier ID to edit: ");
        String supplierId = scanner.nextLine();

        System.out.print("Enter new supplier name: ");
        String newSupplierName = scanner.nextLine();

        Supplier updatedSupplier = new Supplier(supplierId, newSupplierName);
        admin.editSupplier(supplierId, updatedSupplier); // Call the editSupplier method in Administrator
        System.out.println("Supplier edited successfully.");
    }

    private static void deleteSupplier(Scanner scanner, Administrator admin) {
        System.out.print("Enter supplier ID to delete: ");
        String supplierId = scanner.nextLine();

        admin.deleteSupplier(supplierId); // Call the deleteSupplier method in Administrator
        System.out.println("Supplier deleted successfully.");

    }




    private static void listSuppliers(List<Supplier> supplierList) {
        System.out.println("List of Suppliers:");
        for (Supplier supplier : supplierList) {
            System.out.println("Supplier ID: " + supplier.getSupplierId());
            System.out.println("Supplier Name: " + supplier.getSupplierName());
            System.out.println("------------------------------");
        }
    }

    private static boolean isUsernameTaken(String username) {
        return userList.stream().anyMatch(user -> user.getUsername().equals(username));
    }


    private static Item createNewItem(Scanner scanner) {
        System.out.print("Enter item code: ");
        String itemCode = scanner.nextLine();

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter supplier ID: ");
        String supplierId = scanner.nextLine();

        Item newItem = new Item(itemCode, itemName, supplierId);
        itemList.add(newItem);

        // Check if the logged-in user is authorized to perform item entry
        if (loggedInUser instanceof ItemEntry itemEntryUser) {
            if (itemEntryUser instanceof Administrator admin) {
                admin.addItemToItemList(newItem); // Call the addItemToItemList method of Administrator
            }
        }

        return newItem;
    }



    private static void saveUserListToFile() {
        // Implement file I/O to save userList to a text file
        // Be sure to catch any exceptions that might occur during file I/O
    }
}
