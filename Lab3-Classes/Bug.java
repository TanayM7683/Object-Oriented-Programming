package Lab3;

public class Bug {

    // Instance variables
    private int position;
    private boolean movingRight;

    // Constructor
    public Bug(int initialPosition) {
        this.position = initialPosition; // this refer to the current obj
        //since it initially moves to the right hence true
        movingRight = true;
    }

    // Changes the direction of the bug
    public void turn() {
        movingRight = !movingRight;
    }

    // Moves the bug one unit in the current direction
    public void move() {
        if(movingRight) {
            position++;
        }else  {
            position--;
        }
    }

    // Returns the current position
    public int getPosition() {
        return position;
    }

    // Main method for testing
    public static void main(String[] args) {

        //create an object of the class Bug
        Bug bugsy = new Bug(10);
        bugsy.move();

        System.out.println("Current position : " + bugsy.getPosition());
        System.out.println("Expected position is 11");
        bugsy.turn();
        bugsy.move();
        System.out.println();
        System.out.println("Current position : " + bugsy.getPosition());
        System.out.println("Expected position is 10");


    }
}

