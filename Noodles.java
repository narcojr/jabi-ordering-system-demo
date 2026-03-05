// Jolly Spaghetti Solo - P50
class JollySpaghetti extends Parent {
    double calculateTotalPrice(int quantity) {
        return Spaghetti * quantity;
    }
}

// Jolly Spaghetti Value Meal - P105 (Spaghetti + Fries + Coke)
class JollySpaghettiValueMeal extends Parent {
    double calculateTotalPrice(int quantity) {
        return (Spaghetti + Fries + Coke) * quantity;
    }
}

// Palabok Solo - P85
class Palabok extends Parent {
    double palabok = 85;
    double calculateTotalPrice(int quantity) {
        return palabok * quantity;
    }
}

// Palabok Value Meal - P88 (Palabok + Drink)
class PalabokValueMeal extends Parent {
    double palabok = 85;
    double calculateTotalPrice(int quantity) {
        return (palabok + Coke) * quantity;
    }
}