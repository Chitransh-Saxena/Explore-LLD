package org.lld.graph_patterns;

import java.util.*;

public class DAG {

    Map<String, List<String>> graph;

    public DAG(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public DAG() {

        this.graph = new HashMap<>();
    }


    public Map<String, List<String>> getGraph() {
        return graph;
    }

    public void setGraph(Map<String, List<String>> graph) {
        this.graph = graph;
    }


    public void printDAG() {

        if(this.graph != null && !this.graph.isEmpty()) {

            for(Map.Entry<String, List<String>> entry: this.graph.entrySet()) {
                System.out.println(entry.getKey() + " --> " + entry.getValue());
            }
        }
    }


    public void printTopologicalSort() {



    }

    public boolean isTopologicalSortPossible() {

        // Calculate indegree and store it.
        // Need to get nodes with lowest indegree first. Base case if no indegree is 0, cycle is there
        // Traverse, mark visited and reduce indegree of the nodes which use this node

        Map<String, Integer> indegree = getIndegree(this.graph);
        // Remove the sorting since we don't need it:
        // sortMapByValue(indegree);

        // Continuously process nodes with zero indegree
        while (indegree.containsValue(0)) {
            Iterator<Map.Entry<String, Integer>> it = indegree.entrySet().iterator();
            boolean foundZeroIndegree = false;

            while (it.hasNext()) {
                Map.Entry<String, Integer> degree = it.next();
                if (degree.getValue() == 0) {
                    foundZeroIndegree = true;
                    // Reduce indegree of all outgoing edges
                    for (String node : this.graph.get(degree.getKey())) {
                        indegree.put(node, indegree.get(node) - 1);
                    }
                    // Remove this node from the graph
                    it.remove();
                }
            }

            // If we didn't find any zero indegree node in this iteration, break
            if (!foundZeroIndegree) break;
        }

        // If no nodes are left, topological sort is possible
        return indegree.isEmpty();

    }

    private void sortMapByValue(Map<String, Integer> indegree) {

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(indegree.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        indegree.clear();
        for(Map.Entry<String, Integer> entry : entryList) {
            indegree.put(entry.getKey(), entry.getValue());
        }
    }

    private Map<String, Integer> getIndegree(Map<String, List<String>> graph) {


        Map<String, Integer> indegree = new LinkedHashMap<>();
        for(Map.Entry<String, List<String>> entry: graph.entrySet()) {

            for(String node : entry.getValue()) {
                indegree.put(node, indegree.getOrDefault(node, 0) + 1);
            }
            indegree.putIfAbsent(entry.getKey(), 0);
        }

        return indegree;
    }
}
