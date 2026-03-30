package Lab2;

public class MainApp {

    public static void main(String[] args) {

        //creating 3 obj named m1, m2, m3 for Lab2.LibraryMember class
        LibraryMember m1 = new LibraryMember();
        LibraryMember m2 = new LibraryMember(201, "Rahul");
        LibraryMember m3 = new LibraryMember(202, "Sneha", 2);

       //Issue books to m1 and m2
        m1.issueBook(); //since given inputs of default constructor executed
        m2.issueBook();

        System.out.println();
        System.out.println("Display Details");
        m1.display();
        System.out.println();
        m2.display();
        System.out.println();
        m3.display();
        System.out.println();

        System.out.println("Object Statistics : ");
        LibraryMember.showStatistics();

        m1 = null;
        m2 = null;
        m3 = null;

        System.out.println("Requesting Garbage Collection...");
        System.gc();

        System.out.println("Program ends");
    }
}
