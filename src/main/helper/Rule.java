package main.helper;

import java.util.List;

public class Rule {
    public final String from;
    public final List<String> to;

    public Rule(String from, List<String> to) {
        this.from = from;
        this.to = to;
    }
}
