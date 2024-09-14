package io.compiler.core.ast;

import java.util.List;

public class DoWhileCommand extends Command {
	private String expression;
	private List<Command> trueList;
	
	
	public DoWhileCommand() {
		super();
	}



	public DoWhileCommand(String expression, List<Command> trueList) {
		super();
		this.expression = expression;
		this.trueList = trueList;
	}



	public String getExpression() {
		return expression;
	}



	public void setExpression(String expression) {
		this.expression = expression;
	}



	public List<Command> getTrueList() {
		return trueList;
	}



	public void setTrueList(List<Command> trueList) {
		this.trueList = trueList;
	}



	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("do {");
		
		for (Command cmd: trueList) {
			str.append(cmd.generateTarget());
		}
		str.append("}");
		str.append("while ("+expression+");");
		
		return str.toString();
	}

}
