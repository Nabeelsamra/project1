public class UserFactory {
    public static User createUser(String userType, String username, String password) {
        if ("SalesManager".equalsIgnoreCase(userType)) {
            return new SalesManager(username, password);
        } else if ("PurchaseManager".equalsIgnoreCase(userType)) {
            return new PurchaseManager(username, password);
        } else if ("Administrator".equalsIgnoreCase(userType)) {
            return new Administrator(username, password);
        } else {
            throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
