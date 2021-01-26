package main.generator;

import main.antlr4.gen.AntlrInfoParser;
import main.helper.AllInfo;
import main.helper.Leaf;
import main.helper.Node;
import main.helper.Rule;
import org.antlr.v4.runtime.RuleContext;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AntrInfoVisitor {

    private List<String> code;

    private Leaf getLeaf(AntlrInfoParser.TokenContext context) {
        String name = context.LEAF().getText();
        return new Leaf(name, context.REGEX().getText().substring(1, context.REGEX().getText().length() - 1));
    }

    private Rule parseOneRule(String name, AntlrInfoParser.UnoruleContext context) {
        if (context.syntez() != null) {
            code.add(context.syntez().REGEX().getText());
        }
        return new Rule(name, context.chain().name().stream()
                .map(RuleContext::getText)
                .collect(Collectors.toList()));
    }

    private List<Rule> visitDeclaration(String name, AntlrInfoParser.RulesContext rulesContext) {
        return rulesContext.unorule().stream().map(x -> parseOneRule(name, x)).collect(Collectors.toList());
    }

    private Node getNode(AntlrInfoParser.ExpressionContext expressionContext) {
        String name = expressionContext.NODE().getText();
        code = new ArrayList<>();
        List<Rule> rules = visitDeclaration(name, expressionContext.rules());
        code = code.stream().map(x -> x.substring(1, x.length() - 1)).collect(Collectors.toList());
        AntlrInfoParser.AttrsContext attrsContext = expressionContext.attrs();
        String init = "";
        if (attrsContext != null && attrsContext.REGEX() != null) {
            init = attrsContext.REGEX().getText().substring(1, attrsContext.REGEX().getText().length() - 1);
        }
        AntlrInfoParser.LegacyContext legacyContext = expressionContext.legacy();
        String legacyCode = "";
        if (legacyContext != null) {
            legacyCode = legacyContext.REGEX().getText().substring(1, legacyContext.REGEX().getText().length() - 1);
        }
        Node node = new Node(name, init, rules, code, legacyCode);
        if (expressionContext.rules().EPS() != null) {
            node.canBeEmpty = true;
            rules.add(new Rule(name, List.of("")));
        }
        return node;
    }

    public AllInfo generate(AntlrInfoParser.GramContext context) {
        List<Leaf> leafs = context.token().stream().map(this::getLeaf).collect(Collectors.toList());
        List<Node> nodes = context.expression().stream().map(this::getNode).collect(Collectors.toList());
        var allInfo = new AllInfo();
        allInfo.setLeafs(leafs);
        allInfo.setNodes(nodes);
        return setFirstAndFollow(allInfo);
    }

    private AllInfo setFirstAndFollow(AllInfo allInfo) {

        Map<String, Set<String>> first = new HashMap<>();
        List<Rule> rules = allInfo.getNodes().stream().flatMap(node -> node.rules.stream()).collect(Collectors.toList());

        setFirst(allInfo, first, rules);

        allInfo.setFirst(first);

        for (Node node: allInfo.getNodes()) {
            String name = node.name;
            node.first = first.get(name);
        }

        return allInfo;
    }

    private void setFirst(AllInfo allInfo, Map<String, Set<String>> first, List<Rule> rules) {
        Predicate<String> isLeaf = (data) -> allInfo.getLeafs().stream().anyMatch(d -> d.name.equals(data)) || data.equals("");
        allInfo.getNodes().forEach(node -> first.put(node.name, new HashSet<>()));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (Rule currentRule : rules) {
                Set<String> nowSet = first.get(currentRule.from);
                if (!currentRule.to.isEmpty()) {
                    String nextRuleName = currentRule.to.get(0);
                    if (isLeaf.test(nextRuleName)) {
                        if (!nowSet.contains(nextRuleName)) {
                            flag = true;
                            nowSet.add(nextRuleName);
                        }
                    } else {
                        Set<String> newSet = first.get(nextRuleName);
                        boolean result = nowSet.addAll(newSet);
                        if (result) {
                            flag = true;
                        }
                    }
                }
            }
        }
    }
}
