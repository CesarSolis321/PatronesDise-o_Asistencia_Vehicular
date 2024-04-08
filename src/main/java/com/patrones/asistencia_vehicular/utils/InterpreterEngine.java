package com.patrones.asistencia_vehicular.utils;

import java.util.HashMap;
import java.util.Map;

public class InterpreterEngine {

    private Map<String, Object>  costo  = new HashMap<>();
	public InterpreterEngine() {
    }


    //Perform Addition
	public int addition(String inputData) {
        int number1, number2;
        String[] tokens = interpret(inputData);
        int sum = 0;

        costo.put("C", 0);
        costo.put("TB", 50);
        costo.put("CL", 60);
        costo.put("LL", 70);
        costo.put("RE", 80);
        costo.put("RS", 90);
        costo.put("SO", 100);
        for (String string : tokens) {
            System.out.println(string);
        }
        for (int i = 0; i < tokens.length; i ++) {
            System.out.println(tokens[i]);
            System.out.println(costo.get(tokens[i]).toString());
            System.out.println( sum);
            sum += Integer.parseInt(costo.get(tokens[i]).toString());
        }
        
        return sum;
		
	}


	private String[] interpret(String inputData) {
		 String tempInputData = inputData.replaceAll("[^TB|^RE|^RS|^CL|^LL|^SO]+", " ");
		tempInputData = tempInputData.replaceAll("( )+", " ").trim();
		String[] inputDatatokens = tempInputData.split(" ");
		return inputDatatokens;
	}
}