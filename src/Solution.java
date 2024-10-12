// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;


class Solution {
    public static List<Integer> findRequestsInQueue(List<Integer> wait) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> indiSet = new HashSet<>();

        // Populate the map with indices
        for (int i = 0; i < wait.size(); i++) {
            int key = wait.get(i);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }

        // Process each element in wait
        for (int i = 0; i < wait.size(); i++) {
            if(indiSet.contains(i))
                continue;

            res.add(map.size());

            if (map.size() == 0) {
                break;
            }

            int currentKey = wait.get(i);

            // Remove the current key from the map
            if(map.containsKey(currentKey)){
                map.get(currentKey).remove(0);
                if(map.get(currentKey).isEmpty())
                    map.remove(currentKey);
            }

            // Remove all elements with keys less than wait[i] + 1
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, List<Integer>> entry = iterator.next();
                if (entry.getKey() < currentKey + 1) {
                    indiSet.addAll(entry.getValue());
                    iterator.remove();
                }
            }
        }

        // Ensure the last element in the result is 0 if it's not already 0
        if (res.get(res.size() - 1) != 0) {
            res.add(0);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> wait = Arrays.asList(3,1,2,1);
        List<Integer> result = findRequestsInQueue(wait);

        System.out.println("Result: " + result);
    }
}