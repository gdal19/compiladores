grammar Isilanguage;

@header{
	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
}

@members{
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
}

programa	:'inicio' ID 
			declarar+
			comando+
			'fim'
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
				}
			 FC PV
			;
			
			
			
cmdEscrita  : 'emitir' AC ( termo ) FC PV { tipoDir = null;}
			;
			
			
			
cmdIf       : 'se' AC exp OPREL exp FC ACH
			comando+ 
			('senao' ACH (comando+)* FCH PV)?
			FCH PV
			;
			
	
cmdWhile	: 'enquanto' AC exp OPREL exp FC ACH
			comando+
			FCH PV	
			;
		
		
exp 		: termo exp1
			;
			
				

exp1        : ((SOMA | SUB) termo)*
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
				  }
			
			| FLOAT { if (tipoDir == null) {
				  		tipoDir = Types.FLOAT;
				  	}
				  	else {
				  		if (tipoDir.getValue() < Types.FLOAT.getValue()) {
				  			tipoDir = Types.FLOAT;
				  		}
				  	}
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
		
		

op2     	: ((DIV | MULT) fator)*
			;
		
		
		
fator   	: ID | INT | FLOAT | TEXT
			;
		
		
ID      	: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
		
		
PV      	: ';'
			;
		
		
		
SOMA    	: '+'
			;
		
		

SUB     	: '-'
			;
		
		

DIV     	: '/'
			;
		
		
		
MULT    	: '*'
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