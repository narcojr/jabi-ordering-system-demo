import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame {

// ── Jollibee brand colors ──────────────────────────────
static final Color JB_RED    = new Color(206, 17,  38);
static final Color JB_DARK   = new Color(140,  5,  20);
static final Color JB_YELLOW = new Color(255, 204,  0);
static final Color JB_CREAM  = new Color(255, 248, 220);
static final Color JB_WHITE  = new Color(255, 255, 255);
static final Color JB_GREEN  = new Color(0,   130,  50);

// ── Data model ─────────────────────────────────────────
static class MenuItem {
    String name, emoji;
    Parent product;
    MenuItem(String name, Parent product, String emoji) {
        this.name = name; this.product = product; this.emoji = emoji;
    }
    double getPrice() { return product.calculateTotalPrice(1); }
}

static class CartEntry {
    MenuItem item;
    int quantity;
    CartEntry(MenuItem item, int qty) { this.item = item; this.quantity = qty; }
    double getTotal() { return item.product.calculateTotalPrice(quantity); }
}

// ── State ──────────────────────────────────────────────
java.util.List<CartEntry> cart      = new ArrayList<>();
DefaultListModel<String>  cartModel = new DefaultListModel<>();
JLabel totalLabel  = new JLabel("TOTAL:  P0.00");
JLabel statusLabel = new JLabel(" ");
JList<String> cartList;

// ── Menu data ──────────────────────────────────────────
static Map<String, java.util.List<MenuItem>> buildMenu() {
    Map<String, java.util.List<MenuItem>> m = new LinkedHashMap<>();
    m.put("Chickenjoy", Arrays.asList(
        new MenuItem("1pc Chickenjoy Solo",          new Chickenjoy1pc(),           "[CJ]"),
        new MenuItem("1pc Chickenjoy Value Meal",    new Chickenjoy1pcValueMeal(),  "[CJ]"),
        new MenuItem("2pc Chickenjoy Value Meal",    new Chickenjoy2pcValueMeal(),  "[CJ]"),
        new MenuItem("Chickenjoy w/ Spaghetti",      new ChickenjoyWithSpaghetti(), "[CJ]")
    ));
    m.put("Burgers & Sandwiches", Arrays.asList(
        new MenuItem("Yum Solo",                     new Yum(),           "[BG]"),
        new MenuItem("Yum Value Meal",               new YumValueMeal(),  "[BG]"),
        new MenuItem("Champ Solo",                   new Champ(),         "[BG]"),
        new MenuItem("Champ Value Meal",             new ChampValueMeal(),"[BG]"),
        new MenuItem("Jolly Hotdog Classic",         new JollyHotdog(),   "[HD]")
    ));
    m.put("Noodles", Arrays.asList(
        new MenuItem("Jolly Spaghetti Solo",         new JollySpaghetti(),          "[SP]"),
        new MenuItem("Jolly Spaghetti Value Meal",   new JollySpaghettiValueMeal(), "[SP]"),
        new MenuItem("Palabok Solo",                 new Palabok(),                 "[PB]"),
        new MenuItem("Palabok Value Meal",           new PalabokValueMeal(),        "[PB]")
    ));
    m.put("Rice Meals", Arrays.asList(
        new MenuItem("1pc Burger Steak Solo",        new BurgerSteak1pc(),      "[RS]"),
        new MenuItem("2pc Burger Steak Solo",        new BurgerSteak2pc(),      "[RS]"),
        new MenuItem("Garlic Pepper Beef",           new GarlicPepperBeef(),    "[RS]"),
        new MenuItem("Ultimate Burger Steak",        new UltimateBurgerSteak(), "[RS]")
    ));
    m.put("Breakfast", Arrays.asList(
        new MenuItem("Breakfast Steak Solo",         new BreakfastSteak(), "[BK]"),
        new MenuItem("Longganisa Solo",              new Longganisa(),     "[BK]"),
        new MenuItem("2pc Pancake Solo",             new Pancake(),        "[BK]"),
        new MenuItem("Beef Tapa Solo",               new BeefTapa(),       "[BK]"),
        new MenuItem("Corned Beef Solo",             new CornedBeef(),     "[BK]")
    ));
    m.put("Sides & Soup", Arrays.asList(
        new MenuItem("Crispy Fries Regular",         new JollyCrispyFries(),      "[FR]"),
        new MenuItem("Crispy Fries Large",           new JollyCrispyFriesLarge(), "[FR]"),
        new MenuItem("Creamy Macaroni Soup",         new MacaroniSoup(),          "[SP]"),
        new MenuItem("Peach Mango Pie",              new PeachMangoPie(),         "[DE]"),
        new MenuItem("Mashed Potato/Buttered Corn",  new SidesItem(),             "[SD]")
    ));
    m.put("Desserts & Floats", Arrays.asList(
        new MenuItem("Sundae Choco/Strawberry",      new Sundae(),       "[IC]"),
        new MenuItem("Vanilla Twirl",                new Twirl(),        "[IC]"),
        new MenuItem("Coke & Sarsi Float",           new CokeFloat(),    "[DR]"),
        new MenuItem("Creamy Shake",                 new CreamyShake(),  "[DR]"),
        new MenuItem("Kit Kat Mix-ins",              new KitKatMixins(), "[KK]")
    ));
    m.put("Kids Meal", Arrays.asList(
        new MenuItem("Kids Meal: Yum",               new KidsMealYum(),        "[KD]"),
        new MenuItem("Kids Meal: Spaghetti",         new KidsMealSpaghetti(),  "[KD]"),
        new MenuItem("Kids Meal: Chickenjoy",        new KidsMealChickenjoy(), "[KD]")
    ));
    return m;
}

// ── Constructor ────────────────────────────────────────
public Main() {
    setTitle("Jollibee Ordering System");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1150, 750);
    setMinimumSize(new Dimension(950, 620));
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(0, 0));

    add(buildHeader(),    BorderLayout.NORTH);
    add(buildMenuPanel(), BorderLayout.CENTER);
    add(buildCartPanel(), BorderLayout.EAST);
    add(buildStatusBar(), BorderLayout.SOUTH);
}

