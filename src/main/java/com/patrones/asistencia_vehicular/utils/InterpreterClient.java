package com.patrones.asistencia_vehicular.utils;

public class InterpreterClient {
    private InterpreterEngine interpreterEngine;
 
	public InterpreterClient(InterpreterEngine interpreterEngine) {
		this.interpreterEngine = interpreterEngine;
	}
 
	/**
	 * Perform either addition or substraction
     * that depends on inputData expression
	 * @param inputData input expression
	 * @return added or subtracted value
	 */
	public int interpret(String inputData) {
 
		Expression expression = null;
 
		//Check if inputData has add word
		if (inputData.contains("+")) {
			expression = new AdditionExpression(inputData);
		}
		//Check if inputData has subtract word
		else {
			throw new RuntimeException(inputData+" is not valid expression!!");
		}
 
		int result = expression.interpret(interpreterEngine);
		System.out.println(inputData);
 
		return result;
	}
}
