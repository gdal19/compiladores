// Generated from Isilanguage.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;

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
		T__9=10, T__10=11, ID=12, PV=13, SOMA=14, SUB=15, DIV=16, MULT=17, DP=18, 
		VIRG=19, IGUAL=20, AC=21, FC=22, ACH=23, FCH=24, OPREL=25, INT=26, FLOAT=27, 
		TEXT=28, WS=29;
	public static final int
		RULE_programa = 0, RULE_declarar = 1, RULE_comando = 2, RULE_cmdAtributo = 3, 
		RULE_cmdLeitura = 4, RULE_cmdEscrita = 5, RULE_cmdIf = 6, RULE_cmdWhile = 7, 
		RULE_exp = 8, RULE_exp1 = 9, RULE_termo = 10, RULE_op2 = 11, RULE_fator = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declarar", "comando", "cmdAtributo", "cmdLeitura", "cmdEscrita", 
			"cmdIf", "cmdWhile", "exp", "exp1", "termo", "op2", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'inicio'", "'fim'", "'declaro'", "'int'", "'float'", "'text'", 
			"'ler'", "'emitir'", "'se'", "'senao'", "'enquanto'", null, "';'", "'+'", 
			"'-'", "'/'", "'*'", "':'", "','", "'->'", "'['", "']'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "PV", "SOMA", "SUB", "DIV", "MULT", "DP", "VIRG", "IGUAL", "AC", 
			"FC", "ACH", "FCH", "OPREL", "INT", "FLOAT", "TEXT", "WS"
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
		private Types tipoEsq = null, tipoDir = null;
		
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

	public IsilanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
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
			setState(26);
			match(T__0);
			setState(27);
			match(ID);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				declarar();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7040L) != 0) );
			setState(38);
			match(T__1);
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
			setState(40);
			match(T__2);
			 declAtual.clear(); 
			setState(42);
			match(ID);
			 declAtual.add(new Var(_input.LT(-1).getText()));
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(44);
				match(VIRG);
				setState(45);
				match(ID);
				 declAtual.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(DP);
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(53);
				match(T__3);
				tipoAtual = Types.INT;
				}
				break;
			case T__4:
				{
				setState(55);
				match(T__4);
				tipoAtual = Types.FLOAT;
				}
				break;
			case T__5:
				{
				setState(57);
				match(T__5);
				tipoAtual = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			atzTipo();
			setState(62);
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
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdAtributo();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				cmdLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				cmdIf();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				cmdWhile();
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
			setState(71);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
									throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
								}
								symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
								tipoEsq = symbolTable.get(_input.LT(-1).getText()).getType();
							
			setState(73);
			match(IGUAL);
			setState(74);
			exp();
			setState(75);
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
			setState(78);
			match(T__6);
			setState(79);
			match(AC);
			setState(80);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
									throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
								}
								symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
							
			setState(82);
			match(FC);
			setState(83);
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
			setState(85);
			match(T__7);
			setState(86);
			match(AC);
			{
			setState(87);
			termo();
			}
			setState(88);
			match(FC);
			setState(89);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__8);
			setState(93);
			match(AC);
			setState(94);
			exp();
			setState(95);
			match(OPREL);
			setState(96);
			exp();
			setState(97);
			match(FC);
			setState(98);
			match(ACH);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				comando();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7040L) != 0) );
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(104);
				match(T__9);
				setState(105);
				match(ACH);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7040L) != 0)) {
					{
					{
					setState(107); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(106);
							comando();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(109); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
				match(FCH);
				setState(117);
				match(PV);
				}
			}

			setState(120);
			match(FCH);
			setState(121);
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
			setState(123);
			match(T__10);
			setState(124);
			match(AC);
			setState(125);
			exp();
			setState(126);
			match(OPREL);
			setState(127);
			exp();
			setState(128);
			match(FC);
			setState(129);
			match(ACH);
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				comando();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7040L) != 0) );
			setState(135);
			match(FCH);
			setState(136);
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
		enterRule(_localctx, 16, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			termo();
			setState(139);
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> SOMA() { return getTokens(IsilanguageParser.SOMA); }
		public TerminalNode SOMA(int i) {
			return getToken(IsilanguageParser.SOMA, i);
		}
		public List<TerminalNode> SUB() { return getTokens(IsilanguageParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(IsilanguageParser.SUB, i);
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
		enterRule(_localctx, 18, RULE_exp1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SOMA || _la==SUB) {
				{
				{
				setState(141);
				_la = _input.LA(1);
				if ( !(_la==SOMA || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				termo();
				}
				}
				setState(147);
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
		enterRule(_localctx, 20, RULE_termo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
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
				setState(150);
				match(INT);
				 if (tipoDir == null) {
								  		tipoDir = Types.INT;
								  	}
								  	else {
								  		if (tipoDir.getValue() < Types.INT.getValue()) {
								  			tipoDir = Types.INT;
								  		}
								  	}
								  
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(FLOAT);
				 if (tipoDir == null) {
								  		tipoDir = Types.FLOAT;
								  	}
								  	else {
								  		if (tipoDir.getValue() < Types.FLOAT.getValue()) {
								  			tipoDir = Types.FLOAT;
								  		}
								  	}
								  
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Op2Context extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> DIV() { return getTokens(IsilanguageParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(IsilanguageParser.DIV, i);
		}
		public List<TerminalNode> MULT() { return getTokens(IsilanguageParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(IsilanguageParser.MULT, i);
		}
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterOp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitOp2(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIV || _la==MULT) {
				{
				{
				setState(158);
				_la = _input.LA(1);
				if ( !(_la==DIV || _la==MULT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(159);
				fator();
				}
				}
				setState(164);
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
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsilanguageParser.ID, 0); }
		public TerminalNode INT() { return getToken(IsilanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(IsilanguageParser.FLOAT, 0); }
		public TerminalNode TEXT() { return getToken(IsilanguageParser.TEXT, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsilanguageListener ) ((IsilanguageListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469766144L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00a8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001e"+
		"\b\u0000\u000b\u0000\f\u0000\u001f\u0001\u0000\u0004\u0000#\b\u0000\u000b"+
		"\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00010\b"+
		"\u0001\n\u0001\f\u00013\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0004\u0006e\b\u0006\u000b\u0006\f\u0006"+
		"f\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006l\b\u0006\u000b\u0006"+
		"\f\u0006m\u0005\u0006p\b\u0006\n\u0006\f\u0006s\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006w\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0004\u0007\u0084\b\u0007\u000b\u0007\f\u0007\u0085"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0005\t\u0090\b\t\n\t\f\t\u0093\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009d\b\n\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00a1\b\u000b\n\u000b\f\u000b\u00a4\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0003\u0001\u0000\u000e\u000f\u0001\u0000\u0010"+
		"\u0011\u0002\u0000\f\f\u001a\u001c\u00ad\u0000\u001a\u0001\u0000\u0000"+
		"\u0000\u0002(\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006"+
		"G\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000"+
		"\u0000\f\\\u0001\u0000\u0000\u0000\u000e{\u0001\u0000\u0000\u0000\u0010"+
		"\u008a\u0001\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000\u0014"+
		"\u009c\u0001\u0000\u0000\u0000\u0016\u00a2\u0001\u0000\u0000\u0000\u0018"+
		"\u00a5\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b"+
		"\u001d\u0005\f\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \"\u0001\u0000"+
		"\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000#$\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%&\u0001\u0000\u0000\u0000&\'\u0005\u0002\u0000\u0000\'\u0001\u0001\u0000"+
		"\u0000\u0000()\u0005\u0003\u0000\u0000)*\u0006\u0001\uffff\uffff\u0000"+
		"*+\u0005\f\u0000\u0000+1\u0006\u0001\uffff\uffff\u0000,-\u0005\u0013\u0000"+
		"\u0000-.\u0005\f\u0000\u0000.0\u0006\u0001\uffff\uffff\u0000/,\u0001\u0000"+
		"\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"4;\u0005\u0012\u0000\u000056\u0005\u0004\u0000\u00006<\u0006\u0001\uffff"+
		"\uffff\u000078\u0005\u0005\u0000\u00008<\u0006\u0001\uffff\uffff\u0000"+
		"9:\u0005\u0006\u0000\u0000:<\u0006\u0001\uffff\uffff\u0000;5\u0001\u0000"+
		"\u0000\u0000;7\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0006\u0001\uffff\uffff\u0000>?\u0005\r\u0000\u0000"+
		"?\u0003\u0001\u0000\u0000\u0000@F\u0003\u0006\u0003\u0000AF\u0003\b\u0004"+
		"\u0000BF\u0003\n\u0005\u0000CF\u0003\f\u0006\u0000DF\u0003\u000e\u0007"+
		"\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000F\u0005"+
		"\u0001\u0000\u0000\u0000GH\u0005\f\u0000\u0000HI\u0006\u0003\uffff\uffff"+
		"\u0000IJ\u0005\u0014\u0000\u0000JK\u0003\u0010\b\u0000KL\u0005\r\u0000"+
		"\u0000LM\u0006\u0003\uffff\uffff\u0000M\u0007\u0001\u0000\u0000\u0000"+
		"NO\u0005\u0007\u0000\u0000OP\u0005\u0015\u0000\u0000PQ\u0005\f\u0000\u0000"+
		"QR\u0006\u0004\uffff\uffff\u0000RS\u0005\u0016\u0000\u0000ST\u0005\r\u0000"+
		"\u0000T\t\u0001\u0000\u0000\u0000UV\u0005\b\u0000\u0000VW\u0005\u0015"+
		"\u0000\u0000WX\u0003\u0014\n\u0000XY\u0005\u0016\u0000\u0000YZ\u0005\r"+
		"\u0000\u0000Z[\u0006\u0005\uffff\uffff\u0000[\u000b\u0001\u0000\u0000"+
		"\u0000\\]\u0005\t\u0000\u0000]^\u0005\u0015\u0000\u0000^_\u0003\u0010"+
		"\b\u0000_`\u0005\u0019\u0000\u0000`a\u0003\u0010\b\u0000ab\u0005\u0016"+
		"\u0000\u0000bd\u0005\u0017\u0000\u0000ce\u0003\u0004\u0002\u0000dc\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gv\u0001\u0000\u0000\u0000hi\u0005\n\u0000\u0000"+
		"iq\u0005\u0017\u0000\u0000jl\u0003\u0004\u0002\u0000kj\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000np\u0001\u0000\u0000\u0000ok\u0001\u0000\u0000\u0000ps\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0018\u0000"+
		"\u0000uw\u0005\r\u0000\u0000vh\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xy\u0005\u0018\u0000\u0000yz\u0005\r\u0000"+
		"\u0000z\r\u0001\u0000\u0000\u0000{|\u0005\u000b\u0000\u0000|}\u0005\u0015"+
		"\u0000\u0000}~\u0003\u0010\b\u0000~\u007f\u0005\u0019\u0000\u0000\u007f"+
		"\u0080\u0003\u0010\b\u0000\u0080\u0081\u0005\u0016\u0000\u0000\u0081\u0083"+
		"\u0005\u0017\u0000\u0000\u0082\u0084\u0003\u0004\u0002\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088\u0089"+
		"\u0005\r\u0000\u0000\u0089\u000f\u0001\u0000\u0000\u0000\u008a\u008b\u0003"+
		"\u0014\n\u0000\u008b\u008c\u0003\u0012\t\u0000\u008c\u0011\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0007\u0000\u0000\u0000\u008e\u0090\u0003\u0014"+
		"\n\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0013\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005\f\u0000\u0000\u0095\u009d\u0006\n\uffff\uffff"+
		"\u0000\u0096\u0097\u0005\u001a\u0000\u0000\u0097\u009d\u0006\n\uffff\uffff"+
		"\u0000\u0098\u0099\u0005\u001b\u0000\u0000\u0099\u009d\u0006\n\uffff\uffff"+
		"\u0000\u009a\u009b\u0005\u001c\u0000\u0000\u009b\u009d\u0006\n\uffff\uffff"+
		"\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000"+
		"\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009d\u0015\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0001\u0000"+
		"\u0000\u009f\u00a1\u0003\u0018\f\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u0017\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0007\u0002\u0000\u0000"+
		"\u00a6\u0019\u0001\u0000\u0000\u0000\r\u001f$1;Efmqv\u0085\u0091\u009c"+
		"\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}