package linklist;
import java.util.*;
public class Main {
    public static void main(String[] args){
//        create new LL
        LinkList l1 = new LinkList();
        l1.insertAtHead(1);
        l1.print();
        l1.insertAtHead(5);
        l1.print();
        l1.insertAtHead(8);
        l1.print();
        l1.insertAtHead(3);
        l1.print();
    }
}
class Node {
    int val;
    Node next;
    Node(int val)
    {
        this.val = val;
         //this.next will by default have the value 'null'

    }
}
class LinkList
{
    Node head;
    void insertAtHead(int val)
    {
        //1.create a Node with the value 'val, whose next = null
        Node n = new Node(val);
        //2. check if the Linked List is empty(this.head == null)
        if(this.head == null){
            this.head = n;
            return;
        }
        //3.Insert the newly created Node before
        n.next = head;
        this.head = n;


    }
    void print()
    {
        Node temp = this.head;
        System.out.print("Linked List:");
        while(temp != null)
        {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

