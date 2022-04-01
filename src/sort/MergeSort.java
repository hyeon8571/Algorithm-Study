package sort;
/*
 	시간복잡도: O(nlog n)
 	divide and conquer
 	배열을 더이상 쪼개지지 않을때 까지 쪼갠 후 정렬
 */
public class MergeSort {

    public static void Sort(int[] arr, int left, int right) {

        if(left < right) {
            int mid = (left + right) / 2;
            Sort(arr, left, mid);
            Sort(arr, mid + 1, right);
            Merge(arr, left, mid, right);
        }

    }

    public static void Merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int index = left;

        int[] temp = new int[arr.length]; //temp를 안만들고 arr에서 바로 변경시 중복되는 값이 나올 수 있음

        while(i <= mid && j <= right) {
            if(arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            }
            else
                temp[index++] = arr[j++];
        }
        while(i <= mid) {
            temp[index++] = arr[i++];
        }

        while(j <= right) {
            temp[index++] = arr[j++];
        }
        for(int k = left; k < index; k++) {
            arr[k] = temp[k];
        }
    }


    public static void main(String[] args) {


        int[] arr = new int[] {3, 12, 7, 9, 25, 32, 2};

        Sort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }

    }
}