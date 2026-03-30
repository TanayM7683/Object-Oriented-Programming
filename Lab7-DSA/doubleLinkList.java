package lab7;


class DNode {
    int data; //to store the value of the node
    DNode prev; // to point to the prevois node
    DNode next; //to point to the next node

    //Dnode Constructor
    DNode(int d) {
        data = d;
        //iinitially assigns no value and no connections
        prev = null;
        next = null;
    }
}


public class doubleLinkList {

    //head stores the first node
    static DNode head = null;

    //Insertion methods

    // Insert at beginning
    static void insertBegin(int data) {
        //create a new node
        DNode newNode = new DNode(data);

        //if list is empty the node becomes head
        if (head == null) {
            head = newNode;

        } else {
            newNode.next = head; //point forward to old head
            head.prev = newNode; //points back to new node
            head = newNode; //head updates
        }
    }

    // Insert at end
    static void insertEnd(int data) {
        DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
        } else {
            DNode temp = head; //used to traverse

            //move to the last node
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode; //forward to new node
            newNode.prev = temp; //backward to last node
        }
    }

    // Insert at position
    static void insertPos(int data, int pos) {
        DNode newNode = new DNode(data);

        //Use the insertBegin if pos of data is 1
        if (pos == 1) {
            insertBegin(data);
            return;
        }

        //traverse to position-1
        DNode temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        //set new node connections
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        //insert new node
        temp.next = newNode;
    }


    //Delete methods

    // Delete from beginning
    static void deleteBegin() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;

        //Used to prevent dangling pointer
        //delete backward link
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete from end
    static void deleteEnd() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        DNode temp = head;

        //Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null; //remove the last node
    }

    // Delete from position
    static void deletePos(int pos) {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (pos == 1) {
            deleteBegin();
            return;
        }

        DNode temp = head;

        // traverse to the target node
        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Display
    static void display() {
        DNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        insertBegin(10);
        insertBegin(5);
        //added 5<->10
        insertEnd(20);
        //5<-> 10 <-> 20
        insertPos(15, 3);
        //5<-> 10 <-> 15 <-> 20

        System.out.println("After insertion:");
        display();

        deleteBegin(); //removes 5
        deleteEnd(); // removes 20
        deletePos(2); //removes 15

        System.out.println("After deleting:");
        display(); //10 <-> null
    }
}
