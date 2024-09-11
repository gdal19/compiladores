package io.compiler.types;

public enum Types {
	INT(1),
	FLOAT(2),
	TEXT(3);
	
	
	public int value;
	
	private Types (int valueNumber) {
		this.value = valueNumber;
	}
	public Integer getValue() {
		return this.value;
	}
}
