package sort;

/*
 	선택정렬
 	시간복잡도: O(n^2)
 	배열의 첫번째 값을 마지막까지 비교하여 가장 작은 값을 배열의 첫번째에 저장,
 	두번째 값을 마지막까지 비교하여 그다음 작은 값을 배열의 두번째에 저장,
 	이 과정을 반복하여 모든 요소들을 정렬
 */
public class SelectionSort {

    public static void main(String[] args) {

        int list[] = new int[] {10, 7, 17, 9, 3, 25};


        int temp;

        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int k = 0; k < list.length; k++) {
            System.out.printf("%d ", list[k]);
        }
    }
}