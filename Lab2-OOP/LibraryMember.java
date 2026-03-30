package Lab2;

public class LibraryMember {

    // Private instance variables -- memberId, name, booksIssued
    private int memberId;
    private String name;
    private int booksIssued;

    // Private static variales totalCreated and activeObjects created to track objects
    private static int totalCreated =0;
    private static int activeObjects =0;

    //default constructor
    // Should call the full constructor using this()
    public LibraryMember() {
        this(0, "Anonymous", 0);
    }
    // Should accept memberId and name
    public LibraryMember(int memberId, String name) {
        this(memberId, name, 0);
    }

    // Validate memberId and booksIssued
    public LibraryMember(int memberId, String name, int booksIssued) {
        if (memberId < 0 ) {
            this.memberId = 0;
        } else {
            this.memberId = memberId;
        }

        if (name == null) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (booksIssued < 0) {
            this.booksIssued = 0;
        }else {
            this.booksIssued = booksIssued;
        }

        totalCreated++;
        activeObjects ++;
    }

    //method for issuing book
    public void issueBook() {
        booksIssued++;
        System.out.println("Book Issued by " + name);
    }

    //method for returning book
    public void returnBook() {
        if (booksIssued > 0) {
            booksIssued--;
            System.out.println("Book Returned by " + name);
        } else {
            System.out.println("No books in name of " + name);
        }
    }
    //method to display the details
    public void display() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Books Issued: " + booksIssued);
    }

    // This method is called by the JVM when the object is about to be garbage collected.
    // It is used here to simulate destructor behavior by reducing the count of active objects.
    @Override
    protected void finalize() throws Throwable {
        activeObjects --;
        System.out.println("Library Memeber Destroyed");
    }

    public static void showStatistics() {
        System.out.println("Total Object created - " + totalCreated);
        System.out.println("Active Objects - " + activeObjects);
        System.out.println();

    }
}
