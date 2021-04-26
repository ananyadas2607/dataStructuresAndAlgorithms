package Pepcoding.Stack.adapters;

import java.util.LinkedList;

public class stackUsingLL {
    private LinkedList<Integer> ll=new LinkedList<>();

    public void push(int data){
        ll.addFirst(data);
    }
    public void top(int data){
        ll.getFirst();
    }
    public void pop(){
        ll.removeFirst();
    }
}
