package Lab6;

public class QuickSortLastElement {

    //partition function
    static int partition (int arr[], int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1; //i will track the positions of smaller elements than the pivot

        for  (int j = low; j < high; j++) {
            if (arr[j] < pivot) { //checks if current element is smaller than pivot
                i++;

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        //place pivot at the corrct sorted positions
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+ 1; //returns pivot at correct positions
    }

    //quick Sort recursive Function
    static void quicksort(int arr[], int low, int high) {
        //condition to sort only if there are 2 elements
        if (low < high) {
            int pi = partition(arr, low, high);

            //recusive function
            quicksort(arr, low, pi-1); //left part of pivot
            quicksort(arr, pi+1, high); //right part of the pivot
        }
    }

    //Main method
    public static void main (String []args) {

        int arr [] = {10,3,4,6,8,11,2,3,1,1,7};

        quicksort(arr, 0, arr.length-1);

        //diplay sorted elements
        System.out.println("Sorted Array : ");
        for  (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
