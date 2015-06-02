/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Igor
 */
public class Operadores extends Jogo {
    int operador;
    private String[] operadores = {"ADICAO","SUBTRACAO","MULTIPLICACAO","DIVISAO"};
    
    Operadores()
    {
        operador=0;
        nome = "Operadores";
    }
    
    Operadores(int novoOperador) {
        operador=novoOperador;
    }
    
    public void setOperador(int novoOperador)
    {
        operador=novoOperador;
    }
    
    public int getOperador()
    {
        return operador;
    }
    
   
    
}
