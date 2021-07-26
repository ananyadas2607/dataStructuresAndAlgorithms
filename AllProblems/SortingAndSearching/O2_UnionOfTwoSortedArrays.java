package Pepcoding.AllProblems.SortingAndSearching;

import java.util.ArrayList;

public class O2_UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        int i=0,j=0;
        while(i<n && j<m){
            if(arr1[i]==arr2[j]){
                if(al.size()>0 && al.get(al.size()-1) != arr1[i])
                    al.add(arr1[i]);
                else if(al.size()==0)
                    al.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                if(al.size()>0 && al.get(al.size()-1) != arr1[i])
                    al.add(arr1[i]);
                else if(al.size()==0)
                    al.add(arr1[i]);
                i++;
            }
            else{
                if(al.size()>0 && al.get(al.size()-1) != arr2[j])
                    al.add(arr2[j]);
                else if(al.size()==0)
                    al.add(arr2[j]);
                j++;
            }
        }

        while(i<n){
            if(al.size()>0 && al.get(al.size()-1) != arr1[i])
                al.add(arr1[i]);
            else if(al.size()==0)
                al.add(arr1[i]);
            i++;
        }

        while(j<m){
            if(al.size()>0 && al.get(al.size()-1) != arr2[j])
                al.add(arr2[j]);
            else if(al.size()==0)
                al.add(arr2[j]);
            j++;
        }
        return al;
    }
}
