package com.company.neovest.qa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> parcial = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Operadores> operadores = new ArrayList<>();

        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        operadores.add(Operadores.RESTA);
        operadores.add(Operadores.SUMA);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros,operadores,3,6);



    }
}
