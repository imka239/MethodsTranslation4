// Generated from AntlrInfo.g4 by ANTLR 4.7.2
package main.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AntlrInfoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AntlrInfoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#gram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGram(AntlrInfoParser.GramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AntlrInfoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(AntlrInfoParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#unorule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnorule(AntlrInfoParser.UnoruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(AntlrInfoParser.ChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#attrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrs(AntlrInfoParser.AttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#legacy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLegacy(AntlrInfoParser.LegacyContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#syntez}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntez(AntlrInfoParser.SyntezContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(AntlrInfoParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AntlrInfoParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(AntlrInfoParser.TokenContext ctx);
}