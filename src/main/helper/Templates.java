package main.helper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Templates {

    public static void makeSource(String fileName, String data) {
        try {
            Files.createFile(Path.of("src\\gen\\" +fileName + ".java"));
        } catch (IOException ignored) {
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("src\\gen\\" +fileName + ".java"))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String tokenTemplate = """
                package gen;
                public class Token {
                    public Leaf leaf;
                    public String text = "";
                                
                    public Token(Leaf leaf, String text) {
                        this.leaf = leaf;
                        this.text = text;
                    }
                                
                    public Token(Leaf leaf) {
                        this.leaf = leaf;
                    }
                               
                    public String toString() {
                        return leaf.name() + " : text";
                    }
                }    
                """;

    static String enumTemplate = """
                 package gen;
                 
                 enum Leaf{
                    %s END
                }
                """;

    static String parserTemplate = """
            package gen;
            import java.util.*;
            
            public class Parser {
                private int position = 0;
                private List<Token> data;
                public Parser(List<Token> data) {
                    this.data = data;
                }
                %s
            }
            """;

    static String lexerTemplate = """
                package gen;
                                
                import java.util.*;
                import java.util.regex.Matcher;
                import java.util.regex.Pattern;
                                
                public class Lexer {
                    private String data;
                    private final Map<Pattern, Leaf> map;
                                
                    public Lexer(String data) {
                        this.data = data.replaceAll("[ \\n\\t]", "");
                        map = new LinkedHashMap<>();
                        %s
                    }
                                
                    public List<Token> parseAll() {
                        List<Token> tokens = new ArrayList<>();
                        while (true) {
                            Token current = getToken();
                            tokens.add(current);
                            if (current.leaf == Leaf.END) {
                                return tokens;
                            }
                        }
                    }
                                
                    private Token getToken() {
                        if (data.isEmpty()) {
                            return new Token(Leaf.END);
                        }
                        for (Map.Entry<Pattern, Leaf> entry : map.entrySet()) {
                            Pattern pat = entry.getKey();
                            Leaf leaf = entry.getValue();
                            Matcher matcher = pat.matcher(data);
                            if (matcher.matches() && !matcher.group().isEmpty()) {
                                String result = matcher.group(1);
                                int len = result.length();
                                if (len < data.length()) {
                                    data = data.substring(len);
                                } else {
                                    data = "";
                                }
                                return new Token(leaf, result);
                            }
                        } 
                        return new Token(Leaf.END);
                    }      
                }        
                """;
}
