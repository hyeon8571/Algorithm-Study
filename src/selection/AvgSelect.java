package selection;
/*
    평균 선형시간 선택 알고리즘
    시간복잡도: 평균 O(n), 최악의 경우 O(n^2)
    퀵정렬 유사하지만 단순히 작은 값은 왼쪽 큰 값은 오른쪽으로만 보냄
 */
public class AvgSelect {
    public static int select(int[] arr, int p, int r, int target) {

        if (p == r)
            return arr[p];  //배열의 요소가 한개인 경우이므로 바로 출력

        int q = partition(arr, p, r);

        int k = q - p + 1; //pivot이 몇번째 작은원소인지

        if (target < k)

            return select(arr, p, q - 1, target);

        else if (target == k)

            return arr[q];

        else
            return select(arr, q + 1, r, target - k);//pivot까지의 값을 제외하고 작은 값을 찾아야 하므로 target - k 번째 작은 값을 찾아야함

    }
    public static int partition(int[] arr, int p, int r) {

        int pivot = arr[r]; //좌우 분할 기준값
/*
    만약 i = p로 할 경우 i++를 해줘야 한다. 이 때 if문이 끝났을 때 i값이 자동을 1 증가하므로
    pivot위치를 옮겨줄 때 arr[i+1]이 아닌 arr[i]를 해줘야 한다. 이 경우 이해하는데 있어
    문제가 될 수 있으므로 i를 p-1로 초기화 해준다.
 */
        int i = p - 1;

        int temp;

        for (int n = p; n < r; n++) {

            if (arr[n] <= pivot) { //pivot보다 작은값은 왼쪽에 배치

                temp = arr[n];

                arr[n] = arr[++i];

                arr[i] = temp;
            }
        }

        //pivot을 기준으로 더 작은값들은 배열을 i번째 까지 배치 되었으므로 pivit을 i+1번째로 옮겨준다.
        temp = arr[r];

        arr[r] = arr[i + 1];

        arr[i + 1] = temp;

        return i + 1;//기준 값의 인덱스 리턴

    }


    public static void main(String[] args) {

        int[] arr = new int[] {7, 15, 3, 28, 25, 17, 5};

        int target = select(arr, 0, arr.length -1, 5);
        System.out.println(target);
    }

}