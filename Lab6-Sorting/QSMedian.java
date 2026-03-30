package Lab6;

public class QSMedian {

    static int median(int arr[], int low, int high) {
        int mid = (low +high)/2;

        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];


        //find median index
        if ((a > b && a < c ) || (a<b && a > c)) {
            return low;
        }else if ((b > a && b < c) || (b < a && b > c)) {
            return mid;
        }else {
            return high;
            }
    }

    //
    //partition function
    static int partition (int arr[], int low, int high) {

        //get median index and swap with last element
        int medianIndex = median(arr, low, high);

        int temp = arr[medianIndex];
        arr[medianIndex] = arr[high];
        arr[high] = temp;

        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1; //i will track the positions of smaller elements than the pivot

        for  (int j = low; j < high; j++) {
            if (arr[j] < pivot) { //checks if current element is smaller than pivot
                i++;

                //swap
                int Temp = arr[i];
                arr[i] = arr[j];
                arr[j] = Temp;

            }
        }

        //place pivot at the corrct sorted positions
        int Temp1 = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = Temp1;

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
