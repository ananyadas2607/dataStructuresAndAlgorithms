package Pepcoding.SortingAndSearching;

public class LC34FirstAndLastElementInTheIndex {
    public int firstIndex(int[] arr, int data){
        int n=arr.length,ei=n-1,si=0,mid=0;
        while(si<=ei){
            mid=(ei+si)/2;
            if(arr[mid]==data){
                if(mid-1>=0 && arr[mid-1]==data)
                    ei=mid-1;
                else
                    return mid;
            }
            else if(arr[mid]>data)
                ei=mid-1;
            else
                si=mid+1;
        }
        return -1;
    }
    public int lastIndex(int[] arr, int data){
        int n = arr.length, si = 0, ei = n - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                if (mid + 1 < n && arr[mid + 1] == data)
                    si = mid + 1;
                else
                    return mid;
            } else if (arr[mid] < data)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;
    }


        public static int lastIndex_betterway(int[] arr, int data) {
            int n = arr.length, si = 0, ei = n - 1;
            while (si <= ei) {
                int mid = (si + ei) / 2;
                if (arr[mid] <= data)
                    si = mid + 1;
                else
                    ei = mid - 1;
            }

            int insertPos = si;
            int lastIndex = si - 1;

            return (lastIndex >= 0 && arr[lastIndex] == data) ? lastIndex : -1;
        }


    public int[] searchRange(int[] arr, int data) {
        return new int[] { firstIndex(arr, data), lastIndex(arr, data) };
    }
}
