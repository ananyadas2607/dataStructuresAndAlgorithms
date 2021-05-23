package Pepcoding.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class leetcode380 {
    HashMap<Integer, Integer> hm=new HashMap<>();
    ArrayList<Integer> list=new ArrayList<>();
    Random rand=new Random();

    /** Initialize your data structure here. */
    public leetcode380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;

        list.add(val);
        hm.put(val, list.size()-1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hm.containsKey(val))
            return false;

        int idx = hm.get(val);
        int lidx = list.size() - 1;
        int lval = list.get(lidx);

        list.set(idx, lval);
        hm.put(lval, idx);

        hm.remove(val);
        list.remove(lidx);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);

    }
}
