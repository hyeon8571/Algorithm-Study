package search;
/*
    검색시간: O(log n)
 */
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
/*
    삽입없이 트리를 만드는 법
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
*/
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

    public void insert(int value) {
        root = insertNode(root, value);
    }

    public Node insertNode(Node root, int value) {
        if (root == null) { //root가 비어있으면 아무런 값이 없으므로 루트에 삽입
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
             root.left = insertNode(root.left, value);
        }
        else if(value > root.data) {
             root. right = insertNode(root.right, value);
            }
            return root;
        }

        /*
            삭제
            1. 자식 노드가 없는 경우
            2. 하나의 자식 노드를 갖는 경우
            3. 두개의 자식 노드를 갖는 경우
         */
        public void delete(int value) {
            root = delete(root, value);
        }

        public Node delete(Node root, int value) {
            if (root == null) return root;
            //삭제 전 value의 위치를 찾는다.
            if (value < root.data) {
                root.left = delete(root.left, value);
            }
            else if (value > root.data) {
                root.right = delete(root.right, value);
            }
            else { //삭제 할 value 발견
                if (root.left == null && root.right == null) { //삭제 할 노드의 자식노드가 없는 경우
                    root = null;
                    return root;
                }
                else if (root.left == null) { //삭제 할 노드의 자식노드가 오른쪽만 있는 경우
                    root = root.right;
                    return root;
                }
                else if (root.right == null) { //삭제 할 노드의 자식노드가 왼쪽만 있는 경우
                    root = root.left;
                    return root;
                }
                else { //삭제 할 노드의 자식노드가 2개인 경우
                    //1. 삭제할 노드의 오른쪽 자식으로 이동한 후 가장 작은 값을 찾아 삭제 할 node에 값을 대입한다. 이 때 node를 복사하는 것이 아닌 data값만 복사한다.
                    root.data = findMin(root.right);
                    //2. 값을 대입해준 가장 작은 값을 가진 노드를 삭제
                    root.right = delete(root.right, root.data);
                }
            }
            return root;
        }

    public int findMin(Node root) {
            int min = root.data;
            while(root.left != null) {
                min = root.left.data;
                root = root.left;
            }
            return min;
    }

    public static void main(String[] args) {

        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(5);
        bt.insert(6);
        bt.insert(8);
        bt.insert(1);
        bt.insert(2);
        bt.insert(4);
        bt.insert(7);
        bt.insert(3);
        bt.insert(10);
        bt.insert(9);


        /*
            5
         /     \
        1       6
         \       \
           2      8
            \    /  \
             4  7    10
             /       /
            3       9
         */

        bt.search(bt.root, 9);
        bt.delete(8);
        bt.search(bt.root, 7);
        bt.delete(9);
        bt.search(bt.root, 7);
    }
}
