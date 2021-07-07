package Pepcoding.ArraysAndStrings;

public class leetcode1191KConcatMaxSum {


    public static int kadanesAlgo(int[] arr, int k){
        int mod=(int)1e9+7;
        int n=arr.length;
        long gSum=0,cSum=0;
        for(int i=0;i<k*n;i++){
            int ele=arr[i%n];
            cSum+=ele;
            if(cSum>gSum)
                gSum=cSum;
            if(cSum<=0)
                cSum=0;
        }
        return (int) gSum % mod;

    }
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int mod=(int)1e9+7;
        long prevSum=0,sum=0;
        for(int i=1;i<=3;i++){
            prevSum=sum;
            sum=kadanesAlgo(arr,i);
            if(i==k)
                return (int) sum;
        }

        return (int) ((prevSum+ (k-2)*(sum-prevSum)) %mod);

    }

    public int kConcatenationMaxSum_02(int[] arr, int k) {
        int mod=(int)1e9+7;
        int kadansSum = kadanesAlgo(arr, 1);

        if (k == 1)
            return kadansSum;

        long prefixSum = 0, suffixSum = 0, maxPrefixSum = 0, maxSuffixSum = 0, arraySum = 0;
        int n = arr.length;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            prefixSum += arr[i];
            suffixSum += arr[j];
            arraySum += arr[i];

            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
            maxSuffixSum = Math.max(maxSuffixSum, suffixSum);
        }

        // if (arraySum > 0)
        // return (int) ((maxPrefixSum + maxSuffixSum + (k - 2) * arraySum) % mod);
        // else
        // return (int) (Math.max(maxPrefixSum + maxSuffixSum, kadansSum) % mod);

        arraySum = arraySum < 0 ? 0 : arraySum % mod;
        return (int) Math.max(kadansSum, maxPrefixSum + maxSuffixSum + ((k - 2) * arraySum) % mod) % mod;
    }

    public static void main(String[] args){
        int[] arr={1,-2,1};
        kConcatenationMaxSum(arr,5);
    }
}


