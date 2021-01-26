grammar AntlrInfo;

gram : expression* token*;

expression : NODE attrs? legacy? COLON rules;

rules: unorule ( OR unorule )* (OR EPS)? SEMICOMMA;
unorule: chain syntez?;

chain: name+;

attrs: L1 REGEX R1;
legacy: L2 REGEX R2;
syntez: L3 REGEX R3;
name : LEAF | NODE;
token: LEAF syntez? legacy? COLON REGEX SEMICOMMA;


REGEX : '"'.+?'"';
NODE : [a-z_]+;
LEAF : [A-Z]+;
WHITESPACE : [ \t\r\n]+ -> skip;

L1 : '(';
R1 : ')';
L2 : '[';
R2 : ']';
L3: '{';
R3: '}';
COLON : ':';
SEMICOMMA : ';';
OR : '|';
EPS: '@';
