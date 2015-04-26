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
public class Comparacao {
    private int acertos,erros,numeroJogadas;
    private String[] comparadores = {"MAIOR QUE", "MENOR QUE"};
    
     Comparacao() {
        Scanner entrada = new Scanner(System.in);
        int resultadoJogador,comp;
        float x,y;
        
        while(erros==0) {
            x = this.sortearNumeroDoIntervaloXEY(0,9);
            comp = this.sortearNumeroDoIntervaloComparação(1,2);
           
            if (comp==1) {
               do
                    y = this.sortearNumeroDoIntervaloXEY(0,9);
                while (y>=x);
                
                System.out.println(x+" ? "+y);
                resultadoJogador = menu(entrada);
                
                parcial(comp,resultadoJogador);
            }
            
            if (comp==2) {
                do
                    y = this.sortearNumeroDoIntervaloXEY(0,9);
                while (y<=x);
                
                System.out.println(x+" ? "+y);
                resultadoJogador = menu(entrada);
                
                parcial(comp,resultadoJogador);
            }
            numeroJogadas++;
        }
        
        
        Comparacao.resultado(acertos,numeroJogadas);
    }
    
    
    public static float sortearNumeroDoIntervaloXEY(int min, int max)
    {
        int numero = ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
        return (float) numero;
    }
    
    public static int sortearNumeroDoIntervaloComparação(int min, int max)
    {
        return ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
    }
    
    public static int menu(Scanner entrada1) {
        int opcao;
        
        System.out.println("Qual o operador utilizado nesta comparação?");
        System.out.println("Digite 1 para MAIOR QUE");
        System.out.println("Digite 2 para MENOR QUE");
        System.out.print(">>> ");
        
        opcao = entrada1.nextInt();
        return opcao;
    }
    
    public static void resultado(int acertos,int numeroJogadas){
        
       System.out.print("Voce acertou "+acertos+" de "+numeroJogadas+" contas. ");

        if ((float)acertos/(float)numeroJogadas>0.9)
            System.out.println("Parabens! Voce eh fera!");
        if (((float)acertos/(float)numeroJogadas>=0.8)&&((float)acertos/(float)numeroJogadas<0.9))
            System.out.println("Excelente!");
        if(((float)acertos/(float)numeroJogadas>=0.7)&&((float)acertos/(float)numeroJogadas<0.8))
            System.out.println("Muito Bom! Continue estudando!");
        if(((float)acertos/(float)numeroJogadas>=0.6)&&((float)acertos/(float)numeroJogadas<0.7))
            System.out.println("Legal, mas voce pode ficar melhor! Estude mais um pouco!");
        if((float)acertos/(float)numeroJogadas<0.6)
            System.out.println("Voce precisa estudar um pouco mais! Nao desanime!");

    }
    
    public void parcial(int comparador, int resultPlayer) {
        if(resultPlayer==comparador) {
            acertos++;
            System.out.println("Correto!");
        }
        else {
                System.out.println("Resposta incorreta...");
                erros++;
        }
    }
    
    public int getAcertos()
    {
        int a =acertos;
        return a;
    }
}
