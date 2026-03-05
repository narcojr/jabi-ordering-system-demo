// 1pc Burger Steak Solo - P50 (Patty + Rice)
class BurgerSteak1pc extends Parent {
    double burgerPatty = 40;
    double calculateTotalPrice(int quantity) {
        return (burgerPatty + Rice) * quantity;
    }
}

// 2pc Burger Steak Solo - P80 (2 Patty + Rice)
class BurgerSteak2pc extends Parent {
    double burgerPatty = 40;
    double calculateTotalPrice(int quantity) {
        return (burgerPatty + burgerPatty + Rice) * quantity;
    }
}

// Garlic Pepper Beef Solo - P50 (Beef + Garlic Sauce + Rice)
class GarlicPepperBeef extends Parent {
    double beefPatty   = 35;
    double garlicSauce = 15;
    double calculateTotalPrice(int quantity) {
        return (beefPatty + garlicSauce + Rice) * quantity;
    }
}

// Ultimate Burger Steak Solo - P125 (2 Patty + Rice + Gravy)
class UltimateBurgerSteak extends Parent {
    double burgerPatty = 40;
    double gravy       = 15;
    double extraRice   = 10;
    double calculateTotalPrice(int quantity) {
        return (burgerPatty + burgerPatty + Rice + gravy + extraRice) * quantity;
    }
}