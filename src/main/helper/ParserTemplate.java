package main.helper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static main.helper.AllInfo.toName;
import static main.helper.Templates.makeSource;
import static main.helper.Templates.parserTemplate;

public class ParserTemplate {

    private int index = 0;

    public void print(AllInfo allInfo) {
        String nested = makeContent(allInfo);
        String functions = makeFunctions(allInfo);
        String result = nested + functions;
        String content = String.format(parserTemplate, result);
        makeSource("Parser", content);
    }

    private String makeContent(AllInfo allInfo) {
        ParserContent parserContent = new ParserContent();
        String contentNodes = allInfo.getNodes().stream().map(node -> parserContent.getNodesPrint(allInfo, node)).collect(Collectors.joining("\n\t"));
        String contentLeaves = allInfo.getLeafs().stream().map(parserContent::getLeavesPrint).collect(Collectors.joining("\n\t"));
        return contentNodes + "\n" + contentLeaves + "\n";
    }

    private String makeFunctions(AllInfo allInfo) {
        String nodeFunctions = allInfo.getNodes().stream().map(n -> makeFunctionNode(allInfo, n)).collect(Collectors.joining("\n\t")) + "\n\t";
        String leafFunctions = allInfo.getLeafs().stream().map(this::makeFunctionLeaf).collect(Collectors.joining("\n\t")) + "\n\t";
        return nodeFunctions + "\n" + leafFunctions;
    }

    private String makeFunctionLeaf(Leaf leaf) {
        String funTemplate = """
                    public %sContext parse%s() {
                        %sContext result =  new %sContext();
                        result.text = data.get(position++).text;
                        return result;
                    }
                """;
        String name = toName(leaf.name);
        return String.format(funTemplate, name, name, name, name);
    }

    private String makeFunctionNode(AllInfo allInfo, Node node) {
        String funTemplate = """
                    public %sContext parse%s() {
                        %s
                    }
                """;
        String name = toName(node.name);

        String content = makeFunctionContent(allInfo, node);

        return String.format(funTemplate, name, name, content);
    }


    private String makeFunctionContent(AllInfo allInfo, Node node) {
        index = 0;
        String resultType = toName(node.name);
        String switchTemplate = """
                switch(data.get(position).leaf) {
                    %s
                }
                %s
                """;
        String caseTemplate = """
                    case %s:
                        %sContext result%s = new %sContext();
                        %s
                        return result%s;
                """;
        StringBuilder builder = new StringBuilder();
        for (String termName : node.first) {
            if (!termName.equals("")) {
                builder.append(String.format(caseTemplate, termName, resultType, index, resultType, makeCaseForRule(allInfo, node, termName), index));
                index++;
            }
        }
        boolean needsException = false;
        if (node.first.contains("")) {
            processDefaultBlock(node, builder);
        } else {
            needsException = true;
        }
        String exception = needsException ? "throw new IllegalStateException(\"Unexpected token \" + data.get(position).leaf.name() + \" at position: \" + position);" : "";
        return String.format(switchTemplate, builder.toString(), exception);
    }

    private void processDefaultBlock(Node node, StringBuilder builder) {
        String defaultTemplate = """
                default:
                    %sContext result%s = new %sContext();
                    result%s.indexRule = %s;
                    return result%s;                    
                """;
        int number = 0;
        for (int i = 0; i < node.rules.size(); i++) {
            List<String> toList = node.rules.get(i).to;
            if (!toList.isEmpty() && toList.get(0).equals("")) {
                number = i;
                break;
            }
        }
        String name = toName(node.name);
        builder.append(String.format(defaultTemplate, name, index, name, index, number, index));
    }

    private String makeCaseForRule(AllInfo allInfo, Node node, String termName) {
        Rule nextRule = null;
        int number = 0;
        for (Rule rule : node.rules) {
            String nextStateName = rule.to.get(0);
            Set<String> firstByNextState = allInfo.getFirst().get(nextStateName);
            if (firstByNextState == null && nextStateName.equals(termName)) {
                nextRule = rule;
                break;
            }
            if (firstByNextState != null && firstByNextState.contains(termName)) {
                nextRule = rule;
                break;
            }
            number++;
        }
        if (nextRule == null) {
            throw new IllegalStateException("null");
        }
        String settingNumber = "result" + index + ".indexRule = " + number + ";\n";
        return settingNumber + nextRule.to.stream().map(toRuleName -> {
            Integer count = node.fieldCounter.get(toRuleName);
            if (count == null || count == 1) {
                return "result" + index + "." + toRuleName + " = parse" + toName(toRuleName) + "();";
            } else {
                return "result" + index + "." + toRuleName + ".add(parse" + toName(toRuleName) + "());";
            }
        }).collect(Collectors.joining("\n"));
    }
}
