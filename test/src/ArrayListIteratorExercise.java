import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListIteratorExercise {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Carol");
        names.add("Leon");

        for (String name : names) {
            System.out.println(name);
        }

        Iterator<String> iterator = names.iterator();
        System.out.println("Remove < 4:");
        while (iterator.hasNext()) {
            if(names.removeIf(name -> name.length() < 4)) {
                System.out.println(names);
            }
        }

        // another option
//        while (iterator.hasNext()) {
//            String currentName = iterator.next();
//            if (currentName.length() < 4) {
//                iterator.remove();
//            }
//        }

    }
}
