// Jolly Crispy Fries Regular - P32
class JollyCrispyFries extends Parent {
    double calculateTotalPrice(int quantity) {
        return Fries * quantity;
    }
}

// Jolly Crispy Fries Large - P52
class JollyCrispyFriesLarge extends Parent {
    double largeFries = 52;
    double calculateTotalPrice(int quantity) {
        return largeFries * quantity;
    }
}

// Creamy Macaroni Soup Solo - P39
class MacaroniSoup extends Parent {
    double soup = 39;
    double calculateTotalPrice(int quantity) {
        return soup * quantity;
    }
}

// Peach Mango Pie 1pc - P27
class PeachMangoPie extends Parent {
    double pie = 27;
    double calculateTotalPrice(int quantity) {
        return pie * quantity;
    }
}