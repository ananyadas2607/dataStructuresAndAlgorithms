package Pepcoding.Recursion;

public class RecursiveTreeCoinChange {
    public static int permutationInfiCoins(int[] arr, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int ele: arr){
            if(tar-ele>=0)
                count+=permutationInfiCoins(arr, tar-ele, ans+ele);
        }
        return count;
    }

    public static int combinationInfiCoins(int[] arr, int tar,  int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(tar-arr[i]>=0)
                count+=combinationInfiCoins(arr, tar-arr[i],i, ans+arr[i]);
        }
        return count;

    }

    public static int combinationSingleCoins(int[] arr, int tar,  int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(tar-arr[i]>=0)
                count+=combinationSingleCoins(arr, tar-arr[i],i+1, ans+arr[i]);
        }
        return count;

    }
    public static int permutationSingleCoins(int[] arr, int tar, String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > 0 && tar - arr[i] >= 0) {
                    int val=arr[i];
                    arr[i]=-val;
                   count += permutationSingleCoins(arr, tar - val, ans + val);
                    arr[i]=val;
            }
        }
        return count;
    }

    public static void permutationCombination(){
        int[] arr={2,3,5,7};
        int tar=10;
        permutationInfiCoins(arr,tar,"");
        combinationInfiCoins(arr, tar, 0,"");
        combinationSingleCoins(arr, tar, 0,"");
    }
}
