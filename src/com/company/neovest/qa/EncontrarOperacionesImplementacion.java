package com.company.neovest.qa;

import java.util.ArrayList;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EncontrarOperacionesImplementacion implements EncontrarOperacionesInterface {
    @Override
    public ArrayList<String> obtenerOperaciones(ArrayList<Integer> var1, ArrayList<Operadores> var2, int var3, int var4) throws ScriptException {
       ArrayList<Integer> numeros_usados = new ArrayList<>();
       ArrayList<Integer> operadoes_usados = new ArrayList<>();
       ArrayList<StringBuilder> expresiones = new ArrayList<>();

       if (var3 > var2.size()){
           Backtracking(var1, var3, var2, var4, numeros_usados, operadoes_usados, expresiones);
       }
       System.out.println(expresiones);
       return null;
    }

    private void Backtracking(ArrayList<Integer> numeros, int cantidad_numeros, ArrayList<Operadores> operadores, int objetivo, ArrayList<Integer> numeros_usados, ArrayList<Integer> operadoes_usados, ArrayList<StringBuilder> expresiones) throws ScriptException {;
        for (int i=0 ; i<numeros.size();i++){
            if (!numeros_usados.contains(i)){
                numeros_usados.add(i);
                cantidad_numeros=cantidad_numeros-1;
                if (cantidad_numeros==0){
                    if (calcularExpresion(numeros,numeros_usados,operadores,operadoes_usados)==objetivo ){
                        expresiones.add(obtenerExpresion(numeros,numeros_usados,operadores,operadoes_usados));
                    }
                }else {
                    if (cantidad_numeros>0){
                        for (int j=0 ; j<operadores.size();j++){
                            if (!operadoes_usados.contains(j)){
                                operadoes_usados.add(j);
                                Backtracking(numeros,cantidad_numeros,operadores,objetivo,numeros_usados,operadoes_usados,expresiones);
                                operadoes_usados.remove(operadoes_usados.indexOf(j)) ;
                            }
                        }
                    }
                }
                numeros_usados.remove(numeros_usados.indexOf(i));
                cantidad_numeros++;
            }
        }
    }

    private StringBuilder obtenerExpresion(ArrayList<Integer> numeros, ArrayList<Integer> numeros_usados, ArrayList<Operadores> operadores, ArrayList<Integer> operadoes_usados) {
        StringBuilder expreison= new StringBuilder();
        for (int i=0 ; i < numeros_usados.size();i++) {
            expreison.append(numeros.get(numeros_usados.get(i)));
            if (i < operadoes_usados.size()){
                if (operadores.get(operadoes_usados.get(i)) == Operadores.MULTI)expreison.append("").append("*").append("");
                if (operadores.get(operadoes_usados.get(i)) == Operadores.DIV)expreison.append("").append("/").append("");
                if (operadores.get(operadoes_usados.get(i)) == Operadores.SUMA)expreison.append("").append("+").append("");
                if (operadores.get(operadoes_usados.get(i)) == Operadores.RESTA)expreison.append("").append("-").append("");



            }
        }
        return expreison;
    }
    public int calcularExpresion(ArrayList<Integer> numeros, ArrayList<Integer> numeros_usados, ArrayList<Operadores> operadores,ArrayList<Integer> operadoes_usados) throws ScriptException {

        StringBuilder ecuacion = obtenerExpresion(numeros,numeros_usados,operadores,operadoes_usados);
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = engine.eval(String.valueOf(ecuacion));
        int value= 0;
        if (result instanceof Double) {
            double doubleValue = (Double) result;
            value = (int) doubleValue;
        }else {
            value = (int) result;
        }
        System.out.println(ecuacion+" = "+ (value) );
        return value;
        }




}









