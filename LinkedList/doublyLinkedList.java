package Pepcoding.LinkedList;

public class doublyLinkedList {
    class Node{
        int data=0;
        Node prev=null;
        Node next=null;

        Node(int data){
            this.data=data;
        }
    }
    private Node head=null;
    private Node tail=null;
    private int size=0;

    //Add First- O(1)
    private void addFirstNode(Node node){
        if(this.size==0)
            this.head=this.tail=node;
        else{
            node.next=head;
            this.head.prev=node;
            this.head=node;
        }
        this.size++;
    }
    public void addFirst(int val){
        Node node=new Node(val);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if(this.size==0){
            this.head=this.tail=node;
        }else{
            this.tail.next=node;
            node.prev=tail;
            this.tail=node;
        }
        this.size++;
    }
    public void addLast(int val){
        Node node=new Node(val);
        addLastNode(node);
    }
}