// ── Header ─────────────────────────────────────────────
JPanel buildHeader() {
    JPanel p = new JPanel(new BorderLayout());
    p.setBackground(JB_RED);
    p.setBorder(new EmptyBorder(14, 22, 14, 22));

    JLabel logo = new JLabel("** Jollibee");
    logo.setFont(new Font("Serif", Font.BOLD, 32));
    logo.setForeground(JB_YELLOW);

    JLabel sub = new JLabel("   Order your Jollibee favorites!");
    sub.setFont(new Font("SansSerif", Font.PLAIN, 13));
    sub.setForeground(new Color(255, 235, 200));

    JPanel left = new JPanel(new GridLayout(2, 1, 0, 2));
    left.setOpaque(false);
    left.add(logo);
    left.add(sub);
    p.add(left, BorderLayout.WEST);
    return p;
}

// ── Menu panel ─────────────────────────────────────────
JPanel buildMenuPanel() {
    JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
    tabs.setFont(new Font("SansSerif", Font.BOLD, 12));
    tabs.setBackground(JB_CREAM);

    Map<String, java.util.List<MenuItem>> menu = buildMenu();
    for (Map.Entry<String, java.util.List<MenuItem>> entry : menu.entrySet()) {
        tabs.addTab(entry.getKey(), buildCategoryPanel(entry.getValue()));
    }

    JPanel wrapper = new JPanel(new BorderLayout());
    wrapper.setBackground(JB_CREAM);
    wrapper.setBorder(new EmptyBorder(8, 8, 8, 4));
    wrapper.add(tabs);
    return wrapper;
}

JScrollPane buildCategoryPanel(java.util.List<MenuItem> items) {
    JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
    grid.setBackground(JB_CREAM);
    grid.setBorder(new EmptyBorder(12, 12, 12, 12));
    for (MenuItem item : items) grid.add(buildCard(item));

    JScrollPane sp = new JScrollPane(grid);
    sp.setBorder(null);
    sp.getVerticalScrollBar().setUnitIncrement(16);
    return sp;
}

