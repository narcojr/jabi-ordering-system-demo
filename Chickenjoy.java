// 1pc Chickenjoy Solo - P82
class Chickenjoy1pc extends Parent {
    double calculateTotalPrice(int quantity) {
        return 82 * quantity;
    }
}

// 1pc Chickenjoy Value Meal - P122 (Chicken + Rice + Coke)
class Chickenjoy1pcValueMeal extends Parent {
    double calculateTotalPrice(int quantity) {
        return (Chicken + Rice + Coke) * quantity;
    }
}

// 2pc Chickenjoy Value Meal - P204 (2 Chicken + Rice + Coke)
class Chickenjoy2pcValueMeal extends Parent {
    double calculateTotalPrice(int quantity) {
        return (Chicken + Chicken + Rice + Coke) * quantity;
    }
}

// 1pc Chickenjoy with Spaghetti Solo - P132 (Chicken + Spaghetti)
class ChickenjoyWithSpaghetti extends Parent {
    double calculateTotalPrice(int quantity) {
        return (Chicken + Spaghetti) * quantity;
    }
}