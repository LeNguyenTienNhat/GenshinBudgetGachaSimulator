public class Node {
    int rollNum; //random number

    Node next; //store info of next Node

    Node() {
    }

    Node(int r,Node n) {
        rollNum=r;
        next=n;
    }

}