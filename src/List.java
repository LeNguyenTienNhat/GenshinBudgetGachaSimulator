import java.util.Random;  

public class List {
    Node head,tail;

    List() {
        head=tail=null;
    }

    boolean isEmpty() {
        return (head==null);
    }

    void deleteList() {
        head=tail=null;
    }

    int getRandomNum(int range) {
        Random random = new Random();
        int x = random.nextInt(range);   
        return x;
    }

    void printList(){
        Node node = head;
        while (node!=null) {
            System.out.println("Code: " + node.rollNum);
            node=node.next;
        }
    }

    void addNode(int x) {
        if (isEmpty()) {
            head=tail=new Node(x, null);
        }
        else {
            Node node = new Node(x, null);
            tail.next=node;
            tail=node;
        }
    }
}
