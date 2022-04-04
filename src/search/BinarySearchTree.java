package search;
public class BinarySearchTree {

        class Node {
        int data;
        Node left;
        Node right;
        Node root;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void makeTree(int[] arr) {
        root = makeTree(arr, 0, arr.length-1);
    }

    public Node makeTree(int[] arr, int start, int end) {
        if(start > end)  //재귀를 끝내주는 부분
            return null;
        int mid = (start + end) /2;
        Node node = new Node(arr[mid]);
        node.left = makeTree(arr, start, mid -1); //부모노드 보다 작은 값들은 왼쪽
        node.right = makeTree(arr, mid + 1, end); //부모노드 보다 큰 값들은 오른쪽

        return node;
    }

    public void search(Node node, int find) {
        if (find < node.data) {
            System.out.println("찾을 값이 " + node.data + "보다 작음");
            search(node.left, find); //작으면 왼쪽에 있으므로 왼쪽에서 다시 찾는다
        }
        else if (find > node.data) {
            System.out.println("찾을 값이 " + node.data + "보다 큼");
            search(node.right, find); //크면 오른쪽에 있으므로 오른쪽에서 다시 찾는다.
        }
        else
            System.out.println("발견");
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        /*
               5
             /   \
           2      8
          / \    / \
         1   3  6   9
                 \   \
                   7   10
         */
        BinarySearchTree bt = new BinarySearchTree();
        bt.makeTree(arr);
        bt.search(bt.root, 2);
    }
}
