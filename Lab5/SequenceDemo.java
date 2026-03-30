package Lab5;

    interface Sequence {
        int next();
    }

class lastDigitDistribution {
    private int counter [];

    lastDigitDistribution() {
        //create an array of 10 int
        counter = new int[10];
    }

    public void process (Sequence Seq, int values) {

        for (int i = 1; i <= values; i++) {

            int value = Seq.next();
            int lastDigit = value % 10;

            counter[lastDigit]++;
        }
    }

    public void display() {

        System.out.print(" Last Digit  = Count  ");
        System.out.println();

        for (int i = 0; i < counter.length; i++) {
            System.out.print( i + " = " + counter[i] + " ");

            if (counter[i] == 0) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

}

 //code for square sequecne
class SquareSeq implements Sequence {
    //instance variable
     private int n = 0;

     public int next(){
         n++;
         return n*n;
     }
 }

 //Random Sequence
class RandomSeq implements Sequence {
         public int next(){

             return(int) (Integer.MAX_VALUE *  Math.random());
         }
}

 //main method
public class SequenceDemo {
    public static void main(String[] args) {

        //objects
        lastDigitDistribution distribution1 = new lastDigitDistribution(); //to generate for square
        lastDigitDistribution distribution2 = new lastDigitDistribution(); // to generate for random

        //print the square sequence code
        System.out.println("Sequence for Square Sequence : ");
        distribution1.process(new SquareSeq(), 1000);
        distribution1.display();

        //print the random sequence code
        System.out.println();
        System.out.println(" Sequence for Random Sequence : ");
        distribution2.process(new RandomSeq(), 1000);
        distribution2.display();

    }
}