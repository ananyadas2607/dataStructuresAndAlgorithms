package Pepcoding.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class basics {
    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        //Add Last
        void addLast(int val){
            Node temp=new Node();
            temp.data=val;
            temp.next=null;
            if(size==0){
                head=tail=temp;
            }
            else {
                tail.next=temp;
                tail=temp;
            }
            size++;
        }
        //size
        public int size(){
            return size;
        }

        //Display a Linked List
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.data + " ");
                temp=temp.next;
            }
            System.out.println();
        }

        //Remove First
        public void removeFirst(){
            if(size==0)
                System.out.println("List is empty");
            else if(size ==1){
                head=tail=null;
                size=0;
            }
            else{
                head=head.next;
                size--;
            }
        }

        //Get Value-first, last and at
        public int getFirst(){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }
            else{
                return head.data;
            }
        }
        public int getLast(){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }
            else{
                return tail.data;
            }
        }
        public int getAt(int idx){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }
            else if(idx <0 || idx >= size){
                System.out.println("Invalid args");
                return -1;
            }else{
                Node temp=head;
                for(int i=0;i<idx;i++){
                    temp=temp.next;
                }
                return temp.data;
            }
        }

        //Add First
        public void addFirst(int val){
            Node temp=new Node();
            temp.data=val;
            temp.next=head;
            head=temp;
            if(size==0){
                tail=temp;
            }
            size++;
        }

        //Add at index
        public void addAt(int idx, int val){
            if(idx<0 || idx > size){
                System.out.println("Invalid Agruments");
            }else if (idx==0){
                addFirst(val);
            }else if(idx==size){
                addLast(val);
            }else{
                Node newNode=new Node();
                newNode.data=val;
                Node temp=head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;

                }
                newNode.next=temp.next;
                temp.next=newNode;
                size ++;
            }
        }

        //Remove Last
        public void removeLast(){
            if(size==0){
                System.out.println("List is empty");
            }else if(size ==1){
                head=tail=null;
                size=0;
            }else{
                Node temp=head;
                for(int i=0;i<size-2;i++){
                    temp=temp.next;
                }
                tail=temp;
                temp.next=null;
                size--;
            }
        }

        //Reverse a linked list(data iterative)
        public Node getAt_(int idx){

                Node temp=head;
                for(int i=0;i<idx;i++){
                    temp=temp.next;
                }
                return temp;

        }
        public void reverse(){
            int li=0;
            int ri=size-1;
            while(li<ri){
                Node lNode=getAt_(li);
                Node rNode=getAt_(ri);

                int temp=lNode.data;
                lNode.data= rNode.data;
                rNode.data=temp;

                li--;
                ri++;
            }
        }

        //Reverse a linked List(Pointer Iterative)
        public void reversePI(){
            Node prev=null;
            Node curr=head;

            while(curr!=null){
                Node next=curr.next; //store curr nodes next

                curr.next=prev; //then link the curr node's next with prev

                prev=curr;
                curr=next;
            }
            Node temp=head;
            head=tail;
            tail=temp;
        }

        //Remove at index
        public void removeAt(int idx){
            if(idx <0 || idx>=size)
                System.out.println("Invalid Arguments");
            else if(idx ==0)
                removeFirst();
            else if(idx==size-1)
                removeLast();
            else{
                Node temp=head;
                for(int i=0;i <idx-1;i++){
                    temp=temp.next;
                }
                temp.next =temp.next.next;
                size--;

            }

        }

        //LinkedList to stack adapter
        public  class LLtoStackAdapter{
            LinkedList list;

            public LLtoStackAdapter(){
                list=new LinkedList();
            }
            int size(){
                return list.size;
            }
            void push(int val){
                list.addFirst(val);
            }
            void pop(){
                if(size==0){
                    System.out.println("stack underflow");
                }
                else
                {
                    list.removeFirst();
                }
            }

            int top(){
                if(size==0){
                    System.out.println("stack underflow");
                    return -1;
                }
                else{
                    return list.getFirst();
                }
            }
        }

        //Linked List to Queue Adapter
        public  class LLtoQueueAdapter{
            LinkedList list;

            public LLtoQueueAdapter(){
                list=new LinkedList();
            }

            int size(){
                return list.size;
            }

            void add(int val){
                list.addLast(val);
            }

            void remove(){
                if(size == 0){
                    System.out.println("Queue underflow");

                }
                else{
                    list.removeFirst();
                }
            }
            int peek(){
                if(size==0){
                    System.out.println("stack underflow");
                    return -1;
                }
                else {
                    return list.getFirst();
                }
            }
        }




    }



    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
            System.out.println(list.tail.data);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("addLast")){
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            str = br.readLine();
        }

        testList(list);
    }

}
