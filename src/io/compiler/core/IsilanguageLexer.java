// Generated from Isilanguage.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import io.compiler.runtime.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsilanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ID=13, PV=14, OP=15, DP=16, VIRG=17, IGUAL=18, 
		AC=19, FC=20, ACH=21, FCH=22, OPREL=23, INT=24, FLOAT=25, TEXT=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "PV", "OP", "DP", "VIRG", "IGUAL", "AC", 
			"FC", "ACH", "FCH", "OPREL", "INT", "FLOAT", "TEXT", "WS"
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


	public IsilanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Isilanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001b\u00c7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\f~\b\f\n\f\f\f\u0081\t"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00a0"+
		"\b\u0016\u0001\u0017\u0003\u0017\u00a3\b\u0017\u0001\u0017\u0004\u0017"+
		"\u00a6\b\u0017\u000b\u0017\f\u0017\u00a7\u0001\u0018\u0003\u0018\u00ab"+
		"\b\u0018\u0001\u0018\u0004\u0018\u00ae\b\u0018\u000b\u0018\f\u0018\u00af"+
		"\u0001\u0018\u0001\u0018\u0004\u0018\u00b4\b\u0018\u000b\u0018\f\u0018"+
		"\u00b5\u0003\u0018\u00b8\b\u0018\u0001\u0019\u0001\u0019\u0005\u0019\u00bc"+
		"\b\u0019\n\u0019\f\u0019\u00bf\t\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b\u0001\u0000\u0007\u0001\u0000az\u0003\u0000"+
		"09AZaz\u0003\u0000*+--//\u0002\u0000<<>>\u0001\u000009\u0005\u0000  ,"+
		".09AZaz\u0003\u0000\t\n\r\r  \u00d2\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00017\u0001\u0000\u0000\u0000\u0003>\u0001\u0000\u0000\u0000\u0005"+
		"B\u0001\u0000\u0000\u0000\u0007J\u0001\u0000\u0000\u0000\tN\u0001\u0000"+
		"\u0000\u0000\u000bT\u0001\u0000\u0000\u0000\rY\u0001\u0000\u0000\u0000"+
		"\u000f]\u0001\u0000\u0000\u0000\u0011d\u0001\u0000\u0000\u0000\u0013g"+
		"\u0001\u0000\u0000\u0000\u0015m\u0001\u0000\u0000\u0000\u0017v\u0001\u0000"+
		"\u0000\u0000\u0019{\u0001\u0000\u0000\u0000\u001b\u0082\u0001\u0000\u0000"+
		"\u0000\u001d\u0084\u0001\u0000\u0000\u0000\u001f\u0086\u0001\u0000\u0000"+
		"\u0000!\u0088\u0001\u0000\u0000\u0000#\u008a\u0001\u0000\u0000\u0000%"+
		"\u008d\u0001\u0000\u0000\u0000\'\u008f\u0001\u0000\u0000\u0000)\u0091"+
		"\u0001\u0000\u0000\u0000+\u0093\u0001\u0000\u0000\u0000-\u009f\u0001\u0000"+
		"\u0000\u0000/\u00a2\u0001\u0000\u0000\u00001\u00aa\u0001\u0000\u0000\u0000"+
		"3\u00b9\u0001\u0000\u0000\u00005\u00c2\u0001\u0000\u0000\u000078\u0005"+
		"i\u0000\u000089\u0005n\u0000\u00009:\u0005i\u0000\u0000:;\u0005c\u0000"+
		"\u0000;<\u0005i\u0000\u0000<=\u0005o\u0000\u0000=\u0002\u0001\u0000\u0000"+
		"\u0000>?\u0005f\u0000\u0000?@\u0005i\u0000\u0000@A\u0005m\u0000\u0000"+
		"A\u0004\u0001\u0000\u0000\u0000BC\u0005d\u0000\u0000CD\u0005e\u0000\u0000"+
		"DE\u0005c\u0000\u0000EF\u0005l\u0000\u0000FG\u0005a\u0000\u0000GH\u0005"+
		"r\u0000\u0000HI\u0005o\u0000\u0000I\u0006\u0001\u0000\u0000\u0000JK\u0005"+
		"i\u0000\u0000KL\u0005n\u0000\u0000LM\u0005t\u0000\u0000M\b\u0001\u0000"+
		"\u0000\u0000NO\u0005f\u0000\u0000OP\u0005l\u0000\u0000PQ\u0005o\u0000"+
		"\u0000QR\u0005a\u0000\u0000RS\u0005t\u0000\u0000S\n\u0001\u0000\u0000"+
		"\u0000TU\u0005t\u0000\u0000UV\u0005e\u0000\u0000VW\u0005x\u0000\u0000"+
		"WX\u0005t\u0000\u0000X\f\u0001\u0000\u0000\u0000YZ\u0005l\u0000\u0000"+
		"Z[\u0005e\u0000\u0000[\\\u0005r\u0000\u0000\\\u000e\u0001\u0000\u0000"+
		"\u0000]^\u0005e\u0000\u0000^_\u0005m\u0000\u0000_`\u0005i\u0000\u0000"+
		"`a\u0005t\u0000\u0000ab\u0005i\u0000\u0000bc\u0005r\u0000\u0000c\u0010"+
		"\u0001\u0000\u0000\u0000de\u0005s\u0000\u0000ef\u0005e\u0000\u0000f\u0012"+
		"\u0001\u0000\u0000\u0000gh\u0005s\u0000\u0000hi\u0005e\u0000\u0000ij\u0005"+
		"n\u0000\u0000jk\u0005a\u0000\u0000kl\u0005o\u0000\u0000l\u0014\u0001\u0000"+
		"\u0000\u0000mn\u0005e\u0000\u0000no\u0005n\u0000\u0000op\u0005q\u0000"+
		"\u0000pq\u0005u\u0000\u0000qr\u0005a\u0000\u0000rs\u0005n\u0000\u0000"+
		"st\u0005t\u0000\u0000tu\u0005o\u0000\u0000u\u0016\u0001\u0000\u0000\u0000"+
		"vw\u0005f\u0000\u0000wx\u0005a\u0000\u0000xy\u0005c\u0000\u0000yz\u0005"+
		"a\u0000\u0000z\u0018\u0001\u0000\u0000\u0000{\u007f\u0007\u0000\u0000"+
		"\u0000|~\u0007\u0001\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u001a\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0005;\u0000\u0000\u0083\u001c\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0007\u0002\u0000\u0000\u0085\u001e\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005:\u0000\u0000\u0087 \u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005,\u0000\u0000\u0089\"\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005-\u0000\u0000\u008b\u008c\u0005>\u0000\u0000\u008c$\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005[\u0000\u0000\u008e&\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005]\u0000\u0000\u0090(\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005{\u0000\u0000\u0092*\u0001\u0000\u0000\u0000\u0093\u0094\u0005}"+
		"\u0000\u0000\u0094,\u0001\u0000\u0000\u0000\u0095\u00a0\u0007\u0003\u0000"+
		"\u0000\u0096\u0097\u0005>\u0000\u0000\u0097\u00a0\u0005=\u0000\u0000\u0098"+
		"\u0099\u0005<\u0000\u0000\u0099\u009a\u0005=\u0000\u0000\u009a\u00a0\u0005"+
		" \u0000\u0000\u009b\u009c\u0005<\u0000\u0000\u009c\u00a0\u0005>\u0000"+
		"\u0000\u009d\u009e\u0005=\u0000\u0000\u009e\u00a0\u0005=\u0000\u0000\u009f"+
		"\u0095\u0001\u0000\u0000\u0000\u009f\u0096\u0001\u0000\u0000\u0000\u009f"+
		"\u0098\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u00a0.\u0001\u0000\u0000\u0000\u00a1\u00a3"+
		"\u0005-\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a6\u0007"+
		"\u0004\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a80\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005-\u0000"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00ae\u0007\u0004\u0000"+
		"\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b7\u0001\u0000\u0000\u0000\u00b1\u00b3\u0005.\u0000\u0000"+
		"\u00b2\u00b4\u0007\u0004\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b1\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b82\u0001\u0000\u0000\u0000\u00b9\u00bd\u0005\"\u0000\u0000\u00ba"+
		"\u00bc\u0007\u0005\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\"\u0000\u0000\u00c14"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0007\u0006\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0006\u001a\u0000\u0000\u00c66\u0001\u0000\u0000\u0000\f\u0000}\u007f"+
		"\u009f\u00a2\u00a7\u00aa\u00af\u00b5\u00b7\u00bb\u00bd\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}