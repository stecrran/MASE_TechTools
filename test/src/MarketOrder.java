public class MarketOrder extends Order {

    public MarketOrder(String symbol, double amount, String currency) {
        super(symbol, amount, currency);
    }

    public MarketOrder() {}

    public boolean match(Order order) {
        System.out.println("in MarketOrder match");;
        return true;
    }
}
