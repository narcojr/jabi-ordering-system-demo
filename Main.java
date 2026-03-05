public class Main {
    public static void main(String[] args) {

        
        // CHICKENJOY  

        System.out.println("========== CHICKENJOY ==========");

        Chickenjoy1pc c1 = new Chickenjoy1pc();
        System.out.println("1pc Chickenjoy Solo");
        System.out.println("Total price (1): " + c1.calculateTotalPrice(1));
        System.out.println();

        Chickenjoy1pcValueMeal c2 = new Chickenjoy1pcValueMeal();
        System.out.println("1pc Chickenjoy Value Meal");
        System.out.println("Total price (2): " + c2.calculateTotalPrice(2));
        System.out.println();

        Chickenjoy2pcValueMeal c3 = new Chickenjoy2pcValueMeal();
        System.out.println("2pc Chickenjoy Value Meal");
        System.out.println("Total price (3): " + c3.calculateTotalPrice(3));
        System.out.println();

        ChickenjoyWithSpaghetti c4 = new ChickenjoyWithSpaghetti();
        System.out.println("1pc Chickenjoy with Spaghetti Solo");
        System.out.println("Total price (2): " + c4.calculateTotalPrice(2));
        System.out.println();

        
        // BURGERS AND SANDWICHES  

        System.out.println("========== BURGERS AND SANDWICHES ==========");

        Yum y1 = new Yum();
        System.out.println("Yum Solo");
        System.out.println("Total price (3): " + y1.calculateTotalPrice(3));
        System.out.println();

        YumValueMeal y2 = new YumValueMeal();
        System.out.println("Yum Value Meal");
        System.out.println("Total price (2): " + y2.calculateTotalPrice(2));
        System.out.println();

        Champ ch1 = new Champ();
        System.out.println("Champ Solo");
        System.out.println("Total price (1): " + ch1.calculateTotalPrice(1));
        System.out.println();

        ChampValueMeal ch2 = new ChampValueMeal();
        System.out.println("Champ Value Meal");
        System.out.println("Total price (2): " + ch2.calculateTotalPrice(2));
        System.out.println();

        JollyHotdog jh = new JollyHotdog();
        System.out.println("Jolly Hotdog Classic Solo");
        System.out.println("Total price (4): " + jh.calculateTotalPrice(4));
        System.out.println();

    
        // NOODLES  
      
        System.out.println("========== NOODLES ==========");

        JollySpaghetti js1 = new JollySpaghetti();
        System.out.println("Jolly Spaghetti Solo");
        System.out.println("Total price (3): " + js1.calculateTotalPrice(3));
        System.out.println();

        JollySpaghettiValueMeal js2 = new JollySpaghettiValueMeal();
        System.out.println("Jolly Spaghetti Value Meal");
        System.out.println("Total price (2): " + js2.calculateTotalPrice(2));
        System.out.println();

        Palabok pb = new Palabok();
        System.out.println("Palabok Solo");
        System.out.println("Total price (2): " + pb.calculateTotalPrice(2));
        System.out.println();

        PalabokValueMeal pbvm = new PalabokValueMeal();
        System.out.println("Palabok Value Meal");
        System.out.println("Total price (2): " + pbvm.calculateTotalPrice(2));
        System.out.println();

        
        // RICE MEALS  
        
        System.out.println("========== RICE MEALS ==========");

        BurgerSteak1pc bs1 = new BurgerSteak1pc();
        System.out.println("1pc Burger Steak Solo");
        System.out.println("Total price (3): " + bs1.calculateTotalPrice(3));
        System.out.println();

        BurgerSteak2pc bs2 = new BurgerSteak2pc();
        System.out.println("2pc Burger Steak Solo");
        System.out.println("Total price (2): " + bs2.calculateTotalPrice(2));
        System.out.println();

        GarlicPepperBeef gpb = new GarlicPepperBeef();
        System.out.println("Garlic Pepper Beef Solo");
        System.out.println("Total price (2): " + gpb.calculateTotalPrice(2));
        System.out.println();

        UltimateBurgerSteak ubs = new UltimateBurgerSteak();
        System.out.println("Ultimate Burger Steak Solo");
        System.out.println("Total price (1): " + ubs.calculateTotalPrice(1));
        System.out.println();

        
        // BREAKFAST  
        
        System.out.println("========== BREAKFAST ==========");

        BreakfastSteak bks = new BreakfastSteak();
        System.out.println("Breakfast Steak Solo");
        System.out.println("Total price (2): " + bks.calculateTotalPrice(2));
        System.out.println();

        Longganisa lng = new Longganisa();
        System.out.println("Longganisa Solo");
        System.out.println("Total price (2): " + lng.calculateTotalPrice(2));
        System.out.println();

        Pancake pnk = new Pancake();
        System.out.println("2pc Pancake Solo");
        System.out.println("Total price (3): " + pnk.calculateTotalPrice(3));
        System.out.println();

        BeefTapa bt = new BeefTapa();
        System.out.println("Beef Tapa Solo");
        System.out.println("Total price (2): " + bt.calculateTotalPrice(2));
        System.out.println();

        CornedBeef cb = new CornedBeef();
        System.out.println("Corned Beef Solo");
        System.out.println("Total price (2): " + cb.calculateTotalPrice(2));
        System.out.println();

       
        // SIDES AND SOUP 
        
        System.out.println("========== SIDES AND SOUP ==========");

        JollyCrispyFries jcf = new JollyCrispyFries();
        System.out.println("Jolly Crispy Fries Regular");
        System.out.println("Total price (2): " + jcf.calculateTotalPrice(2));
        System.out.println();

        JollyCrispyFriesLarge jcfl = new JollyCrispyFriesLarge();
        System.out.println("Jolly Crispy Fries Large");
        System.out.println("Total price (2): " + jcfl.calculateTotalPrice(2));
        System.out.println();

        MacaroniSoup ms = new MacaroniSoup();
        System.out.println("Creamy Macaroni Soup Solo");
        System.out.println("Total price (2): " + ms.calculateTotalPrice(2));
        System.out.println();

        PeachMangoPie pmp = new PeachMangoPie();
        System.out.println("Peach Mango Pie");
        System.out.println("Total price (3): " + pmp.calculateTotalPrice(3));
        System.out.println();

        SidesItem sd = new SidesItem();
        System.out.println("Sides (Mashed Potato / Buttered Corn)");
        System.out.println("Total price (2): " + sd.calculateTotalPrice(2));
        System.out.println();

        // DESSERTS AND FLOATS
        
        System.out.println("========== DESSERTS AND FLOATS ==========");

        Sundae snd = new Sundae();
        System.out.println("Sundae (Chocolate/Strawberry)");
        System.out.println("Total price (2): " + snd.calculateTotalPrice(2));
        System.out.println();

        Twirl twrl = new Twirl();
        System.out.println("Vanilla Twirl");
        System.out.println("Total price (4): " + twrl.calculateTotalPrice(4));
        System.out.println();

        CokeFloat cf = new CokeFloat();
        System.out.println("Coke & Sarsi Float Regular");
        System.out.println("Total price (2): " + cf.calculateTotalPrice(2));
        System.out.println();

        CreamyShake cs = new CreamyShake();
        System.out.println("Creamy Shake");
        System.out.println("Total price (2): " + cs.calculateTotalPrice(2));
        System.out.println();

        KitKatMixins kkm = new KitKatMixins();
        System.out.println("Kit Kat Mix-ins");
        System.out.println("Total price (2): " + kkm.calculateTotalPrice(2));
        System.out.println();

        // =============================================
        // KIDS MEAL  |  file: KidsMeal.java
        // =============================================
        System.out.println("========== JOLLIBEE KIDS MEAL ==========");

        KidsMealYum km1 = new KidsMealYum();
        System.out.println("Kids Meal: Yum + Softdrink + Toy + Twirl");
        System.out.println("Total price (1): " + km1.calculateTotalPrice(1));
        System.out.println();

        KidsMealSpaghetti km2 = new KidsMealSpaghetti();
        System.out.println("Kids Meal: Spaghetti + Softdrink + Toy + Twirl");
        System.out.println("Total price (2): " + km2.calculateTotalPrice(2));
        System.out.println();

        KidsMealChickenjoy km3 = new KidsMealChickenjoy();
        System.out.println("Kids Meal: Chickenjoy + Softdrink + Toy + Twirl");
        System.out.println("Total price (1): " + km3.calculateTotalPrice(1));
        System.out.println();
    }
}