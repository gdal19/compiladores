package io.compiler.core.ast;

import io.compiler.types.Var;
import io.compiler.types.Types;

public class ReadCommand extends Command{
	private Var var;
	
	
	public ReadCommand() {
		super();
	}
	
	
	public ReadCommand(Var var) {
		super();
		this.var = var;
	}


	public Var getVar() {
		return var;
	}



	public void setVar(Var var) {
		this.var = var;
	}



	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		if (var.getType() == Types.INT) {
			return var.getId() + " = " + " leitor.nextInt();";
		}
		if (var.getType() == Types.FLOAT) {
			return var.getId() + " = " + " leitor.nextFloat();";
		}
		else {
			return var.getId() + " = " + " leitor.nextLine();";
		}
	}

}
