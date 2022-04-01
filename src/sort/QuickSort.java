package sort;
/*
    퀵정렬
    시간복잡도: 평균 O(nlogn), 최악의 경우(선택한 pivot이 계속 가장 크거나 가장 작은 값일 경우) O(n^2)
    pivot을 기준으로 큰값을 pivot + 1에서 end방향으로 찾고 작은값을 end에서 pivot 방향으로 찾음
    큰값과 작은값이 교차할 경우 pivot과 작은값을 교체해주고 교차하지 않는다면 큰값과 작은값을 교체
 */
public class QuickSort {
    static void quickSort(int[] arr, int start, int end) {
        if(start >= end)
            return;
        int key = start; //key(pivot)은 첫번째 원소
        int i = start + 1; //key값보다 큰 값을 찾기위해 왼쪽에서 오른쪽으로 이동할 때 사용할 index
        int j = end; //key값보다 작은 값을 찾기위해 오른쪽에서 왼쪽으로 이동할 때 사용할 index

        while(i <= j) { //엇갈릴 때 가지 반복
            while(i <= end && arr[i] < arr[key]) {
                i++;
            }
            while(arr[key] < arr[j] && j > start) {
                j--;
            }
            if(j < i) { //엇갈렸을 경우
                int temp = arr[key];
                arr[key] = arr[j];
                arr[j] = temp;
            }
            else { //안엇갈렸을 경우
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            quickSort(arr, start, j-1);
            quickSort(arr, j + 1, end); //만약 pivot이 배열에서 가장 큰 값일 경우 i는 배열의 끝으로 가기 때문에 start가 j + 1이 되어야함
        }
    }
    public static void main(String[] args) {

        int[] arr = new int[] {7, 3, 2, 13, 17, 5, 19};
        quickSort(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}