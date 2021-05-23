package Pepcoding.ArraysAndStrings;

public class KadanesAlgo {

    //Approach 1 (if(Sum is negative)- it will print 0)
    public static int KadanesAlgo(int[] arr){
        int gSum=0, cSum=0;
        for(int ele: arr){
            cSum+=ele;
            if(cSum>gSum)
                gSum=cSum;
            if(cSum<=0)
                cSum=0;
        }
        return gSum;
    }

    public static int kadanesAlgo_SubArray(int[] arr) {
        int gSum = 0, cSum = 0, gsi = 0, gei = 0, csi = 0;
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            cSum += ele;
            if (cSum > gSum) {
                gSum = cSum;

                gsi = csi;
                gei = i;
            }
            if (cSum <= 0) {
                cSum = 0;
                csi = i + 1;
            }
        }

        return gSum;
    }

    // [-1,-7,-8,-9] -> max sum Subarray if -1 (0,0);
    public static int kadanesAlgoGeneric(int[] arr) {
        int gSum = -(int) 1e9, cSum = 0;
        for (int ele : arr) {
            cSum = Math.max(ele, cSum + ele);
            gSum = Math.max(gSum, cSum);
        }

        return gSum;
    }

    public static int[] kadanesAlgoGenericSubarray(int[] arr) {
        int gSum = -(int) 1e9, cSum = 0, gsi = 0, gei = 0, csi = 0;
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            cSum += ele;
            if (ele >= cSum) {
                cSum = ele;
                csi = i;
            }

            if (cSum > gSum) {
                gSum = cSum;
                gsi = csi;
                gei = i;
            }
        }

        return new int[] { gSum, gsi, gei };
    }
}
