package Pepcoding.AllProblems.SortingAndSearching;

public class o13_LC410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max=0, sum=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            sum+=nums[i];
        }
        int lo=max, high=sum, mid=0, ans=0;
        while(lo<=high){
            mid=lo+(high-lo)/2;
            if(isPossibleLargestSum(nums, mid, m)==true)
            {
                ans=mid;
                high=mid-1;
            }
            else
                lo=mid+1;
        }
        return ans;
    }

    public boolean isPossibleLargestSum(int[] nums, int mid, int m){
        int noOfSubarrays=1, sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum=nums[i];
                noOfSubarrays++;
            }

        }
        return noOfSubarrays<=m;
    } }
