package main.helper;

import static main.helper.Templates.*;

public class LexerTemplate {
    public void print(AllInfo allInfo) {
        makeSource("Token", tokenTemplate);
        var leafsStr = new StringBuilder();
        allInfo.getLeafs().forEach(l -> leafsStr.append("map.put(Pattern.compile(\"(").append(l.regularExpression).append(").*\"), Leaf.").append(l.name).append(");\n"));
        makeSource("Lexer", String.format(lexerTemplate, leafsStr));
    }
}


