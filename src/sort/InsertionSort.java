package sort;
/*
    삽입정렬
    시간복잡도: O(n^2)
 */

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int target = arr[i];
            int j = i - 1;

            while(j >=0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 6, 3, 7};
        insertionSort(arr);

        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
