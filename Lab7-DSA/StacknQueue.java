package lab7;

public class StacknQueue {

    //stack --
    //create an array to store stack elements
    static int stack[] = new int [5];
    static int top = -1; // initialize to empty

    //push opearations
    static void push(int x) {
        //check if stack is full
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow");

        } else {
            //move pointer to next positions and insert the new element
            stack[++top] = x;
        }
    }

    //pop operation
    static void pop() {
        if (top == -1) {
            //checks if stack is empty
            System.out.println("Invalid Stack Underflow");
        } else {
            //prints the top element
            System.out.println("Popped: " + stack[top]);
            top--; //decrease top to remove it
        }
    }

    //Peek operation
    static void peek () {

        if (top == -1) {
            System.out.println("Invalid Stack empty");
        } else {
            //display the current top element
            System.out.println("Top element: " + stack[top]);
        }
    }

    //Queue Implementation

    static int queue[]=new int [5];
    static int front =0; //points to first element
    static int rear = -1 ; //points to least inserted element


    //enqueue operation
    static void enqueue(int x) {
        //check if queue is full
        if (front == queue.length - 1) {
            System.out.println("Queue Full");
        }else {
            //moves rear forward
            rear ++;
            queue[rear] = x; //inserts new element at rear
        }
    }

    //Dequeue Operation
    static void dequeue() {
        if(front > rear ){
            System.out.println("Queue Full");
        }else {
            System.out.println("Dequeued: " + queue[front]);
            front ++;
        }
    }

    //Front operation
    static void front() {
        if (front > rear) {
            System.out.println("Queue Empty");
        }else {
            //displays the first element of the que
            System.out.println("Front Element: " + queue[front]);
        }
    }


    //main method
    public static void main() {
        System.out.println("Stack operations");
        push(10);
        push(20);
        push(30);
        peek();
        pop();
        peek();

        System.out.println(" ");
        System.out.println("Queue operations");
        enqueue(1);
        enqueue(2);
        enqueue(3);
        front();
        dequeue();
        front();
    }
}
