package com.patrones.asistencia_vehicular.utils;

public class InterpreterTest {
    public static void main(String args[]) {
		
		//Create an Instance of InterpreterEngine
		InterpreterEngine interpreterEngine = new InterpreterEngine();
		
		//Create an Instance of InterpreterClient
		InterpreterClient interpreterClient = new InterpreterClient(interpreterEngine);
 
		System.out.println("Addition of both Number is = " + interpreterClient.interpret(" TB + RE + TB "));
		System.out.println("---------------------------------------------------------------------------------");
	
	}
}
