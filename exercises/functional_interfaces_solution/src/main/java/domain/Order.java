package domain;


public abstract class Order {
    private Currency currency;
    private double amount;
    private Side side;

    public Order(Currency currency, double amount, Side side) {
        this.currency = currency;
        this.amount = amount;
        this.side = side;
    }

    public abstract boolean match(Order order);

    @Override
    public String toString() {
        return "Order{" +
                "currency=" + currency +
                ", amount=" + amount +
                ", side=" + side +
                '}';
    }

    public Currency getCurrency() {
        return currency;
    }


    public double getAmount() {
        return amount;
    }

    public Side getSide() {
        return side;
    }
}
