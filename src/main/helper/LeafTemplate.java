package main.helper;

import java.util.List;

import static main.helper.Templates.*;


public class LeafTemplate {

    public void print(AllInfo allInfo) {
        List<Leaf> leafs = allInfo.getLeafs();
        var leafsStr = new StringBuilder();
        leafs.forEach(l -> leafsStr.append(l.name.toUpperCase()).append(','));
        makeSource("Leaf", String.format(enumTemplate, leafsStr));
    }
}
