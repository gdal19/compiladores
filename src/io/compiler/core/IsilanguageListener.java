// Generated from Isilanguage.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import io.compiler.runtime.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsilanguageParser}.
 */
public interface IsilanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(IsilanguageParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(IsilanguageParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#declarar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarar(IsilanguageParser.DeclararContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#declarar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarar(IsilanguageParser.DeclararContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(IsilanguageParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(IsilanguageParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdAtributo}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtributo(IsilanguageParser.CmdAtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdAtributo}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtributo(IsilanguageParser.CmdAtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(IsilanguageParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(IsilanguageParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(IsilanguageParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(IsilanguageParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(IsilanguageParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(IsilanguageParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(IsilanguageParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(IsilanguageParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(IsilanguageParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(IsilanguageParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(IsilanguageParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(IsilanguageParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#exp1}.
	 * @param ctx the parse tree
	 */
	void enterExp1(IsilanguageParser.Exp1Context ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#exp1}.
	 * @param ctx the parse tree
	 */
	void exitExp1(IsilanguageParser.Exp1Context ctx);
	/**
	 * Enter a parse tree produced by {@link IsilanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsilanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsilanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsilanguageParser.TermoContext ctx);
}