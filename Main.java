import java.util.ArrayList;

// ================= USER =================
class User {
    String username;
    String password;
    String role;

    User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}


// ================= PRODUCT =================
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(
            "ID: " + id +
            " | Product: " + name +
            " | Price: ₹" + price
        );
    }
}


// ================= REGISTRATION =================
class Registration {

    ArrayList<User> users = new ArrayList<>();

    // Buyer Registration
    void registerBuyer(String username, String password) {
        users.add(new User(username, password, "Buyer"));
        System.out.println("Buyer registered successfully!");
    }

    // Seller Registration
    void registerSeller(String username, String password) {
        users.add(new User(username, password, "Seller"));
        System.out.println("Seller registered successfully!");
    }
}


// ================= LOGIN =================
class Login {

    Registration registration;

    Login(Registration registration) {
        this.registration = registration;
    }

    // Login
    String login(String username, String password) {

        // Admin already exists
        if (username.equals("admin") &&
            password.equals("admin123")) {

            return "Admin";
        }

        for (User user : registration.users) {

            if (user.username.equals(username) &&
                user.password.equals(password)) {

                return user.role;
            }
        }

        return "Invalid";
    }
}


// ================= SELLER MODULE =================
class SellerModule {

    ArrayList<Product> products = new ArrayList<>();

    // Add Product
    void addProduct(int id, String name, double price) {

        products.add(new Product(id, name, price));

        System.out.println("Product added successfully!");
    }

    // Edit Product
    void editProduct(int id, String name, double price) {

        for (Product p : products) {

            if (p.id == id) {

                p.name = name;
                p.price = price;

                System.out.println("Product edited successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // Delete Product
    void deleteProduct(int id) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).id == id) {

                products.remove(i);

                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // View Products
    void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        for (Product p : products) {
            p.display();
        }
    }
}