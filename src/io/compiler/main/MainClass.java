package io.compiler.main;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import io.compiler.core.IsilanguageLexer;
import io.compiler.core.IsilanguageParser;

public class MainClass {
	public static void main (String[] args) {
		try {
			IsilanguageLexer lexer;
			IsilanguageParser parser;
			
			lexer = new IsilanguageLexer(CharStreams.fromFileName("input.in"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new IsilanguageParser(tokenStream);
			
			System.out.println("Compilador");
			parser.programa();
			parser.exibirVar();
			System.out.println("Compilação Completada");
		}
		catch (Exception ex) {
			System.err.println("Erro: " + ex.getMessage());
			//ex.printStackTrace();
		}
		
	}
}