// ── Item card — fixed button visibility ────────────────
JPanel buildCard(MenuItem item) {
    JPanel card = new JPanel(new BorderLayout(6, 8));
    card.setBackground(JB_WHITE);
    card.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(new Color(200, 170, 140), 1, true),
        new EmptyBorder(10, 14, 10, 14)
    ));

    // Name label
    JLabel nameLabel = new JLabel(item.emoji + "  " + item.name);
    nameLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
    nameLabel.setForeground(JB_DARK);

    // Price label — use "P" instead of peso unicode to avoid box
    JLabel priceLabel = new JLabel(String.format("P%.0f", item.getPrice()));
    priceLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
    priceLabel.setForeground(JB_RED);
    priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

    JPanel top = new JPanel(new BorderLayout(4, 0));
    top.setOpaque(false);
    top.add(nameLabel,  BorderLayout.CENTER);
    top.add(priceLabel, BorderLayout.EAST);

    // Qty spinner
    SpinnerNumberModel spinModel = new SpinnerNumberModel(1, 1, 99, 1);
    JSpinner spinner = new JSpinner(spinModel);
    spinner.setFont(new Font("SansSerif", Font.PLAIN, 13));
    spinner.setPreferredSize(new Dimension(65, 30));

    // ADD button — explicitly painted so it is always visible
    JButton addBtn = new JButton("Add +");
    addBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
    addBtn.setBackground(JB_RED);
    addBtn.setForeground(JB_WHITE);
    addBtn.setOpaque(true);
    addBtn.setContentAreaFilled(true);
    addBtn.setBorderPainted(true);
    addBtn.setFocusPainted(false);
    addBtn.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(JB_DARK, 1),
        new EmptyBorder(6, 14, 6, 14)
    ));
    addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    addBtn.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            addBtn.setBackground(JB_DARK);
            addBtn.repaint();
        }
        public void mouseExited(MouseEvent e) {
            addBtn.setBackground(JB_RED);
            addBtn.repaint();
        }
    });
    addBtn.addActionListener(e -> addToCart(item, (int) spinner.getValue()));

    JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
    bottom.setBackground(new Color(245, 238, 225));
    bottom.setBorder(new EmptyBorder(6, 0, 0, 0));

    JLabel qtyLbl = new JLabel("Qty:");
    qtyLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
    qtyLbl.setForeground(JB_DARK);

    bottom.add(qtyLbl);
    bottom.add(spinner);
    bottom.add(addBtn);

    card.add(top,    BorderLayout.NORTH);
    card.add(bottom, BorderLayout.SOUTH);
    return card;
}

// ── Cart panel — fixed button visibility ───────────────
JPanel buildCartPanel() {
    JPanel panel = new JPanel(new BorderLayout(0, 6));
    panel.setBackground(JB_DARK);
    panel.setPreferredSize(new Dimension(295, 0));
    panel.setBorder(new EmptyBorder(10, 8, 10, 8));

    // Title
    JLabel title = new JLabel("  Your Order", SwingConstants.CENTER);
    title.setFont(new Font("Serif", Font.BOLD, 18));
    title.setForeground(JB_YELLOW);
    title.setBorder(new EmptyBorder(4, 0, 8, 0));

    // Cart list
    cartList = new JList<>(cartModel);
    cartList.setFont(new Font("SansSerif", Font.PLAIN, 12));
    cartList.setBackground(new Color(80, 8, 18));
    cartList.setForeground(JB_WHITE);
    cartList.setSelectionBackground(JB_RED);
    cartList.setSelectionForeground(JB_YELLOW);
    cartList.setBorder(new EmptyBorder(6, 6, 6, 6));
    cartList.setFixedCellHeight(42);

    JScrollPane listScroll = new JScrollPane(cartList);
    listScroll.setBorder(new LineBorder(JB_YELLOW, 1));

    // Total label
    totalLabel.setFont(new Font("Serif", Font.BOLD, 16));
    totalLabel.setForeground(JB_YELLOW);
    totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
    totalLabel.setBorder(new EmptyBorder(8, 0, 8, 0));

    // Cart buttons — explicitly visible
    JButton removeBtn = makeCartBtn("Remove Selected", new Color(180, 30, 50));
    removeBtn.addActionListener(e -> {
        int idx = cartList.getSelectedIndex();
        if (idx >= 0) { cart.remove(idx); refreshCart(); }
        else flash("Select an item to remove first.");
    });

    JButton clearBtn = makeCartBtn("Clear All", new Color(100, 10, 20));
    clearBtn.addActionListener(e -> { cart.clear(); refreshCart(); });

    JButton orderBtn = makeCartBtn("PLACE ORDER", JB_GREEN);
    orderBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
    orderBtn.addActionListener(e -> placeOrder());

    JPanel btnPanel = new JPanel(new GridLayout(3, 1, 0, 6));
    btnPanel.setOpaque(false);
    btnPanel.setBorder(new EmptyBorder(4, 0, 0, 0));
    btnPanel.add(removeBtn);
    btnPanel.add(clearBtn);
    btnPanel.add(orderBtn);

    JPanel south = new JPanel(new BorderLayout(0, 4));
    south.setOpaque(false);
    south.add(totalLabel, BorderLayout.NORTH);
    south.add(btnPanel,   BorderLayout.SOUTH);

    panel.add(title,      BorderLayout.NORTH);
    panel.add(listScroll, BorderLayout.CENTER);
    panel.add(south,      BorderLayout.SOUTH);
    return panel;
}

