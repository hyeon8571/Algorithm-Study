package sort;

/*
 	버블정렬
 	시간복잡도: O(n^2)
 	배열의 첫번째 값과 두번째 값을 비교, 두번째 값과 세번째 값을 비교,
 	세번째 값과 네번째 값을 비교 이 과정을 반복하여 가장 큰 값을 배열 마지막에 저장
 	이 과정을 다시 반복하여 다음 큰 값이 배열 마지막 -1 칸에 저장
 	모든 요소가 정렬 될 때 까지 이 과정을 반복
 */
public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = new int[] {3, 7, 6, 5, 9, 4};

        int max;

        for(int i = arr.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    max = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = max;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

}