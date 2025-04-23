public class Deck {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
    }

    public Deck() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                System.out.println("Rank " + Rank.values()[j] + " of Suit " + Suit.values()[i]);;
            }
        }
    }
}