// ── Cart button factory — always visible ───────────────
JButton makeCartBtn(String text, Color bg) {
    JButton b = new JButton(text);
    b.setFont(new Font("SansSerif", Font.BOLD, 12));
    b.setBackground(bg);
    b.setForeground(JB_WHITE);
    b.setOpaque(true);
    b.setContentAreaFilled(true);
    b.setBorderPainted(true);
    b.setFocusPainted(false);
    b.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(bg.darker(), 1),
        new EmptyBorder(9, 6, 9, 6)
    ));
    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b.addMouseListener(new MouseAdapter() {
        Color original = bg;
        public void mouseEntered(MouseEvent e) { b.setBackground(original.darker()); b.repaint(); }
        public void mouseExited(MouseEvent e)  { b.setBackground(original);          b.repaint(); }
    });
    return b;
}

// ── Status bar ─────────────────────────────────────────
JPanel buildStatusBar() {
    JPanel bar = new JPanel(new BorderLayout());
    bar.setBackground(JB_RED);
    bar.setBorder(new EmptyBorder(4, 14, 4, 14));

    statusLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
    statusLabel.setForeground(JB_WHITE);
    bar.add(statusLabel, BorderLayout.WEST);

    JLabel copy = new JLabel("Jollibee OOP System  |  Java Swing GUI");
    copy.setFont(new Font("SansSerif", Font.PLAIN, 11));
    copy.setForeground(new Color(255, 210, 210));
    bar.add(copy, BorderLayout.EAST);
    return bar;
}

// ── Cart logic ─────────────────────────────────────────
void addToCart(MenuItem item, int qty) {
    for (CartEntry e : cart) {
        if (e.item.name.equals(item.name)) {
            e.quantity += qty;
            refreshCart();
            flash("Added " + qty + "x " + item.name);
            return;
        }
    }
    cart.add(new CartEntry(item, qty));
    refreshCart();
    flash("Added " + qty + "x " + item.name);
}

void refreshCart() {
    cartModel.clear();
    double total = 0;
    for (CartEntry e : cart) {
        cartModel.addElement(String.format(
            "%s  %s  x%d  ->  P%.0f",
            e.item.emoji, e.item.name, e.quantity, e.getTotal()
        ));
        total += e.getTotal();
    }
    totalLabel.setText(String.format("TOTAL:  P%.2f", total));
}

void flash(String msg) {
    statusLabel.setText("  OK  " + msg);
    Timer t = new Timer(2500, e -> statusLabel.setText(" "));
    t.setRepeats(false);
    t.start();
}

// ── Place order receipt ────────────────────────────────
void placeOrder() {
    if (cart.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Your cart is empty!\nPlease add items first.",
            "Empty Cart", JOptionPane.WARNING_MESSAGE);
        return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("=========================================\n");
    sb.append("             JOLLIBEE\n");
    sb.append("           Order Receipt\n");
    sb.append("=========================================\n\n");
    double total = 0;
    for (CartEntry e : cart) {
        sb.append(String.format("  %-30s x%d%n", e.item.name, e.quantity));
        sb.append(String.format("  %32s P%.2f%n%n", "", e.getTotal()));
        total += e.getTotal();
    }
    sb.append("=========================================\n");
    sb.append(String.format("  GRAND TOTAL:%22s P%.2f%n", "", total));
    sb.append("=========================================\n\n");
    sb.append("   Thank you for choosing Jollibee!\n");
    sb.append("           Bee Happy!\n");

    JTextArea receipt = new JTextArea(sb.toString());
    receipt.setFont(new Font("Monospaced", Font.PLAIN, 13));
    receipt.setEditable(false);
    receipt.setBackground(JB_CREAM);
    receipt.setForeground(JB_DARK);
    receipt.setBorder(new EmptyBorder(12, 14, 12, 14));

    JScrollPane sp = new JScrollPane(receipt);
    sp.setPreferredSize(new Dimension(430, 370));

    JOptionPane.showMessageDialog(this, sp,
        "Order Confirmed!", JOptionPane.PLAIN_MESSAGE);

    cart.clear();
    refreshCart();
    flash("Order placed! Bee Happy!");
}

// ── Entry point ────────────────────────────────────────
public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception ignored) {}

    SwingUtilities.invokeLater(() -> new Main().setVisible(true));
}
}
