// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Solution2 {


    public static long getMaximumEfficiency(List<Integer> capacity, List<Integer> numServers) {
        // Convert List to array for easier handling
        int n = capacity.size();
        long ans = 0;
        Collections.sort(capacity);
        Collections.sort(numServers, Collections.reverseOrder());
        for(int i=0; i<numServers.size() ; i++){
            if(numServers.get(i)==1)
                break;
            ans+= (capacity.get(n-i-1) - capacity.get(i));
        }

        return ans;
    }


    public static void main(String[] args) {

        List<Integer> capacity = new ArrayList<>(List.of(3,6,1,2));

        List<Integer> numServers = new ArrayList<>(List.of(2,2));

//        List<Integer> capacity = new ArrayList<>(List.of(4,2,1));
//        List<Integer> numServers = new ArrayList<>(List.of(1,1,1));

//        List<Integer> capacity = new ArrayList<>(List.of(1,2,3,4));
//        List<Integer> numServers = new ArrayList<>(List.of(4));

        long result = getMaximumEfficiency(capacity, numServers);
        System.out.println("Maximum Efficiency: " + result);
    }
}