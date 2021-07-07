package Pepcoding.ArraysAndStrings;

import java.util.Arrays;

public class GFGMaxSumRectangle {

    public static int kadanesAlgoForNegative(int[] arr) {
        int gSum = -(int) 1e9, cSum = 0;
        for (int ele : arr) {
            cSum = Math.max(ele, cSum + ele);
            gSum = Math.max(gSum, cSum);
        }

        return gSum;
    }

    int maximumSumRectangle(int R, int C, int arr[][]) {
        int n = R, m = C, maxSum = -(int) 1e9;
        int[] colPrefixSum = new int[m];

        for (int fixRow = 0; fixRow < n; fixRow++) {

            Arrays.fill(colPrefixSum, 0);

            for (int row = fixRow; row < n; row++) {
                for (int col = 0; col < m; col++)
                    colPrefixSum[col] += arr[row][col];

                int sum = kadanesAlgoForNegative(colPrefixSum);
                maxSum = Math.max(maxSum, sum);

            }
        }

        return maxSum;
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

    // if we want to print matrix
    int maximumSumRectangle_02(int R, int C, int arr[][]) {
        int n = R, m = C, maxSum = -(int) 1e9;
        int[] colPrefixSum = new int[m];

        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;

        for (int fixRow = 0; fixRow < n; fixRow++) {

            Arrays.fill(colPrefixSum, 0);

            for (int row = fixRow; row < n; row++) {
                for (int col = 0; col < m; col++)
                    colPrefixSum[col] += arr[row][col];

                int[] res = kadanesAlgoGenericSubarray(colPrefixSum);
                if (res[0] >= maxSum) {
                    maxSum = res[0];
                    r1 = fixRow;
                    c1 = res[1];
                    r2 = row;
                    c2 = res[2];
                }
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return maxSum;
    }

}
