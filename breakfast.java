// Breakfast Steak Solo - P60 (Steak + Egg + Rice)
class BreakfastSteak extends Parent {
    double steak = 35;
    double egg   = 15;
    double calculateTotalPrice(int quantity) {
        return (steak + egg + Rice) * quantity;
    }
}

// Longganisa Solo - P90 (Longganisa + Egg + Rice)
class Longganisa extends Parent {
    double longganisa = 60;
    double egg        = 20;
    double calculateTotalPrice(int quantity) {
        return (longganisa + egg + Rice) * quantity;
    }
}

// 2pc Pancake Solo - P48 (Pancake + Syrup)
class Pancake extends Parent {
    double pancake = 38;
    double syrup   = 10;
    double calculateTotalPrice(int quantity) {
        return (pancake + syrup) * quantity;
    }
}

// Beef Tapa Solo - P90 (Tapa + Egg + Rice)
class BeefTapa extends Parent {
    double tapa = 60;
    double egg  = 20;
    double calculateTotalPrice(int quantity) {
        return (tapa + egg + Rice) * quantity;
    }
}

// Corned Beef Solo - P90 (Corned Beef + Egg + Rice)
class CornedBeef extends Parent {
    double cornedBeef = 60;
    double egg        = 20;
    double calculateTotalPrice(int quantity) {
        return (cornedBeef + egg + Rice) * quantity;
    }
}