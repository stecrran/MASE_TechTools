package domain;

public class MarketOrder extends Order {

    @Override
    public boolean match(Order order) {
        System.out.println("domain.MarketOrder match");
        return false;
    }


    public MarketOrder(Currency currency, double amount, Side side) {
        super(currency, amount, side);
    }


}
