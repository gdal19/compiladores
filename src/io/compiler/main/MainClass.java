package io.compiler.main;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import io.compiler.core.IsilanguageLexer;
import io.compiler.core.IsilanguageParser;
import io.compiler.core.ast.*;

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
			
			System.out.println("Avaliação de expressão iniciada");
			parser.exp();
			System.out.println("Avaliação de expressão terminada");
			System.out.println("Valor da expressao = " + parser.generateValue());
			System.out.println(parser.generateJSON());
			
			Program program = parser.getProgram();
			System.out.println(program.generateTarget());
			
			try {
				File f = new File(program.getName()+".java");
				FileWriter fr = new FileWriter(f);
				PrintWriter pr = new PrintWriter(fr);
				pr.println(program.generateTarget());
				pr.close();
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}
		catch (Exception ex) {
			System.err.println("Erro: " + ex.getMessage());
			//ex.printStackTrace();
		}
		
	}
}
