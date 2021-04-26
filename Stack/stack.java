package Pepcoding.Stack;

public class stack {
    private int[] arr;
    private int top;
    private int elementCount;
    private int MaxCapacity;

    protected void initializeValues(int size){
        this.arr=new int[size];
        this.top=-1;
        this.elementCount=0;
        this.MaxCapacity=size;
    }

    public stack(){
        initializeValues(10);
    }

    public stack(int size){
        initializeValues(size);
    }

    protected int capacity(){
        return this.MaxCapacity;
    }
    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount==0;
    }

    protected void StackEmptyException() throws Exception {
        if (this.elementCount == 0)
            throw new Exception("StackISEmpty");
    }

    protected void StackOverflowException() throws Exception {
        if (this.elementCount == this.MaxCapacity)
            throw new Exception("StackOverflow");
    }

    public void push(int data) throws Exception{
        StackOverflowException();
        push_(data);
    }

    protected void push_(int data) throws Exception {
        this.top++;
        this.arr[this.top] = data;
        this.elementCount++;
    }

    public int top() throws Exception {
        StackEmptyException();
        return top_();
    }

    protected int top_() {
        return this.arr[this.top];
    }

    public int peek()throws Exception{
        // try{
        //    CheckException_peek();
        //    return this.arr[this.tos];
        // }catch(Exception e){
        //     System.out.println("handel");
        // }

        if(this.isEmpty()){
            throw new Exception("StackIsEmpty");
        }

        return this.arr[this.top];
    }

    protected int pop_() throws Exception {
        if(this.isEmpty()){
            throw new Exception("StackIsEmpty");
        }

        int rv = this.arr[this.top];
        this.arr[this.top] = 0; //Always try to put default values in empty spaces
        this.top--;
        this.elementCount--;

        return rv;
    }

    public int pop() throws Exception{
        StackEmptyException();
        return pop_();
    }
}