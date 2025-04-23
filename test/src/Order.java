public abstract class Order {

    public String symbol;
    public double amount;
    public String currency;
    public static int numberOfOrders;

    public Order(){
        this.symbol = "UNDEFINED";
        this.amount = 0.0;
        this.currency = "USD";
        numberOfOrders++;
    }

    public Order(String symbol, double amount, String currency) {
        this.symbol = symbol;
        this.amount = amount;
        this.currency = currency;
        numberOfOrders++;
    }

    public Order(String symbol) {
        this(symbol, 0.0, "USD");
        numberOfOrders++;
    }

    @Override
    public String toString() {
        return symbol + " " + amount + " " + currency;
    }

    abstract boolean match(Order order);
}

