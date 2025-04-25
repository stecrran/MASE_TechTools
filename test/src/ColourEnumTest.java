public class ColourEnumTest {

    public static void main(String[] args) {
        for(Colours colour : Colours.values()) {
            System.out.print(colour.ordinal());
        }
    }
}
