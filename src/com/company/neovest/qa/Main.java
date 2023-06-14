package com.company.neovest.qa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Operadores> operadores = new ArrayList<>();
        //caso 1
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        operadores.add(Operadores.RESTA);
        operadores.add(Operadores.SUMA);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros,operadores,3,1);

        //caso 2
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Operadores> operadores1 = new ArrayList<>();

        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(4);
        numeros1.add(5);
        operadores1.add(Operadores.SUMA);
        operadores1.add(Operadores.MULTI);
        operacionesImplementacion.obtenerOperaciones(numeros1,operadores1,3,12);


    }
}
