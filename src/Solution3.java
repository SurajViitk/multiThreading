// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution3 {


    public static long getMaxStrengths(List<Integer> arr){
        int n =arr.size();
        List<Integer> with = new ArrayList<>(n);
        List<Integer> without = new ArrayList<>(n);
        long ans = 0;
        with.add(0, arr.get(0));
        without.add(0, arr.get(0));
        for(int i=1; i<n ; i++){
            with.add(i,  without.get(i-1) + arr.get(i) * (i+1) - arr.get(i) + arr.get(i-1));
            without.add(i,  arr.get(i) * (i+1) + Math.max(with.get(i-1) , without.get(i-1)));
            System.out.println(i +" "+ with.get(i) +" " + without.get(i));
        }
        return Math.max(with.get(n-1), without.get(n-1));
    }


    public static void main(String[] args) {

//        List<Integer> arr = new ArrayList<>(List.of(1,9,7,3,2));
//        List<Integer> arr = new ArrayList<>(List.of(2,1,4,3));
        List<Integer> arr = new ArrayList<>(List.of(1,2,5));

        long result = getMaxStrengths(arr);
        System.out.println("Maximum Efficiency: " + result);
    }
}