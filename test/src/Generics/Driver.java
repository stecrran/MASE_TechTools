package Generics;

public class Driver {

    public static void main(String[] args) {
        MyArrayList newArrayList = new MyArrayList<>();

        newArrayList.addItem(1);
        newArrayList.addItem("two");
        newArrayList.addItem("three");
        newArrayList.addItem("four");
        newArrayList.addItem("five");

        newArrayList.removeItem(2);
        System.out.println(newArrayList.getItem(2));

        for (Object value : newArrayList){
            System.out.println(value);
        }
    }
}
