/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;
import java.util.Scanner;
/**
 *
 * @author Igor
 */
public class Tabuada {
    private int acertos,erros,numeroJogadas;
    
    public Tabuada() {
        Scanner entrada = new Scanner(System.in);
        int resultadoJogador,x,y;
        
        while(erros==0) {
            x = this.sortearNumeroDoIntervalo(0,9);
            y = this.sortearNumeroDoIntervalo(0,9);
            System.out.print(""+x+" X "+y+" = ");
            
            resultadoJogador = entrada.nextInt();
            
            if (resultadoJogador==(x*y))
            {
                acertos++;
                System.out.println("Correto!");
            }
            else
            {
                System.out.println("Resposta incorreta. O resultado correto eh "+(x*y));
                erros++;
            }
            numeroJogadas++;
        }
        Tabuada.resultado(acertos,numeroJogadas);
    }
    
    
    public static int sortearNumeroDoIntervalo(int min, int max)
    {
        return((int)(java.lang.Math.random()*(max - min + 1)))+ min;
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
    
    public int getAcertos()
    {
        int a;
        a = acertos;
        return a;
    }
}
