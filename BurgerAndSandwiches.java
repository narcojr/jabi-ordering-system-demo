// Yum Solo - P30
class Yum extends Parent {
    double yumPatty = 30;
    double calculateTotalPrice(int quantity) {
        return yumPatty * quantity;
    }
}

// Yum Value Meal - P85 (Yum + Fries + Coke)
class YumValueMeal extends Parent {
    double yumPatty = 30;
    double calculateTotalPrice(int quantity) {
        return (yumPatty + Fries + Coke) * quantity;
    }
}

// Champ Solo - P128
class Champ extends Parent {
    double champPatty = 60;
    double bun        = 20;
    double toppings   = 48;
    double calculateTotalPrice(int quantity) {
        return (champPatty + bun + toppings) * quantity;
    }
}

// Champ Value Meal - P158 (Champ + Fries + Coke)
class ChampValueMeal extends Parent {
    double champPatty = 60;
    double bun        = 20;
    double toppings   = 48;
    double calculateTotalPrice(int quantity) {
        return (champPatty + bun + toppings + Fries + Coke) * quantity;
    }
}

// Jolly Hotdog Classic Solo - P50
class JollyHotdog extends Parent {
    double hotdog   = 25;
    double bun      = 10;
    double toppings = 15;
    double calculateTotalPrice(int quantity) {
        return (hotdog + bun + toppings) * quantity;
    }
}