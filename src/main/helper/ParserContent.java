package main.helper;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.helper.AllInfo.toName;


public class ParserContent {

    public String getNodesPrint(AllInfo allInfo, Node node) {
        String template = """
                    public static class %sContext {   
                        private int indexRule = -1;
                        public String text;
                        %s
                        public void process() {
                            %s
                        }
                    }
                """;
        String name = toName(node.name);
        String declaration = node.initVariables;
        String fields = makeFields(node);
        return String.format(template, name, declaration + "\n" + fields, makeProcess(allInfo, node));
    }

    private String makeProcess(AllInfo allInfo, Node node) {
        StringBuilder calling = new StringBuilder();
        for (Map.Entry<String, Integer> e : node.fieldCounter.entrySet()) {
            String name = e.getKey();
            if (allInfo.getLeafs().stream().anyMatch(l -> l.name.equals(name))) {
                continue;
            }
            if (e.getValue() == 1) {
                calling.append("if (").append(name).append(" != null) {\n");
                calling.append(makeExtendedCode(allInfo, name)).append("\n");
                calling.append(name).append(".process(); \n}\n");
            } else {
                calling.append(name).append(".stream()\n.filter(Object::notNull)\n.forEach(x -> x.process());\n");
            }
        }

        String switchTemplate = """
                switch(indexRule) {
                    %s
                }
                """;
        String caseTemplate = """
                case %s:
                    %s
                    break;
                """;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < node.rulesCode.size(); i++) {
            builder.append(String.format(caseTemplate, i, node.rulesCode.get(i)));
        }
        return calling.toString() + String.format(switchTemplate, builder.toString()) + "\n";
    }

    private String makeExtendedCode(AllInfo allInfo, String name) {
        Optional<Node> child = allInfo.getNodes().stream().filter(node -> node.name.equals(name)).findFirst();
        if (child.isPresent()) {
            return child.get().legacyCode;
        } else {
            return "";
        }
    }

    private String makeFields(Node node) {
        return node.fieldCounter.entrySet().stream().map(e -> {
            String name = e.getKey();
            Integer count = e.getValue();
            return count == 1 ? "public " + toName(name) + "Context " + name + ";\n" : "private List<" + toName(name) + "Context>" + name + "= new ArrayList<>();\n";
        }).collect(Collectors.joining());
    }

    public String getLeavesPrint(Leaf leaf) {
        String template = """
                    public static class %sContext {
                    
                        public String text;
                    
                    }
                """;
        String name = toName(leaf.name);
        return String.format(template, name);
    }

}
