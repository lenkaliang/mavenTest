package com.maven.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolutionImpl implements Solution {

    public Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {

        Integer min = Integer.MAX_VALUE;
        Map<String, Integer> fMap = new HashMap<String, Integer>();
        int lMin;
        boolean positive;
        for (Map<String, Integer> map : records) {
            lMin = (map.containsKey(key)) ? map.get(key) : 0; // Assign 0 to localMin if the key doesn't exist in the current map
            positive = true;
            for (String k : map.keySet()) {
                if (map.get(k) < 0) 
                    positive = false;
                if (k.equals(key) && map.get(k) < min) {
                    min = map.get(k);
                    lMin = map.get(k);

                }
                if (k.equals(key) && lMin <= min)
                    fMap.put(k, lMin);

                else if (!k.equals(key) & positive) { // push if not the given key and its value is positive
                    fMap.put(k, map.get(k));
                }
            }

            if (lMin == 0)
                fMap.remove(key); // Remove if localMin is 0

        }

        return fMap;

    }

}
