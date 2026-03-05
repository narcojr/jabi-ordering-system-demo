
// Sundae (Chocolate or Strawberry) - P28
class Sundae extends Parent {
    double sundae = 28;
    double calculateTotalPrice(int quantity) {
        return sundae * quantity;
    }
}

// Vanilla Twirl - P13
class Twirl extends Parent {
    double twirl = 13;
    double calculateTotalPrice(int quantity) {
        return twirl * quantity;
    }
}

// Chocolate Twirl - P18
class ChocolateTwirl extends Parent {
    double twirl = 18;
    double calculateTotalPrice(int quantity) {
        return twirl * quantity;
    }
}

// Coke & Sarsi Float Regular - P27
class CokeFloat extends Parent {
    double floatDrink = 27;
    double calculateTotalPrice(int quantity) {
        return floatDrink * quantity;
    }
}

// Creamy Shake (Chocolate or Strawberry) - P42
class CreamyShake extends Parent {
    double shake = 42;
    double calculateTotalPrice(int quantity) {
        return shake * quantity;
    }
}

// Kit Kat Mix-ins - P42
class KitKatMixins extends Parent {
    double mixins = 42;
    double calculateTotalPrice(int quantity) {
        return mixins * quantity;
    }
}