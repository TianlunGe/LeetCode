package leet.medium;

import java.util.HashMap;
import java.util.Map;

public class Leet399EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0; i<equations.length; i++){
            this.insert(map, equations[i][0], equations[i][1], values[i]);
            if(values[i] != 0){
                this.insert(map, equations[i][1], equations[i][0], 1/values[i]);
            }
        }
        double[] res = new double[queries.length];
        for(int i=0; i<queries.length; i++){
            String[] q = queries[i];
            if(!map.containsKey(q[0]) || !map.containsKey(q[1])) {
                res[i] = -1.0;
                continue;
            }
        }
        return res;
    }

    private void insert(Map<String, Map<String, Double>> map, String k, String v, double val){
        if(map.containsKey(k)){
            map.get(k).put(v, val);
        }
        else{
            Map<String, Double> tmp = new HashMap<>();
            tmp.put(v, val);
            map.put(k, tmp);
        }
    }

}
