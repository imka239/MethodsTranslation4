package main.generator;

import gen.Lexer;
import gen.Parser;
import gen.Token;

import java.util.List;

public class TesterCalc {
    public static void main(String[] args) {
        String input = "6/3*2*(4-1)";
        Lexer lexerS = new Lexer(input);

        List<Token> tokenList = lexerS.parseAll();
        System.out.println(tokenList);
        var exprContext = new Parser(tokenList).parseExpr();
        exprContext.process();
        System.out.println(exprContext.res);
    }
}
