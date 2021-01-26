package gen;
import java.util.*;

public class Parser {
    private int position = 0;
    private List<Token> data;
    public Parser(List<Token> data) {
        this.data = data;
    }
        public static class ExprContext {
        private int indexRule = -1;
        public String text;
        public double res = 0.0;
public AddsubContext addsub;
public TermContext term;

        public void process() {
            if (addsub != null) {

addsub.process(); 
}
if (term != null) {

term.process(); 
}
switch(indexRule) {
    case 0:
    res = term.res + addsub.res;
    break;

}


        }
    }

	    public static class AddsubContext {
        private int indexRule = -1;
        public String text;
        public double res = 0.0; 
public AddsubContext addsub;
public TermContext term;
public MINUSContext MINUS;
public PLUSContext PLUS;

        public void process() {
            if (addsub != null) {

addsub.process(); 
}
if (term != null) {

term.process(); 
}
switch(indexRule) {
    case 0:
    res = term.res + addsub.res;
    break;
case 1:
    res = -term.res + addsub.res;
    break;

}


        }
    }

	    public static class TermContext {
        private int indexRule = -1;
        public String text;
        public double res = 1.0; 
public ValueContext value;
public MuldivContext muldiv;

        public void process() {
            if (value != null) {

value.process(); 
}
if (muldiv != null) {

muldiv.process(); 
}
switch(indexRule) {
    case 0:
    res = value.res * muldiv.res;
    break;

}


        }
    }

	    public static class MuldivContext {
        private int indexRule = -1;
        public String text;
        public double res = 1.0; 
public DIVContext DIV;
public MULTContext MULT;
public ValueContext value;
public MuldivContext muldiv;

        public void process() {
            if (value != null) {

value.process(); 
}
if (muldiv != null) {

muldiv.process(); 
}
switch(indexRule) {
    case 0:
    res = value.res * muldiv.res;
    break;
case 1:
    res = 1 / value.res * muldiv.res;
    break;

}


        }
    }

	    public static class ValueContext {
        private int indexRule = -1;
        public String text;
        public double res = 0.0; 
public NUMBERContext NUMBER;
public LPContext LP;
public ExprContext expr;
public RPContext RP;
public MINUSContext MINUS;

        public void process() {
            if (expr != null) {

expr.process(); 
}
switch(indexRule) {
    case 0:
    res = Integer.parseInt(NUMBER.text);
    break;
case 1:
    res = -expr.res;
    break;
case 2:
    res = expr.res;
    break;

}


        }
    }

    public static class NUMBERContext {

        public String text;

    }

	    public static class PLUSContext {

        public String text;

    }

	    public static class MINUSContext {

        public String text;

    }

	    public static class MULTContext {

        public String text;

    }

	    public static class DIVContext {

        public String text;

    }

	    public static class LPContext {

        public String text;

    }

	    public static class RPContext {

        public String text;

    }

    public ExprContext parseExpr() {
        switch(data.get(position).leaf) {
        case NUMBER:
        ExprContext result0 = new ExprContext();
        result0.indexRule = 0;
result0.term = parseTerm();
result0.addsub = parseAddsub();
        return result0;
    case LP:
        ExprContext result1 = new ExprContext();
        result1.indexRule = 0;
result1.term = parseTerm();
result1.addsub = parseAddsub();
        return result1;
    case MINUS:
        ExprContext result2 = new ExprContext();
        result2.indexRule = 0;
result2.term = parseTerm();
result2.addsub = parseAddsub();
        return result2;

}
throw new IllegalStateException("Unexpected token " + data.get(position).leaf.name() + " at position: " + position);

    }

	    public AddsubContext parseAddsub() {
        switch(data.get(position).leaf) {
        case PLUS:
        AddsubContext result0 = new AddsubContext();
        result0.indexRule = 0;
result0.PLUS = parsePLUS();
result0.term = parseTerm();
result0.addsub = parseAddsub();
        return result0;
    case MINUS:
        AddsubContext result1 = new AddsubContext();
        result1.indexRule = 1;
result1.MINUS = parseMINUS();
result1.term = parseTerm();
result1.addsub = parseAddsub();
        return result1;
default:
    AddsubContext result2 = new AddsubContext();
    result2.indexRule = 2;
    return result2;

}


    }

	    public TermContext parseTerm() {
        switch(data.get(position).leaf) {
        case NUMBER:
        TermContext result0 = new TermContext();
        result0.indexRule = 0;
result0.value = parseValue();
result0.muldiv = parseMuldiv();
        return result0;
    case LP:
        TermContext result1 = new TermContext();
        result1.indexRule = 0;
result1.value = parseValue();
result1.muldiv = parseMuldiv();
        return result1;
    case MINUS:
        TermContext result2 = new TermContext();
        result2.indexRule = 0;
result2.value = parseValue();
result2.muldiv = parseMuldiv();
        return result2;

}
throw new IllegalStateException("Unexpected token " + data.get(position).leaf.name() + " at position: " + position);

    }

	    public MuldivContext parseMuldiv() {
        switch(data.get(position).leaf) {
        case DIV:
        MuldivContext result0 = new MuldivContext();
        result0.indexRule = 1;
result0.DIV = parseDIV();
result0.value = parseValue();
result0.muldiv = parseMuldiv();
        return result0;
    case MULT:
        MuldivContext result1 = new MuldivContext();
        result1.indexRule = 0;
result1.MULT = parseMULT();
result1.value = parseValue();
result1.muldiv = parseMuldiv();
        return result1;
default:
    MuldivContext result2 = new MuldivContext();
    result2.indexRule = 2;
    return result2;

}


    }

	    public ValueContext parseValue() {
        switch(data.get(position).leaf) {
        case NUMBER:
        ValueContext result0 = new ValueContext();
        result0.indexRule = 0;
result0.NUMBER = parseNUMBER();
        return result0;
    case LP:
        ValueContext result1 = new ValueContext();
        result1.indexRule = 2;
result1.LP = parseLP();
result1.expr = parseExpr();
result1.RP = parseRP();
        return result1;
    case MINUS:
        ValueContext result2 = new ValueContext();
        result2.indexRule = 1;
result2.MINUS = parseMINUS();
result2.expr = parseExpr();
        return result2;

}
throw new IllegalStateException("Unexpected token " + data.get(position).leaf.name() + " at position: " + position);

    }

	
    public NUMBERContext parseNUMBER() {
        NUMBERContext result =  new NUMBERContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public PLUSContext parsePLUS() {
        PLUSContext result =  new PLUSContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public MINUSContext parseMINUS() {
        MINUSContext result =  new MINUSContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public MULTContext parseMULT() {
        MULTContext result =  new MULTContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public DIVContext parseDIV() {
        DIVContext result =  new DIVContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public LPContext parseLP() {
        LPContext result =  new LPContext();
        result.text = data.get(position++).text;
        return result;
    }

	    public RPContext parseRP() {
        RPContext result =  new RPContext();
        result.text = data.get(position++).text;
        return result;
    }

	
}
