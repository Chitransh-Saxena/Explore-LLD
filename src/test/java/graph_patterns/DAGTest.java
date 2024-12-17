package graph_patterns;

import org.junit.Assert;
import org.junit.Test;
import org.lld.graph_patterns.DAG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAGTest {


    private Map<String, List<String>> getDefaultMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", List.of("C"));
        map.put("B", List.of("C"));
        map.put("C", List.of("E", "D"));
        map.put("E", List.of("F"));
        map.put("D", List.of("F"));
        map.put("F", List.of("G"));
        map.put("G", List.of());

        return map;
    }

    private Map<String, List<String>> getCyclicMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", List.of("B"));
        map.put("B", List.of("A"));


        return map;
    }

    private Map<String, List<String>> getCyclicMap2() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", List.of("B"));
        map.put("B", List.of("C"));
        map.put("C", List.of("B"));


        return map;
    }

    @Test
    public void testDAGCreation() throws Exception {

        Map<String, List<String>> map = getDefaultMap();

        DAG dag = new DAG(map);
        dag.printDAG();

        Assert.assertEquals(dag.getGraph().size(), map.size());
    }


    @Test
    public void testTopologicalSort() throws Exception {

        Map<String, List<String>> map = getDefaultMap();
        DAG dag = new DAG(map);

        // Assert if the course can be finished
        // Assert.assertTrue(dag.isTopologicalSortPossible());

        DAG dag2 = new DAG(getCyclicMap());
        Assert.assertFalse(dag2.isTopologicalSortPossible());


        DAG dag3 = new DAG(getCyclicMap2());
        Assert.assertFalse(dag3.isTopologicalSortPossible());

    }

}
