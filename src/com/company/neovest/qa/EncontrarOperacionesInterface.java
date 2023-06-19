package com.company.neovest.qa;


import javax.script.ScriptException;
import java.util.ArrayList;

public interface EncontrarOperacionesInterface {
    ArrayList<String> obtenerOperaciones(ArrayList<Integer> var1, ArrayList<Operadores> var2, int var3, int var4) throws ScriptException;
}
