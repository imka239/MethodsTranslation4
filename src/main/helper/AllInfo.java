package main.helper;

import java.util.*;

public final class AllInfo {

    private Map<String, Set<String>> first;
    private List<Leaf> leafs;
    private List<Node> nodes;

    public static String toName(String v) {
        return Character.toUpperCase(v.charAt(0)) + v.substring(1);
    }

    public void setFirst(Map<String, Set<String>> first) {
        this.first = first;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void setLeafs(List<Leaf> leafs) {
        this.leafs = leafs;
    }

    public Map<String, Set<String>> getFirst() {
        return first;
    }

    public List<Leaf> getLeafs() {
        return leafs;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
