package main.generator;

import main.antlr4.gen.AntlrInfoLexer;
import main.antlr4.gen.AntlrInfoParser;

import java.io.*;

import main.helper.LeafTemplate;
import main.helper.LexerTemplate;
import main.helper.ParserTemplate;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String data;
        try (InputStream is = new FileInputStream(args[0])) {
            data = new String(is.readAllBytes());
        }
        System.out.println(data);
        var lexer = new AntlrInfoLexer(CharStreams.fromString(data));
        TokenStream tokens = new CommonTokenStream(lexer);
        AntlrInfoParser parser = new AntlrInfoParser(tokens);
        var gram = new AntrInfoVisitor().generate(parser.gram());

        new LeafTemplate().print(gram);
        new LexerTemplate().print(gram);
        new ParserTemplate().print(gram);
    }
}
