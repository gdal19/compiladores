// Generated from Isilanguage.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import io.compiler.runtime.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsilanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ID=13, PV=14, OP=15, DP=16, VIRG=17, IGUAL=18, 
		AC=19, FC=20, ACH=21, FCH=22, OPREL=23, INT=24, FLOAT=25, TEXT=26, WS=27;
	public static final int
		RULE_programa = 0, RULE_declarar = 1, RULE_comando = 2, RULE_cmdAtributo = 3, 
		RULE_cmdLeitura = 4, RULE_cmdEscrita = 5, RULE_cmdIf = 6, RULE_cmdWhile = 7, 
		RULE_cmdDoWhile = 8, RULE_exp = 9, RULE_exp1 = 10, RULE_termo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declarar", "comando", "cmdAtributo", "cmdLeitura", "cmdEscrita", 
			"cmdIf", "cmdWhile", "cmdDoWhile", "exp", "exp1", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'inicio'", "'fim'", "'declaro'", "'int'", "'float'", "'text'", 
			"'ler'", "'emitir'", "'se'", "'senao'", "'enquanto'", "'faca'", null, 
			"';'", null, "':'", "','", "'->'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "PV", "OP", "DP", "VIRG", "IGUAL", "AC", "FC", "ACH", "FCH", 
			"OPREL", "INT", "FLOAT", "TEXT", "WS"
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
	public String getGrammarFileName() { return "Isilanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private HashMap<String, Var> symbolTable = new HashMap<String, Var>();
		private ArrayList<Var> declAtual = new ArrayList<Var>();
		private Types tipoAtual;
		private Types tipoEsq = null, tipoDir = null, tipoOpr = null;
		private Program programa = new Program();
		private IfCommand comandoAtualIf;
		private WhileCommand comandoAtualWhile;
		private DoWhileCommand comandoAtualDoWhile;
		private String strExpr = "";
		
		private Stack<ArrayList<Command>> pilha = new Stack<ArrayList<Command>>(); 
		private Stack<ArrayList<Command>> pilhaSenao = new Stack<ArrayList<Command>>(); 
		
		private Stack<AbstractExpression> pilhaExp = new Stack<AbstractExpression>();
		private AbstractExpression topo = null; 
		
		public void atzTipo(){
			for(Var v: declAtual){
				v.setType(tipoAtual);
				symbolTable.put(v.getId(), v);
			}
		}
		
		
		public void exibirVar() {
			for (String id: symbolTable.keySet()) {
				System.out.println(symbolTable.get(id));
			}
		}
		
		
		public boolean isDeclared(String id){
			return symbolTable.get(id) != null;
		}	
		
		public Program getProgram(){
			return this.programa;
		}
		
		public double generateValue(){
			if (topo == null){
				topo = pilhaExp.pop();
			}
			return topo.evaluate();
		}
		
		public String generateJSON(){
			if (topo == null){
				topo = pilhaExp.pop();
			}
			return topo.toJson();
		}

	public IsilanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public List<DeclararContext> declarar() {
			return getRuleContexts(DeclararContext.class);
		}
		public DeclararContext declarar(int i) {
			return getRuleContext(DeclararContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(ID);
			 programa.setName(_input.LT(-1).getText()); 
								       pilha.push(new ArrayList<Command>());
								     
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declarar();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15232L) != 0)) {
				{
				{
				setState(32);
				comando();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(T__1);
			setState(39);
			match(PV);

							programa.setSymbolTable(symbolTable);
							programa.setCommandList(pilha.pop());
						
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclararContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsilanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsilanguageParser.ID, i);
		}
		public TerminalNode DP() { return getToken(IsilanguageParser.DP, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(IsilanguageParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(IsilanguageParser.VIRG, i);
		}
		public DeclararContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterDeclarar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitDeclarar(this);
		}
	}

	public final DeclararContext declarar() throws RecognitionException {
		DeclararContext _localctx = new DeclararContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			 declAtual.clear(); 
			setState(44);
			match(ID);
			 declAtual.add(new Var(_input.LT(-1).getText()));
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(46);
				match(VIRG);
				setState(47);
				match(ID);
				 declAtual.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(DP);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(55);
				match(T__3);
				tipoAtual = Types.INT;
				}
				break;
			case T__4:
				{
				setState(57);
				match(T__4);
				tipoAtual = Types.FLOAT;
				}
				break;
			case T__5:
				{
				setState(59);
				match(T__5);
				tipoAtual = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			atzTipo();
			setState(64);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAtributoContext cmdAtributo() {
			return getRuleContext(CmdAtributoContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdAtributo();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdIf();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdWhile();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdDoWhile();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtributoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(IsilanguageParser.IGUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public CmdAtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdAtributo(this);
		}
	}

	public final CmdAtributoContext cmdAtributo() throws RecognitionException {
		CmdAtributoContext _localctx = new CmdAtributoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdAtributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
									throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
								}
								symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
								tipoEsq = symbolTable.get(_input.LT(-1).getText()).getType();
							
			setState(76);
			match(IGUAL);
			setState(77);
			exp();
			setState(78);
			match(PV);
			 System.out.println("Tipo da expressao na esquerda = "+tipoEsq);
			              System.out.println("Tipo da expressao na direita = "+tipoDir);
			              if (tipoEsq.getValue() < tipoDir.getValue()){
			              	throw new SemanticException("Tipos incompativeis na atribuicao");
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(IsilanguageParser.AC, 0); }
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
		public TerminalNode FC() { return getToken(IsilanguageParser.FC, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__6);
			setState(82);
			match(AC);
			setState(83);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
									throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
								}
								symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
								Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
								pilha.peek().add(cmdRead);
							
			setState(85);
			match(FC);
			setState(86);
			match(PV);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(IsilanguageParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsilanguageParser.FC, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__7);
			setState(89);
			match(AC);
			{
			setState(90);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
								  pilha.peek().add(cmdWrite);
								
			}
			setState(93);
			match(FC);
			setState(94);
			match(PV);
			 tipoDir = null;
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(IsilanguageParser.AC, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsilanguageParser.OPREL, 0); }
		public TerminalNode FC() { return getToken(IsilanguageParser.FC, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsilanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsilanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsilanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsilanguageParser.FCH, i);
		}
		public List<TerminalNode> PV() { return getTokens(IsilanguageParser.PV); }
		public TerminalNode PV(int i) {
			return getToken(IsilanguageParser.PV, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__8);
			 pilha.push(new ArrayList<Command>());
							   	 strExpr = "";
							   	 comandoAtualIf = new IfCommand();
							   
			setState(99);
			match(AC);
			setState(100);
			exp();
			setState(101);
			match(OPREL);
			strExpr += _input.LT(-1).getText();
			setState(103);
			exp();
			setState(104);
			match(FC);
			comandoAtualIf.setExpression(strExpr);
			setState(106);
			match(ACH);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				comando();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15232L) != 0) );
			comandoAtualIf.setTrueList(pilha.pop());
						
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(113);
				match(T__9);
				pilha.push(new ArrayList<Command>());
				setState(115);
				match(ACH);
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116);
					comando();
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15232L) != 0) );
				 
							comandoAtualIf.setFalseList(pilha.pop());
							
				setState(122);
				match(FCH);
				setState(123);
				match(PV);
				}
			}

			setState(127);
			match(FCH);
			setState(128);
			match(PV);
			 pilha.peek().add(comandoAtualIf); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(IsilanguageParser.AC, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsilanguageParser.OPREL, 0); }
		public TerminalNode FC() { return getToken(IsilanguageParser.FC, 0); }
		public TerminalNode ACH() { return getToken(IsilanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsilanguageParser.FCH, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__10);
			 pilha.push(new ArrayList<Command>());
							strExpr = "";
							comandoAtualWhile = new WhileCommand();
						
			setState(133);
			match(AC);
			setState(134);
			exp();
			setState(135);
			match(OPREL);
			strExpr += _input.LT(-1).getText();
			setState(137);
			exp();
			setState(138);
			match(FC);
			comandoAtualWhile.setExpression(strExpr);
			setState(140);
			match(ACH);
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				comando();
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15232L) != 0) );
			comandoAtualWhile.setTrueList(pilha.pop());
						
			setState(147);
			match(FCH);
			setState(148);
			match(PV);
			 pilha.peek().add(comandoAtualWhile); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public TerminalNode ACH() { return getToken(IsilanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsilanguageParser.FCH, 0); }
		public TerminalNode AC() { return getToken(IsilanguageParser.AC, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsilanguageParser.OPREL, 0); }
		public TerminalNode FC() { return getToken(IsilanguageParser.FC, 0); }
		public TerminalNode PV() { return getToken(IsilanguageParser.PV, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__11);
			 pilha.push(new ArrayList<Command>());
							strExpr = "";
							comandoAtualDoWhile = new DoWhileCommand();
						
			setState(153);
			match(ACH);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				comando();
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15232L) != 0) );
			comandoAtualDoWhile.setTrueList(pilha.pop());
						
			setState(160);
			match(FCH);
			setState(161);
			match(T__10);
			setState(162);
			match(AC);
			setState(163);
			exp();
			setState(164);
			match(OPREL);
			strExpr += _input.LT(-1).getText();
			setState(166);
			exp();
			setState(167);
			match(FC);
			comandoAtualDoWhile.setExpression(strExpr);
			setState(169);
			match(PV);
			 pilha.peek().add(comandoAtualDoWhile); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			termo();
			strExpr += _input.LT(-1).getText(); 
			setState(174);
			exp1();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Exp1Context extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(IsilanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsilanguageParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public Exp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterExp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitExp1(this);
		}
	}

	public final Exp1Context exp1() throws RecognitionException {
		Exp1Context _localctx = new Exp1Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_exp1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(176);
				match(OP);
					    strExpr += _input.LT(-1).getText();
									    BinaryExpression bin = new BinaryExpression(_input.LT(-1).getText().charAt(0));
										if (_input.LT(-1).getText().charAt(0) == '*' || _input.LT(-1).getText().charAt(0) == '/') {
										    if (pilhaExp.peek() instanceof UnaryExpression) {
										        bin.setLeft(pilhaExp.pop());
										        pilhaExp.push(bin);
										    } else {
										        BinaryExpression father = (BinaryExpression)pilhaExp.pop();
										        if (father.getOperation() == '+' || father.getOperation() == '-') {
										            BinaryExpression temp = new BinaryExpression(_input.LT(-1).getText().charAt(0));
										            
										            temp.setLeft(father);
										            
										            father.setRight(temp);
										            
										            pilhaExp.push(father);
										        } else {
										            bin.setLeft(father);
										            pilhaExp.push(bin);
										        }
										    }
										} else {
										    bin.setLeft(pilhaExp.pop());
										    pilhaExp.push(bin);
										}
								
				setState(178);
				termo();
				strExpr += _input.LT(-1).getText();
							  		 AbstractExpression topo = pilhaExp.pop();
							  		 BinaryExpression root = (BinaryExpression) pilhaExp.pop();
							  		 root.setRight(topo);
							  		 pilhaExp.push(root);
							  		
				}
				}
				setState(185);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
		public TerminalNode INT() { return getToken(IsilanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(IsilanguageParser.FLOAT, 0); }
		public TerminalNode TEXT() { return getToken(IsilanguageParser.TEXT, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
										throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
									}
									if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
										throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + "  nao inicializada");
									}
									if (tipoDir == null) {
										tipoDir = symbolTable.get(_input.LT(-1).getText()).getType();
									}
									else {
										if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > tipoDir.getValue()) {
											tipoDir = symbolTable.get(_input.LT(-1).getText()).getType();
										}
									}
								
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(INT);
				 if (tipoDir == null) {
								  		tipoDir = Types.INT;
								  	}
								  	else {
								  		if (tipoDir.getValue() < Types.INT.getValue()) {
								  			tipoDir = Types.INT;
								  		}
								  	}
								  	UnaryExpression element = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
				                 	pilhaExp.push(element);
								  
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(FLOAT);
				 if (tipoDir == null) {
								  		tipoDir = Types.FLOAT;
								  	}
								  	else {
								  		if (tipoDir.getValue() < Types.FLOAT.getValue()) {
								  			tipoDir = Types.FLOAT;
								  		}
								  	}
								  	UnaryExpression element = new UnaryExpression(Double.parseDouble(_input.LT(-1).getText()));
				                 	pilhaExp.push(element);
								  
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(TEXT);
				 if (tipoDir == null) {
								  		tipoDir = Types.TEXT;
								  	}
								  	else {
								  		if (tipoDir.getValue() < Types.TEXT.getValue()) {
								  			tipoDir = Types.TEXT;
								  		}
								  	}
								  
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\u0004\u0001\u001b\u00c5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000"+
		"\u000b\u0000\f\u0000\u001e\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f"+
		"\u0000%\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001>\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006m\b"+
		"\u0006\u000b\u0006\f\u0006n\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006v\b\u0006\u000b\u0006\f\u0006w\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007\u008f\b\u0007\u000b\u0007\f\u0007"+
		"\u0090\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\b\u009c\b\b\u000b\b\f\b\u009d\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b6\b\n\n\n\f\n\u00b9\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00c3\b\u000b\u0001\u000b\u0000\u0000\f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u00cb"+
		"\u0000\u0018\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004"+
		"H\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bQ\u0001\u0000"+
		"\u0000\u0000\nX\u0001\u0000\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000e"+
		"\u0083\u0001\u0000\u0000\u0000\u0010\u0097\u0001\u0000\u0000\u0000\u0012"+
		"\u00ac\u0001\u0000\u0000\u0000\u0014\u00b7\u0001\u0000\u0000\u0000\u0016"+
		"\u00c2\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019"+
		"\u001a\u0005\r\u0000\u0000\u001a\u001c\u0006\u0000\uffff\uffff\u0000\u001b"+
		"\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f#\u0001\u0000\u0000\u0000 \"\u0003"+
		"\u0004\u0002\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000&\'\u0005\u0002\u0000\u0000\'(\u0005\u000e"+
		"\u0000\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0003\u0000\u0000+,\u0006\u0001\uffff\uffff\u0000,-\u0005"+
		"\r\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005\u0011\u0000\u0000"+
		"/0\u0005\r\u0000\u000002\u0006\u0001\uffff\uffff\u00001.\u0001\u0000\u0000"+
		"\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u00006=\u0005"+
		"\u0010\u0000\u000078\u0005\u0004\u0000\u00008>\u0006\u0001\uffff\uffff"+
		"\u00009:\u0005\u0005\u0000\u0000:>\u0006\u0001\uffff\uffff\u0000;<\u0005"+
		"\u0006\u0000\u0000<>\u0006\u0001\uffff\uffff\u0000=7\u0001\u0000\u0000"+
		"\u0000=9\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0006\u0001\uffff\uffff\u0000@A\u0005\u000e\u0000\u0000"+
		"A\u0003\u0001\u0000\u0000\u0000BI\u0003\u0006\u0003\u0000CI\u0003\b\u0004"+
		"\u0000DI\u0003\n\u0005\u0000EI\u0003\f\u0006\u0000FI\u0003\u000e\u0007"+
		"\u0000GI\u0003\u0010\b\u0000HB\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000"+
		"\u0000HD\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HG\u0001\u0000\u0000\u0000I\u0005\u0001\u0000\u0000\u0000"+
		"JK\u0005\r\u0000\u0000KL\u0006\u0003\uffff\uffff\u0000LM\u0005\u0012\u0000"+
		"\u0000MN\u0003\u0012\t\u0000NO\u0005\u000e\u0000\u0000OP\u0006\u0003\uffff"+
		"\uffff\u0000P\u0007\u0001\u0000\u0000\u0000QR\u0005\u0007\u0000\u0000"+
		"RS\u0005\u0013\u0000\u0000ST\u0005\r\u0000\u0000TU\u0006\u0004\uffff\uffff"+
		"\u0000UV\u0005\u0014\u0000\u0000VW\u0005\u000e\u0000\u0000W\t\u0001\u0000"+
		"\u0000\u0000XY\u0005\b\u0000\u0000YZ\u0005\u0013\u0000\u0000Z[\u0003\u0016"+
		"\u000b\u0000[\\\u0006\u0005\uffff\uffff\u0000\\]\u0001\u0000\u0000\u0000"+
		"]^\u0005\u0014\u0000\u0000^_\u0005\u000e\u0000\u0000_`\u0006\u0005\uffff"+
		"\uffff\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0005\t\u0000\u0000bc\u0006"+
		"\u0006\uffff\uffff\u0000cd\u0005\u0013\u0000\u0000de\u0003\u0012\t\u0000"+
		"ef\u0005\u0017\u0000\u0000fg\u0006\u0006\uffff\uffff\u0000gh\u0003\u0012"+
		"\t\u0000hi\u0005\u0014\u0000\u0000ij\u0006\u0006\uffff\uffff\u0000jl\u0005"+
		"\u0015\u0000\u0000km\u0003\u0004\u0002\u0000lk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000p}\u0006\u0006\uffff\uffff\u0000qr\u0005"+
		"\n\u0000\u0000rs\u0006\u0006\uffff\uffff\u0000su\u0005\u0015\u0000\u0000"+
		"tv\u0003\u0004\u0002\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000yz\u0006\u0006\uffff\uffff\u0000z{\u0005\u0016\u0000\u0000"+
		"{|\u0005\u000e\u0000\u0000|~\u0001\u0000\u0000\u0000}q\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005\u0016\u0000\u0000\u0080\u0081\u0005\u000e\u0000\u0000\u0081"+
		"\u0082\u0006\u0006\uffff\uffff\u0000\u0082\r\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005\u000b\u0000\u0000\u0084\u0085\u0006\u0007\uffff\uffff\u0000"+
		"\u0085\u0086\u0005\u0013\u0000\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087"+
		"\u0088\u0005\u0017\u0000\u0000\u0088\u0089\u0006\u0007\uffff\uffff\u0000"+
		"\u0089\u008a\u0003\u0012\t\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b"+
		"\u008c\u0006\u0007\uffff\uffff\u0000\u008c\u008e\u0005\u0015\u0000\u0000"+
		"\u008d\u008f\u0003\u0004\u0002\u0000\u008e\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0006\u0007\uffff\uffff\u0000\u0093\u0094\u0005\u0016\u0000"+
		"\u0000\u0094\u0095\u0005\u000e\u0000\u0000\u0095\u0096\u0006\u0007\uffff"+
		"\uffff\u0000\u0096\u000f\u0001\u0000\u0000\u0000\u0097\u0098\u0005\f\u0000"+
		"\u0000\u0098\u0099\u0006\b\uffff\uffff\u0000\u0099\u009b\u0005\u0015\u0000"+
		"\u0000\u009a\u009c\u0003\u0004\u0002\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0006\b\uffff\uffff\u0000\u00a0\u00a1\u0005\u0016\u0000"+
		"\u0000\u00a1\u00a2\u0005\u000b\u0000\u0000\u00a2\u00a3\u0005\u0013\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0012\t\u0000\u00a4\u00a5\u0005\u0017\u0000\u0000"+
		"\u00a5\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u00a7\u0003\u0012\t\u0000"+
		"\u00a7\u00a8\u0005\u0014\u0000\u0000\u00a8\u00a9\u0006\b\uffff\uffff\u0000"+
		"\u00a9\u00aa\u0005\u000e\u0000\u0000\u00aa\u00ab\u0006\b\uffff\uffff\u0000"+
		"\u00ab\u0011\u0001\u0000\u0000\u0000\u00ac\u00ad\u0003\u0016\u000b\u0000"+
		"\u00ad\u00ae\u0006\t\uffff\uffff\u0000\u00ae\u00af\u0003\u0014\n\u0000"+
		"\u00af\u0013\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u000f\u0000\u0000"+
		"\u00b1\u00b2\u0006\n\uffff\uffff\u0000\u00b2\u00b3\u0003\u0016\u000b\u0000"+
		"\u00b3\u00b4\u0006\n\uffff\uffff\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b0\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u0015\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005\r\u0000\u0000\u00bb\u00c3\u0006\u000b\uffff\uffff\u0000"+
		"\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00c3\u0006\u000b\uffff\uffff"+
		"\u0000\u00be\u00bf\u0005\u0019\u0000\u0000\u00bf\u00c3\u0006\u000b\uffff"+
		"\uffff\u0000\u00c0\u00c1\u0005\u001a\u0000\u0000\u00c1\u00c3\u0006\u000b"+
		"\uffff\uffff\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c2\u00bc\u0001"+
		"\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c3\u0017\u0001\u0000\u0000\u0000\f\u001e#3=Hnw}"+
		"\u0090\u009d\u00b7\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}