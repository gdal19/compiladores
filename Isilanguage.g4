grammar Isilanguage;

@header{
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import io.compiler.runtime.*;
}

@members{
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
}

programa	:'inicio' ID { programa.setName(_input.LT(-1).getText()); 
					       pilha.push(new ArrayList<Command>());
					     }
			declarar+
			comando*
			'fim' PV
			
			{
				programa.setSymbolTable(symbolTable);
				programa.setCommandList(pilha.pop());
			}
			
			;
		

declarar    : 'declaro' { declAtual.clear(); }
			ID 	{ declAtual.add(new Var(_input.LT(-1).getText()));}
			(VIRG ID
				{ declAtual.add(new Var(_input.LT(-1).getText()));}
			)* DP 
			('int' {tipoAtual = Types.INT;}
			|'float' {tipoAtual = Types.FLOAT;}
			|'text'{tipoAtual = Types.TEXT;}
			) 
			
			{atzTipo();}
			PV
			;
		
		
		
comando     : cmdAtributo
			| cmdLeitura
			| cmdEscrita
			| cmdIf
			| cmdWhile
			| cmdDoWhile
			;
			
		
		
cmdAtributo : ID { if (!isDeclared(_input.LT(-1).getText())) {
						throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
					}
					symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
					tipoEsq = symbolTable.get(_input.LT(-1).getText()).getType();
				}
			IGUAL exp PV 
			
			{ System.out.println("Tipo da expressao na esquerda = "+tipoEsq);
              System.out.println("Tipo da expressao na direita = "+tipoDir);
              if (tipoEsq.getValue() < tipoDir.getValue()){
              	throw new SemanticException("Tipos incompativeis na atribuicao");
              }
			}
			
			;
			
			
			
cmdLeitura  : 'ler' AC ID { if (!isDeclared(_input.LT(-1).getText())) {
						throw new SemanticException("Variavel " + (_input.LT(-1).getText()) + " nao declarada");
					}
					symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
					Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
					pilha.peek().add(cmdRead);
				}
			 FC PV
			;
			
			
			
cmdEscrita  : 'emitir' AC 
			( termo { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
					  pilha.peek().add(cmdWrite);
					}) 
			FC PV { tipoDir = null;}
			;
			
			
			
cmdIf       : 'se' { pilha.push(new ArrayList<Command>());
				   	 strExpr = "";
				   	 comandoAtualIf = new IfCommand();
				   }
			AC exp 
			OPREL
			{strExpr += _input.LT(-1).getText();} 
			exp FC 
			{comandoAtualIf.setExpression(strExpr);}
			ACH
			comando+ 
			{comandoAtualIf.setTrueList(pilha.pop());
			}
			('senao' 
			{pilha.push(new ArrayList<Command>());}
			ACH 
			comando+ 
			{ 
			comandoAtualIf.setFalseList(pilha.pop());
			} 
			FCH PV)?
			FCH
			PV 
			{ pilha.peek().add(comandoAtualIf); }
			;
					
	
cmdWhile	: 'enquanto' 
			{ pilha.push(new ArrayList<Command>());
				strExpr = "";
				comandoAtualWhile = new WhileCommand();
			}
			AC exp 
			OPREL {strExpr += _input.LT(-1).getText();} 
			exp FC {comandoAtualWhile.setExpression(strExpr);}
			ACH
			comando+ 
			{comandoAtualWhile.setTrueList(pilha.pop());
			}
			FCH PV	{ pilha.peek().add(comandoAtualWhile); }
			;
			

cmdDoWhile	:'faca'
			{ pilha.push(new ArrayList<Command>());
				strExpr = "";
				comandoAtualDoWhile = new DoWhileCommand();
			}
			ACH 
			comando+ 
			{comandoAtualDoWhile.setTrueList(pilha.pop());
			}
			FCH
			'enquanto' AC exp 
			OPREL {strExpr += _input.LT(-1).getText();} 
			exp 
			FC {comandoAtualDoWhile.setExpression(strExpr);}
			PV	{ pilha.peek().add(comandoAtualDoWhile); }
			;
		
		
exp 		: termo {strExpr += _input.LT(-1).getText(); } exp1
			;
			
				

exp1        : (OP {	    strExpr += _input.LT(-1).getText();
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
				}
			  termo {strExpr += _input.LT(-1).getText();
			  		 AbstractExpression topo = pilhaExp.pop();
			  		 BinaryExpression root = (BinaryExpression) pilhaExp.pop();
			  		 root.setRight(topo);
			  		 pilhaExp.push(root);
			  		}
				)*
			;
		
		
		
termo   	: ID { if (!isDeclared(_input.LT(-1).getText())) {
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
			| INT { if (tipoDir == null) {
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
			
			| FLOAT { if (tipoDir == null) {
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
			
			| TEXT { if (tipoDir == null) {
				  		tipoDir = Types.TEXT;
				  	}
				  	else {
				  		if (tipoDir.getValue() < Types.TEXT.getValue()) {
				  			tipoDir = Types.TEXT;
				  		}
				  	}
				  }
			;
		
		
ID      	: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
		
		
PV      	: ';'
			;
		
		
		
OP       	: '+' | '-' | '/' | '*'
			;		
					
		
DP      	: ':'
			;
		
		
VIRG    	: ','
			;
		
		
IGUAL   	: '->'
			;
		
		
AC      	: '['
			;
		
		
FC      	: ']'
			;
			
			
ACH      	: '{'
			;
		
		
FCH      	: '}'
			;	
				
		
OPREL   	: '>' | '<' | '>=' | '<= ' | '<>' | '=='
			;
			
			
INT     	: ('-')?[0-9]+
			;			
				

FLOAT     	: ('-')?[0-9]+('.'[0-9]+)?
			;
			
		
TEXT    	: '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
			;
		

 WS			: (' '|'\n'|'\r'|'\t') () -> skip
			;								