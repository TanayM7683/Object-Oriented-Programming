package lab7;

    class Node {
        int data; //stores the value of the node
        Node next; //stroes the reference value of the node

        //node constructor
        public Node(int data) {
            this.data = data;
            next = null; //initially does not point to any other node

        }
    }

    public class SingleLinkList {

        static Node head; // head stores the first node

        //to be inserted at the beginning
        static void insertBegin(int data) {
            //create a node
            Node newNode = new Node(data);

            //if head == null the list is empty
            if (head == null) {
                head = newNode;
            }else {
                //new node points to the old head, head moves to new node
                newNode.next = head;
                head = newNode;
            }
        }

        //insert at end
        static void insertEnd(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            }else  {
                //creat a temp pointer for traversal
                Node temp = head;

                //move to last node
                while (temp.next != null) {
                    temp = temp.next;
                }
                //attach new node at the end
                temp.next = newNode;
            }
        }

            //insert from position 1
        static void insertPos(int data, int pos ) {
            Node newNode = new Node(data);

            //if the pos is 1 then use the insertbegin method
            if (pos == 1) {
                insertBegin(data);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos-1; i++) {
                if(temp == null) {
                    System.out.println("Invalid Input");
                    return;
                }
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        //Delete  Operations


        //Delete from begginning
        static void deleteBeginning() {
            if (head == null) {
                System.out.println("List empty");
            } else {
                //move head to next node
                //first node gets removed
                head = head.next;
            }
        }



        //delete from end
        static  void DeleteEnd(){

            if (head == null) {
                System.out.println("The list is empty");

                //only 1 node delete it
            }else if (head.next == null) {
                head = null;
            }else {

                //temp used to traverse to the second last node
                Node temp = head;

                while (temp.next.next != null) {
                    temp = temp.next;
                }

                temp.next = null; // remove last node
            }
        }



        //delete from position
        static  void DeletePos(int pos){
            if (head == null) {
                System.out.println("The list is empty");
                return;
            }

            //delete the first node
            if (pos == 1 ) {
                head = head.next;
                return;
            }
             Node temp = head;

            //inorder to move to node before the position
            for (int i = 1; i < pos-1; i++) {
                if (temp.next == null) {
                    System.out.println("Invalid");
                    return;
                }
                temp= temp.next;
            }

            if (temp.next == null) {//condiotn for no node to delete
                System.out.println("The list is empty");
                return;
            }
            //skips the node and removes it
            temp.next = temp.next.next;

        }

        //display method

        static void display (){
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data  + " -> ");
                temp = temp.next;
            }
            System.out.println("Null ");

        }


        public static void main(String[] args) {
            insertBegin(10);
            insertBegin(5);
            insertEnd(20);
            insertPos(15, 3);

            System.out.println("After insertion");
            display();

            deleteBeginning();
            DeleteEnd();
            DeletePos(2);

            System.out.println("After deletion");
            display();
        }
    }