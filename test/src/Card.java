public class Card {

    public Card(Suit suit, Rank rank){

    }

    @Override
    public String toString(){
        return "Suit: " + Suit.values() + "Rank: " + Rank.values() + "\n";
    }

}
