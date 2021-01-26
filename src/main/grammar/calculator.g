expr ("public double res = 0.0;") : term addsub {"res = term.res + addsub.res;"};
addsub ("public double res = 0.0; ") : PLUS term addsub {"res = term.res + addsub.res;"}
 | MINUS term addsub {"res = -term.res + addsub.res;"}
 | @;

term ("public double res = 1.0; ") : value muldiv {"res = value.res * muldiv.res;"};
muldiv ("public double res = 1.0; ")  : MULT value muldiv {"res = value.res * muldiv.res;"}
 | DIV value muldiv {"res = 1 / value.res * muldiv.res;"}
 | @;

value ("public double res = 0.0; ") : NUMBER {"res = Integer.parseInt(NUMBER.text);"}
| MINUS expr {"res = -expr.res;"}
| LP expr RP {"res = expr.res;"};

NUMBER : "[0-9]+";
PLUS : "\\+";
MINUS : "-";
MULT : "\\*";
DIV : "/";
LP : "\\(";
RP : "\\)";