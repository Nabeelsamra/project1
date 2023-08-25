# project1
POM_System
### Login Access

1. **Define User Classes:**
   - Create classes for Sales Manager, Purchase Manager, and Administrator.
   - Include attributes like username, password, and user type.

2. **User Registration:**
   - Implement a registration mechanism that allows Administrators to create user accounts.
   - Capture user details (username, password, user type).
   - Implement validation to ensure uniqueness of usernames and data integrity.

3. **Login Mechanism:**
   - Create a login screen where users can input their credentials.
   - Validate login credentials against registered users.
   - Grant appropriate access based on user type.

### User Registration

1. **Administrator User Interface:**
   - Implement a way for administrators to create user accounts.
   - Capture user details including identification number, user type, etc.
   - Validate input data to ensure data integrity.

2. **Uniqueness Check:**
   - Ensure that identification numbers are unique.
   - Prevent duplication of user details.

3. **Data Storage:**
   - Save registered user details to a text file.

### Item Entry

1. **Item Class:**
   - Define a class to represent items with attributes like item code, name, supplier ID, etc.

2. **Item Entry Interface:**
   - Create an interface for authorized users to add, edit, and delete items.
   - Validate item details before adding.

3. **Supplier Entry:**
   - Define a class for suppliers with attributes like supplier code, name, item ID supplied, etc.
   - Create an interface for authorized users to add, edit, and delete suppliers.

4. **Data Storage:**
   - Save added items and suppliers to separate text files.

### Daily Item-wise Sales Entry

1. **Item Stock Management:**
   - Implement a stock management system for items.
   - Update the stock based on daily sales entries.

2. **Sales Entry Interface:**
   - Create an interface for authorized users to input daily item-wise sales.
   - Validate input data and update item stock accordingly.

### Create a PR

1. **PR Class:**
   - Define a class to represent purchase requisitions (PR) with attributes like item code, quantity, required date, supplier code, etc.

2. **PR Creation Interface:**
   - Implement an interface for authorized users to create PRs.
   - Fetch supplier code based on the item code.
   - Generate a unique identifier for the PR.

3. **Data Storage:**
   - Save PR details to a text file.
   
### Display a PR

1. **PR Display Interface:**
   - Create an interface for authorized users to view all PRs raised by Sales Managers.
   - Read PR data from the text file and display it.

### Generate PO

1. **PO Class:**
   - Define a class to represent purchase orders (PO) with attributes similar to PR.

2. **PO Generation Interface:**
   - Create an interface for Purchase Managers to generate POs based on approved PRs.
   - Generate a unique identifier for each PO.

3. **Data Storage:**
   - Save generated PO details to a text file.

### List of Purchase Orders

1. **PO List Interface:**
   - Implement an interface for authorized users to view a report of POs raised by Purchase Managers.
   - Read PO data from the text file and display it.

Throughout the project, ensure proper error handling, input validation, and user-friendly interfaces. Test each functionality thoroughly as you implement it to ensure it's working correctly.

Remember that this is a comprehensive project, and it's important to break it down into smaller tasks, focus on one functionality at a time, and test as you go along. If you encounter any difficulties or have questions about specific implementation details, feel free to ask for assistance. Good luck with your project!

