import java.util.List;
import java.util.ArrayList;


public class UserFactory {
    public static User createUser(String userType, String username, String password, List<Item> itemList, List<User> userList) {
        if ("SalesManager".equalsIgnoreCase(userType)) {
            return new SalesManager(username, password, itemList, userList);
        } else if ("PurchaseManager".equalsIgnoreCase(userType)) {
            return new PurchaseManager(username, password);
        } else if ("Administrator".equalsIgnoreCase(userType)) {
            return new Administrator(username, password, itemList, userList);
        } else {
            throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}

