package selection;

public class AvgSelect {

    public static int partition(int[] arr, int p, int r) {

        int x = arr[r]; //좌우 분할 기준값

        int i = p - 1;

        int temp;

        for (int n = p; n < r; n++) {

            if (arr[n] <= x) {//더 작은 값을 좌측으로

                temp = arr[n];

                arr[n] = arr[++i];

                arr[i] = temp;

            }

        }

//더 작은 값들을 i까지의 인덱스에 보내주었다. i+1의 인덱스에 해당하는 value는 무조건 A[r]보다 큰 값이니 A[r]과 A[i+1]을 swap한다.

        temp = arr[r];

        arr[r] = arr[i + 1];

        arr[i + 1] = temp;

        return i + 1;//기준 값의 인덱스 리턴

    }


    public static int select(int[] arr, int p, int r, int i) {

        if (p == r)

            return arr[p];


        int q = partition(arr, p, r);

        int k = q - p + 1;

        if (i < k)

            return select(arr, p, q - 1, i);

        else if (i == k)

            return arr[q];

        else
            return select(arr, q + 1, r, i - k);//여기서 i번째로 작은 원소는 이미 K개 만큼의 자신보다 더 작은 원소를 가지고 있기 때문에 마지막 인수에 i가 아닌 i-k를 사용한다.

    }


    public static void main(String[] args) {

        int[] arr = new int[] {7, 15, 3, 28, 25, 17, 5};

        int target = select(arr, 0, arr.length -1, 3);
        System.out.println(target);
    }

}