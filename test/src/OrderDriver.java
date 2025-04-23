public class OrderDriver {

    public static void main(String[] args) {
//        System.out.println("Number of orders: " + Order.numberOfOrders);
//        Order newOrder = new Order("XXP", 22.57, "Euro");
//        System.out.println(newOrder);
//
//        Order orderTwo = new Order("TWTR");
//        System.out.println(orderTwo);
//
//        Order orderThree = new Order();
//        System.out.println(orderThree);
//
//        System.out.println("Number of orders: " + Order.numberOfOrders);

        Order[] Orders = new Order[3];
        Orders[0] = new MarketOrder("XXP", 22.57, "Euro");
        Orders[1] = new MarketOrder("JJK", 11.73, "USD");

        for (Order order : Orders) {
            Orders[0].match(Orders[1]);
        }

        Orders[2] = new LimitOrder("GOP", 8888.88, "ISK");

        for (Order order : Orders) {
            if(order instanceof Transferable) {
                System.out.println(order);
            }
        }

    }
}

