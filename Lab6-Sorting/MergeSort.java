package Lab6;

public class MergeSort {

    //Merge Function - combines 2 sorted arrays
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; //subarray from left to mid
        int n2 =  right - mid; //subarray from mid + 1 to right

        //creates temp array to store right and left elements
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];

        //add data into the temporary arrays created
        for (int i =0; i < n1; i++) {
            LeftArray[i] = arr[left+i];
        }
        for  (int j =0; j < n2; j++) {
            RightArray[j] = arr[mid+1+j];
        }

        //merge
        int i = 0, j = 0; //for left and right array respectively
        int k = left; //tracker for original array

        //ensure it runs until one of the array is traversed completely
        while (i < n1 && j < n2) {

            //if element in left is smaller
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                //elemnet in right is smaller
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }


        //remaining elements if there are left any
        //left elements
        while (i < n1) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        //right elements
        while (j < n2) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }


    //Merge Sort Function
    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { //check if array has more than 1 element
            int mid = (left + right) / 2;


            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            //call method to merge 2  sorted halves
            merge(arr, left, mid, right);
        }
    }


    //main method
    public static void main(String[] args) {

        int arr[] = {2, 4,5, 6,1,1,10,13,38,27,43,3,9,82,10};

        mergeSort(arr, 0, arr.length - 1);

        //display sorted elements
        System.out.println("Sorted Elements");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
