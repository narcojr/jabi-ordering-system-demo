// Kids Meal: Yum + Softdrink + Toy + free Vanilla Cone Twirl - P80
class KidsMealYum extends Parent {
    double yumPatty = 30;
    double toy      = 37;
    double calculateTotalPrice(int quantity) {
        return (yumPatty + Coke + toy) * quantity;
    }
}

// Kids Meal: Jolly Spaghetti + Softdrink + Toy + free Vanilla Cone Twirl - P83
class KidsMealSpaghetti extends Parent {
    double toy = 33;
    double calculateTotalPrice(int quantity) {
        return (Spaghetti + Coke + toy) * quantity;
    }
}

// Kids Meal: Chickenjoy + Softdrink + Toy + free Vanilla Cone Twirl - P100
class KidsMealChickenjoy extends Parent {
    double toy = 18;
    double calculateTotalPrice(int quantity) {
        return (Chicken + Coke + toy) * quantity;
    }
}