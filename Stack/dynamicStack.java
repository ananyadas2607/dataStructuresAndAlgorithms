package Pepcoding.Stack;

import Pepcoding.Stack.adapters.stack;

public class dynamicStack extends stack {

    public dynamicStack(){
        super();
    }

    public dynamicStack(int size) {
        super(size);
    }

    public dynamicStack(int[] arr) throws Exception {
        int n=arr.length;
        super.initializeValues(2*n);

        for(int ele:arr){
            super.push_(ele);
        }
    }

    @Override
    public void push(int data) throws Exception {
        if(super.size() == super.capacity()){
            int n=super.size();
            int[] temp=new int[n];
            int i=n-1;
            while(super.size()!=0){
                temp[i--]=super.pop();
            }

            super.initializeValues(2*n);

            for(int ele:temp)
                super.push_(ele);
        }
        super.push(data);
    }
}
