package com.example.demo.leetCode.p785;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Graph {

    public static void main(String args[]){
        int[][] ss = {{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
        System.out.println(isBipartite(ss));
    }

    public static boolean isBipartite(int[][] graph) {
        Map<Integer, Boolean> colorMap = new HashMap<>();

        int k = 0;
        for (int i = 0; i < graph.length; i++){
            if (graph[i].length == 0){
                k++;
                continue;
            }else if (colorMap.containsKey(i)) {
                continue;
            }else{
                boolean isBipartite = color(i, true, graph, colorMap);
                if (!isBipartite){
                    return isBipartite;
                }else if (graph.length == colorMap.keySet().size() + k){
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean color(int num, boolean color, int[][] graph, Map<Integer, Boolean> colorMap){
        if (colorMap.containsKey(num)){
            if (colorMap.get(num) == color){
                return true;
            }else {
                return false;
            }
        }else {
            colorMap.put(num, color);
        }
        color = color? false : true;
        for (int point : graph[num]){
            if (!color(point, color, graph, colorMap)){
               return false;
            }
        }
        return true;
    }


}
