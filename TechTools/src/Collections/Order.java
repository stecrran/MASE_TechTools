package Collections;

public class Order implements Comparable<Order> {

    public String symbol;
    public double amount;
    public String currency;
    public static int numberOfOrders;
    
    public Order(String symbol, double amount, String currency){
        this.symbol = symbol;
        this.amount = amount;
        this.currency = currency;
        numberOfOrders++;
    }

    public Order(){
    	this("undefined", 0.0, "USD");
        numberOfOrders++;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
	public int compareTo(Order o) {
		return Double.compare(this.getAmount(),o.getAmount());

	}


}

