package com.company.neovest.qa;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws ScriptException {
       // test1();
       // tes2();
        //tes3();
        test4();
        test5();
    }



    public static void test1() throws ScriptException {
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
    }

    public static void tes2() throws ScriptException {
        ArrayList<Integer> numeros1 = new ArrayList<>(){};
        ArrayList<Operadores> operadores1 = new ArrayList<>();

        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(4);
        numeros1.add(5);
        operadores1.add(Operadores.SUMA);
        operadores1.add(Operadores.MULTI);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros1,operadores1,3,12);
    }

    public static void tes3() throws ScriptException {
        ArrayList<Integer> numeros1 = new ArrayList<>(){};
        ArrayList<Operadores> operadores1 = new ArrayList<>();

        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(4);
        numeros1.add(5);
        operadores1.add(Operadores.SUMA);
        operadores1.add(Operadores.MULTI);
        operadores1.add(Operadores.RESTA);
        operadores1.add(Operadores.DIV);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros1,operadores1,2,50);
    }

    public static void test4() throws ScriptException {
        ArrayList<Integer> numeros1 = new ArrayList<>(){};
        ArrayList<Operadores> operadores1 = new ArrayList<>();

        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(4);
        numeros1.add(5);
        operadores1.add(Operadores.SUMA);
        operadores1.add(Operadores.MULTI);
        operadores1.add(Operadores.DIV);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros1,operadores1,4,13);
    }

    private static void test5() throws ScriptException {
        ArrayList<Integer> numeros1 = new ArrayList<>(){};
        ArrayList<Operadores> operadores1 = new ArrayList<>();

        numeros1.add(2);
        numeros1.add(3);
        numeros1.add(4);
        numeros1.add(0);
        operadores1.add(Operadores.SUMA);
        operadores1.add(Operadores.MULTI);
        operadores1.add(Operadores.DIV);
        EncontrarOperacionesInterface operacionesImplementacion= new EncontrarOperacionesImplementacion();
        operacionesImplementacion.obtenerOperaciones(numeros1,operadores1,4,2);
    }


}
