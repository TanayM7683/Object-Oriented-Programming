package lab7;
import java.util.ArrayList;

public class ArrayListOperation {
    public static void main (String[] args) {

        //create arraylist
        ArrayList <Integer> list = new ArrayList <>();

        //insert elements in arrayList
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.print("list after inserting values : ");
        System.out.println(list);

        //Delete Elements of aaraylist
        list.remove(2); //removes element at index 2 - 30
        System.out.println("List after delete : " + list );

        //Update Elenebts
        list.set(1,60); //replace value at index 1 with 60
        System.out.println("List after update : " + list );

        //Traverse List

        System.out.println("Traversingg");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
