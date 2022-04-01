package sort;
/*
 	시간복잡도: O(nlog n)
 */
public class HeapSort {
    /*
         힙정렬을 하기위해 트리를 맥스힙 구조로 만들어줌
     */
    static void heapify(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int parent = (i-1) / 2;
            int child = i;

            if(arr[parent] < arr[child])
            {
                swap(arr, parent, child);
            }
        }
    }

    static void swap(int[] arr, int parent, int child) {
        int temp;
        temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }

    /*
         맥스힙 구조의 트리에서 루트와 리프의 값을 바꿔서
         배열의 마지막에 가장 큰 값을 담고 다시 heapify를 진행해
         맥스힙 구조를 만든다음 위의 과정을 반복
         이때 배열의 마지막에는 가장 큰 값이 저장되었으므로
         heapify시 트리의 마지막 노드는 빼고 진행
     */
    static void heapSort(int[] arr, int n) {
        int root = 0;

        for (int i = 1; i <= n; i++) {
            int leaf = n - i;
            swap(arr, root, leaf);
            heapify(arr, n-i);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[] {6, 12, 8, 7, 4, 9, 5};
        int n = arr.length;

        heapify(arr, n);
        heapSort(arr, n);

        System.out.print("정렬 후: ");
        for(int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

}