package Pepcoding.ArraysAndStrings;

public class GFGSmallestWindowContainingAllChars {
    public String findSubString( String str) {
        // Your code goes here
        int n=str.length();
        if (str.length() <= 1)
            return str;
        int[] freq = new int[128];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 0) {
                freq[str.charAt(i)] = 1;
                count++;
            }
        }

        int actualLen = count;
        int si = 0, ei = 0, gsi = 0, len = (int) 1e9;

        while (ei < n) {
            if (freq[str.charAt(ei++)]-- > 0)
                count--;

            while (count == 0) {
                if (ei - si < len) {
                    len = ei - si;
                    gsi = si;
                }

                if (freq[str.charAt(si++)]++ == 0)
                    count++;
            }

            if (len == actualLen)
                break;
        }

        return str.substring(gsi, gsi + len);
    }
}
