public class Parent {

    // Shared base ingredients used across all child classes
    double Chicken   = 82;
    double Rice      = 10;
    double Coke      = 30;
    double Fries     = 25;
    double Spaghetti = 50;

    double price = Chicken + Rice + Coke;

    double calculateTotalPrice(int quantity) {
        return price * quantity;
    }
}