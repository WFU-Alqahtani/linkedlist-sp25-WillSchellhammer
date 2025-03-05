import java . util .*;

class Node{
    int data;
    Node next=null;

    public Node(int i){
        data=i;
    }
    public Node(int i, Node n){
        data=i;
        next=n;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random rand = new Random();
        int size = 10; // must be greater than 0
        int[] list = new int[size];
        for (int i=0; i<size; i++) {
            //list[i] = 5;
            list[i] = rand.nextInt(10);
        }

        Node head = new Node(list[0]);
        Node curr = head;
        for (int i = 1; i < size; i++) {
            Node temp = new Node(list[i]);
            curr.next = temp;
            curr = curr.next;
        }

        //print
        curr = head;
        while (curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.println();

        //delete
        int x = 0;
        try { //define x, what to search for and delete
            System.out.println("Please input an integer to delete: ");
            x = input.nextInt();
        }
        catch (NumberFormatException e) {
            System.out.print("Please input an INTEGER. " + e);
            System.exit(1);
        }

        if (head.data == x) { // In case x is on head
            head = head.next;
        }
        else {
            curr = head;
            Node prev = null;
            while (curr != null) {
                if (curr.data == x) {
                    prev.next = curr.next;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        //print
        curr = head;
        while (curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.println();

        //insert new node with value 20 at head
        head = new Node(20, head);

        //insert new node with value 40 at end of list
        curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node (40, null);

        //insert new node with value 60 at index 4
        curr = head;
        Node prev = null;
        int count = 1;
        while (curr != null && count < 4) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if (curr != null) {
            curr = new Node(60, curr.next);
            prev.next = curr;
        }

        //print
        curr = head;
        while (curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.println();
    }
}