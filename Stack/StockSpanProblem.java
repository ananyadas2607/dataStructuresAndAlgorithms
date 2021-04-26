package Pepcoding.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static int[] stockSpan(int[] prices) {
        Stack<Integer> s = new Stack();
        int[] span = new int[prices.length];
        //Span of day 1
        span[0]=1;
        s.push(0);

        for(int i=1; i<prices.length; i++){
            //Find the price on stack which is greater than current day's price
            while(!s.empty() && prices[i] > prices[s.peek()]){
                s.pop();

                if(s.empty())
                    span[i] = i+1;
                else
                    span[i] =  i - s.peek();

                //Push current day onto top of stack
                s.push(i);
            }
        }
        return span;
    }

    public static void main(String args[]){
        int prices[] = {100, 60, 70, 65, 80, 85, 45, 77, 56, 98, 200};
        int[] span = stockSpan(prices);

        Arrays.stream(span).forEach(System.out::println);

    }
}
