package Pepcoding.AllProblems.SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class O1_marksOfPcm {
    public static class Marks implements Comparable<Marks>{
        int phy;
        int chem;
        int maths;

        Marks(int phy, int chem, int maths){
            this.phy=phy;
            this.chem=chem;
            this.maths=maths;
        }

        @Override
        public int compareTo(Marks o) {
            if(this.phy!=o.phy)
                return this.phy - o.phy;
            else if(this.chem!=o.chem)
                return o.chem - this.chem;
            else
                return this.maths-o.maths;
        }
    }
    public static void customSort (int phy[], int chem[], int math[], int n)
    {
        // your code here
        Marks[] arr=new Marks[n];

        for(int i=0;i<n;i++){
            arr[i]=new Marks(phy[i],chem[i],math[i]);
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            phy[i]=arr[i].phy;
            chem[i]=arr[i].chem;
            math[i]=arr[i].maths;
        }

    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int[] phy={4, 1, 10, 4 ,4 ,4 ,1 ,10, 1, 10};
        int[] chem={5,2 ,9 ,6, 3, 10, 2, 9, 14, 10};
        int[] math={12, 3, 6, 5, 2, 10, 16, 32, 10, 4};
        int n=10;

        customSort(phy,chem,math,n);

        //output
        for(int i=0; i < n;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }

}
