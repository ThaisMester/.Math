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
 * @author Thaís
 */
public class Comparacao extends Jogo {
    int comp;
    private String[] comparadores = {"MAIOR QUE", "MENOR QUE"};
    
     Comparacao() {
       comp = 0;
       nome = "Comparacao";
        
     }
    
    public static int sortearNumeroDoIntervaloComparação(int min, int max)
    {
        return ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
    }
    
    public void setComp(int novoComp)
    {
        comp=novoComp;
    }
    
    public int getComp()
    {
        return comp;
    }
    
}
