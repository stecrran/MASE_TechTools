package Collections;

import java.util.Comparator;

public class Order implements Comparator<Order> {

    public String symbol;
    public int amount;
    public String currency;
    public static int numberOfOrders;

    public Order(){
        this.symbol = "UNDEFINED";
        this.amount = 0;
        this.currency = "USD";
        numberOfOrders++;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static int getNumberOfOrders() {
        return numberOfOrders;
    }

    public static void setNumberOfOrders(int numberOfOrders) {
        Order.numberOfOrders = numberOfOrders;
    }

    public Order(String symbol, int amount, String currency) {
        this.symbol = symbol;
        this.amount = amount;
        this.currency = currency;
        numberOfOrders++;
    }

    public Order(String symbol) {
        this(symbol, 0, "USD");
        numberOfOrders++;
    }

    @Override
    public String toString() {
        return symbol + " " + amount + " " + currency;
    }


    @Override
    public int compare(Order o1, Order o2) {
        return o2.getAmount().compareTo(o2.getAmount());
    }


}

