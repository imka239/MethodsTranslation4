package main.generator;

import gen.Lexer;
import gen.Parser;
import gen.Token;

import java.util.List;

public class TesterSnd {
    public static void main(String[] args) {
        String input = "var x: Array<Array<INt>>";
        Lexer lexerS = new Lexer(input);

        List<Token> tokenList = lexerS.parseAll();
        System.out.println(tokenList);
        var exprContext = new Parser(tokenList).parseExpr();
        exprContext.process();
        System.out.println(exprContext.res);
    }
}
