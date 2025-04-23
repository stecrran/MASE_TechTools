public class LimitOrder extends Order implements Transferable {

    public LimitOrder(String symbol, double amount, String currency) {
        super(symbol, amount, currency);
    }

    public LimitOrder() {}

    public boolean match(Order order) {
        System.out.println("in LimitOrder match");;
        return true;
    }

    @Override
    public void transfer(Broker targetExchange) {

    }
}
