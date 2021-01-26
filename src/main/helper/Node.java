package main.helper;

import java.util.*;

public class Node {
    public Set<String> first = new HashSet<>();
    public final String initVariables;
    public final String name;
    public final List<Rule> rules;
    public final List<String> rulesCode;
    public final String legacyCode;
    public boolean canBeEmpty = false;
    public final Map<String, Integer> fieldCounter;

    public Node(String name, String initVariables, List<Rule> rules, List<String> rulesCode, String legacyCode) {
        this.initVariables = initVariables;
        this.rules = rules;
        this.name = name;
        this.rulesCode = rulesCode;
        this.legacyCode = legacyCode;
        fieldCounter = new HashMap<>();
        for (Rule rule : rules) {
            var tempMap = new HashMap<String, Integer>();
            for (String ruleName : rule.to) {
                tempMap.merge(ruleName, 1, Integer::sum);
            }
            for (Map.Entry<String, Integer> entry: tempMap.entrySet()) {
                fieldCounter.merge(entry.getKey(), entry.getValue(), Math::max);
            }
        }
    }
}
