package Lab3;
public class ComboLock {

    // Instance variables
    private int secret1;
    private int secret2;
    private int secret3;

    private int currentPosition;
    private int step;   // tracks progress in the combination sequence

    // Constructor
    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        reset();
    }

    // Resets the dial to 0 and clears any progress
    public void reset() {
        currentPosition = 0;
        step = 0;
        }

    // Turns the dial left by the given number of ticks
    public void turnLeft(int ticks) {

        currentPosition  = (currentPosition - ticks + 40) % 40;
        //+40 is added cause without that the current position could have been negative
        //and if negative its % would have been invalid

        //if any differences are noticed it resets the code with step = 0
        if (step ==1 && currentPosition >= secret2) {
            step++;
        }else {
            step = 0;
        }
    }

    // Turns the dial right by the given number of ticks
    public void turnRight(int ticks) {

        currentPosition  = (currentPosition + ticks) % 40;

        if (step == 0 && currentPosition == secret1) {
            step++;
        }else if (step == 2 && currentPosition == secret3) {
            step = 3;
        }else {
            step = 0;
        }
    }

    // Attempts to open the lock
    // The lock will open if all steps are completed in order
    public boolean open() {
        return step == 3;
    }

    // Main method for testing
    public static void main(String[] args) {

        ComboLock lock = new ComboLock(10, 20, 30);

        lock.reset();
        lock.turnRight(10); //current Position = (0 + 10) % 40 = 10
        lock.turnLeft(30); //current Position = (10 - 30 + 40) % 40 = 20
        lock.turnRight(10); //current position = (0 +10) % 40 = 10

        System.out.println("Lock opened: " + lock.open()); //since step = 3 it returns true
        System.out.println("Expected: true");

        lock.reset();
        lock.turnRight(5); // since the first step does not match the step remains 0
        lock.turnLeft(20);
        lock.turnRight(10);
        // since the step = 0 the subsequent order don't matter cause the order was broken

        System.out.println("Lock opened: " + lock.open());
        System.out.println("Expected: false");
    }
}
