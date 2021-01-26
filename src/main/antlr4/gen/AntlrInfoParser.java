// Generated from AntlrInfo.g4 by ANTLR 4.7.2
package main.antlr4.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrInfoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		REGEX=1, NODE=2, LEAF=3, WHITESPACE=4, L1=5, R1=6, L2=7, R2=8, L3=9, R3=10, 
		COLON=11, SEMICOMMA=12, OR=13, EPS=14;
	public static final int
		RULE_gram = 0, RULE_expression = 1, RULE_rules = 2, RULE_unorule = 3, 
		RULE_chain = 4, RULE_attrs = 5, RULE_legacy = 6, RULE_syntez = 7, RULE_name = 8, 
		RULE_token = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"gram", "expression", "rules", "unorule", "chain", "attrs", "legacy", 
			"syntez", "name", "token"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"':'", "';'", "'|'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "REGEX", "NODE", "LEAF", "WHITESPACE", "L1", "R1", "L2", "R2", 
			"L3", "R3", "COLON", "SEMICOMMA", "OR", "EPS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AntlrInfo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AntlrInfoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GramContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitGram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NODE) {
				{
				{
				setState(20);
				expression();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEAF) {
				{
				{
				setState(26);
				token();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode NODE() { return getToken(AntlrInfoParser.NODE, 0); }
		public TerminalNode COLON() { return getToken(AntlrInfoParser.COLON, 0); }
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public AttrsContext attrs() {
			return getRuleContext(AttrsContext.class,0);
		}
		public LegacyContext legacy() {
			return getRuleContext(LegacyContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(NODE);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L1) {
				{
				setState(33);
				attrs();
				}
			}

			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L2) {
				{
				setState(36);
				legacy();
				}
			}

			setState(39);
			match(COLON);
			setState(40);
			rules();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RulesContext extends ParserRuleContext {
		public List<UnoruleContext> unorule() {
			return getRuleContexts(UnoruleContext.class);
		}
		public UnoruleContext unorule(int i) {
			return getRuleContext(UnoruleContext.class,i);
		}
		public TerminalNode SEMICOMMA() { return getToken(AntlrInfoParser.SEMICOMMA, 0); }
		public List<TerminalNode> OR() { return getTokens(AntlrInfoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(AntlrInfoParser.OR, i);
		}
		public TerminalNode EPS() { return getToken(AntlrInfoParser.EPS, 0); }
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			unorule();
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					match(OR);
					setState(44);
					unorule();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(50);
				match(OR);
				setState(51);
				match(EPS);
				}
			}

			setState(54);
			match(SEMICOMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnoruleContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public SyntezContext syntez() {
			return getRuleContext(SyntezContext.class,0);
		}
		public UnoruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unorule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitUnorule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnoruleContext unorule() throws RecognitionException {
		UnoruleContext _localctx = new UnoruleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_unorule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			chain();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L3) {
				{
				setState(57);
				syntez();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChainContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				name();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NODE || _la==LEAF );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrsContext extends ParserRuleContext {
		public TerminalNode L1() { return getToken(AntlrInfoParser.L1, 0); }
		public TerminalNode REGEX() { return getToken(AntlrInfoParser.REGEX, 0); }
		public TerminalNode R1() { return getToken(AntlrInfoParser.R1, 0); }
		public AttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitAttrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrsContext attrs() throws RecognitionException {
		AttrsContext _localctx = new AttrsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attrs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(L1);
			setState(66);
			match(REGEX);
			setState(67);
			match(R1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LegacyContext extends ParserRuleContext {
		public TerminalNode L2() { return getToken(AntlrInfoParser.L2, 0); }
		public TerminalNode REGEX() { return getToken(AntlrInfoParser.REGEX, 0); }
		public TerminalNode R2() { return getToken(AntlrInfoParser.R2, 0); }
		public LegacyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_legacy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitLegacy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LegacyContext legacy() throws RecognitionException {
		LegacyContext _localctx = new LegacyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_legacy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(L2);
			setState(70);
			match(REGEX);
			setState(71);
			match(R2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SyntezContext extends ParserRuleContext {
		public TerminalNode L3() { return getToken(AntlrInfoParser.L3, 0); }
		public TerminalNode REGEX() { return getToken(AntlrInfoParser.REGEX, 0); }
		public TerminalNode R3() { return getToken(AntlrInfoParser.R3, 0); }
		public SyntezContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntez; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitSyntez(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntezContext syntez() throws RecognitionException {
		SyntezContext _localctx = new SyntezContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_syntez);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(L3);
			setState(74);
			match(REGEX);
			setState(75);
			match(R3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode LEAF() { return getToken(AntlrInfoParser.LEAF, 0); }
		public TerminalNode NODE() { return getToken(AntlrInfoParser.NODE, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==NODE || _la==LEAF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode LEAF() { return getToken(AntlrInfoParser.LEAF, 0); }
		public TerminalNode COLON() { return getToken(AntlrInfoParser.COLON, 0); }
		public TerminalNode REGEX() { return getToken(AntlrInfoParser.REGEX, 0); }
		public TerminalNode SEMICOMMA() { return getToken(AntlrInfoParser.SEMICOMMA, 0); }
		public SyntezContext syntez() {
			return getRuleContext(SyntezContext.class,0);
		}
		public LegacyContext legacy() {
			return getRuleContext(LegacyContext.class,0);
		}
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AntlrInfoVisitor ) return ((AntlrInfoVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(LEAF);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L3) {
				{
				setState(80);
				syntez();
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L2) {
				{
				setState(83);
				legacy();
				}
			}

			setState(86);
			match(COLON);
			setState(87);
			match(REGEX);
			setState(88);
			match(SEMICOMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\5"+
		"\3%\n\3\3\3\5\3(\n\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\5\4\67\n\4\3\4\3\4\3\5\3\5\5\5=\n\5\3\6\6\6@\n\6\r\6\16\6A"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\5\13"+
		"T\n\13\3\13\5\13W\n\13\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20"+
		"\22\24\2\3\3\2\4\5\2\\\2\31\3\2\2\2\4\"\3\2\2\2\6,\3\2\2\2\b:\3\2\2\2"+
		"\n?\3\2\2\2\fC\3\2\2\2\16G\3\2\2\2\20K\3\2\2\2\22O\3\2\2\2\24Q\3\2\2\2"+
		"\26\30\5\4\3\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2"+
		"\32\37\3\2\2\2\33\31\3\2\2\2\34\36\5\24\13\2\35\34\3\2\2\2\36!\3\2\2\2"+
		"\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"$\7\4\2\2#%\5\f\7\2"+
		"$#\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&(\5\16\b\2\'&\3\2\2\2\'(\3\2\2\2()\3\2"+
		"\2\2)*\7\r\2\2*+\5\6\4\2+\5\3\2\2\2,\61\5\b\5\2-.\7\17\2\2.\60\5\b\5\2"+
		"/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\66\3\2\2\2\63\61"+
		"\3\2\2\2\64\65\7\17\2\2\65\67\7\20\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		"8\3\2\2\289\7\16\2\29\7\3\2\2\2:<\5\n\6\2;=\5\20\t\2<;\3\2\2\2<=\3\2\2"+
		"\2=\t\3\2\2\2>@\5\22\n\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\13\3"+
		"\2\2\2CD\7\7\2\2DE\7\3\2\2EF\7\b\2\2F\r\3\2\2\2GH\7\t\2\2HI\7\3\2\2IJ"+
		"\7\n\2\2J\17\3\2\2\2KL\7\13\2\2LM\7\3\2\2MN\7\f\2\2N\21\3\2\2\2OP\t\2"+
		"\2\2P\23\3\2\2\2QS\7\5\2\2RT\5\20\t\2SR\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW"+
		"\5\16\b\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\r\2\2YZ\7\3\2\2Z[\7\16\2\2"+
		"[\25\3\2\2\2\f\31\37$\'\61\66<ASV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}