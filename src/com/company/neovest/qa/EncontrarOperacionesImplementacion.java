package com.company.neovest.qa;

import java.util.ArrayList;

public class EncontrarOperacionesImplementacion implements EncontrarOperacionesInterface {
    @Override
    public ArrayList<String> obtenerOperaciones(ArrayList<Integer> var1, ArrayList<Operadores> var2, int var3, int var4) {
       ArrayList<Integer> numeros_usados = new ArrayList<>();
       ArrayList<Operadores> operadoes_usados = new ArrayList<>();
       ArrayList<StringBuilder> expresiones = new ArrayList<>();

       Backtracking(var1, var3, var2, var4, numeros_usados, operadoes_usados, expresiones);
       return null;
    }

    private void Backtracking(ArrayList<Integer> numeros, int cantidad_numeros, ArrayList<Operadores> operadores, int objetivo, ArrayList<Integer> numeros_usados, ArrayList<Operadores> operadoes_usados, ArrayList<StringBuilder> expresiones) {;
        for (int i=0 ; i<numeros.size();i++){
            if (!numeros_usados.contains(i)){
                numeros_usados.add(i);
                cantidad_numeros=cantidad_numeros-1;
                if (cantidad_numeros==0){
                    System.out.println((obtenerExpresion(numeros,numeros_usados,operadoes_usados)+" = "+calcularExpresion(numeros,numeros_usados,operadoes_usados)));
                    if (calcularExpresion(numeros,numeros_usados,operadoes_usados)==objetivo ){
                        expresiones.add(obtenerExpresion(numeros,numeros_usados,operadoes_usados));
                    }
                }else {
                    if (cantidad_numeros>0){
                        for (int j=0 ; j<operadores.size();j++){
                            operadoes_usados.add(operadores.get(j));
                            Backtracking(numeros,cantidad_numeros,operadores,objetivo,numeros_usados,operadoes_usados,expresiones);
                            operadoes_usados.remove(operadores.get(j)) ;

                        }
                    }
                }
                System.out.println(numeros_usados.toString());
                numeros_usados.remove(numeros_usados.indexOf(i));
                cantidad_numeros++;
            }
        }
    }

    private StringBuilder obtenerExpresion(ArrayList<Integer> numeros, ArrayList<Integer> numeros_usados, ArrayList<Operadores> operadoes_usados) {
        StringBuilder expreison= new StringBuilder();
        for (int i=0 ; i < numeros_usados.size();i++) {
            expreison.append(numeros.get(numeros_usados.get(i)));
            if (i < operadoes_usados.size()){
                expreison.append("").append(operadoes_usados.get(i)).append("");
            }
        }
        return expreison;
    }
    public int calcularExpresion(ArrayList<Integer> numeros, ArrayList<Integer> numeros_usados, ArrayList<Operadores> operadoes_usados){
        int resultado = numeros.get(numeros_usados.get(0));
        for (int i = 0; i< operadoes_usados.size();i++){

                Operadores operador = operadoes_usados.get(i);

                int numero= numeros.get(numeros_usados.get(i+1));

                if (operador.equals(Operadores.MULTI)||operador.equals(Operadores.DIV)){
                    int proxNumero = numeros.get(numeros_usados.get(i)+2);

                    if (operador.equals(Operadores.MULTI)){
                        resultado *= numero * proxNumero;
                    }else {
                        resultado /= numero/proxNumero;
                    }
                    i++;
                }else {
                    if (operador.equals(Operadores.SUMA))
                        resultado += numero;
                    else resultado -= numero;
                }
            }

        return resultado;
    }

}
