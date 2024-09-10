grammar Isilanguage;

@header{
	import java.util.ArrayList;
	import io.compiler.types.*;
}

@members{
	private ArrayList<Var> listaVar = new ArrayList<Var>();
	private ArrayList<Var> declAtual = new ArrayList<Var>();
	private Types tipoAtual;
	
	public void atzTipo(){
		for(Var v: declAtual){
			v.setType(tipoAtual);
			listaVar.add(v);
		}
	}
	public void exibirVar() {
		for (Var v: listaVar) {
			System.out.println(v);
		}
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
			
		
		
cmdAtributo : ID IGUAL ( INT | FLOAT | TEXT ) PV 
			;
			
			
			
cmdLeitura  : 'ler' AC ID FC PV
			;
			
			
			
cmdEscrita  : 'emitir' AC ( termo ) FC PV 
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
		
		
		
termo   	: fator op2
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