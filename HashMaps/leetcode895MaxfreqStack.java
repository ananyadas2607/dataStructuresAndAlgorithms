package Pepcoding.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class leetcode895MaxfreqStack {
    HashMap<Integer, Integer> freq;
    ArrayList<Stack<Integer>> freqMap;
    int maxFreq;

    public leetcode895MaxfreqStack() {
        freq=new HashMap<>();
        freqMap=new ArrayList<>();
        maxFreq=0;
        freqMap.add(new Stack<>());
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val,0)+1);
        maxFreq=Math.max(maxFreq, freq.get(val));
        if(freqMap.size() == maxFreq)
            freqMap.add(new Stack<>());
        freqMap.get(freq.get(val)).add(val);
    }

    public int pop() {
        int rv = freqMap.get(maxFreq).pop();

        if (freqMap.get(maxFreq).size() == 0)
            freqMap.remove(maxFreq--);

        freq.put(rv, freq.get(rv) - 1);
        if (freq.get(rv) == 0)
            freq.remove(rv);

        return rv;
    }
}
