expr ("public int res = 0;") ["expr.res = res + 1;"] : VAR IDENTIFIER COLON type SEMICOLON;
type ("public int res = 0;") ["type.res = res + 1;"] : ARRAY LESS type MORE
 | IDENTIFIER;

LESS : "<";
MORE : ">";
VAR : "var";
ARRAY : "Array";
IDENTIFIER : "[a-zA-Z_]+";
COLON : ":";
SEMICOLON : ";";