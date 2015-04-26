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
public class Operadores {
    private int acertos,erro,numeroJogadas;
    private String[] operadores = {"ADICAO","SUBTRACAO","MULTIPLICACAO","DIVISAO"};
    
    Operadores() {
        Scanner entrada = new Scanner(System.in);
        int resultadoJogador,op;
        float x,y;
        
        while(erro==0) {
            x = this.sortearNumeroDoIntervaloXEY(0,9);
            op = this.sortearNumeroDoIntervaloOperadores(1,4);
           
            if (op==1) {
                y = this.sortearNumeroDoIntervaloXEY(0,9);
                System.out.println(x+" ? "+y+" = "+(x+y));
                resultadoJogador = Operadores.menu(entrada);
                
                parcial(op,resultadoJogador,x,y);
            }
            
            if (op==2) {
                do
                    y = this.sortearNumeroDoIntervaloXEY(0,9);
                while (y>x);
                
                System.out.println(x+" ? "+y+" = "+(x-y));
                resultadoJogador = Operadores.menu(entrada);
                
                parcial(op,resultadoJogador,x,y);
            }
            
            if (op==3) {
                y = this.sortearNumeroDoIntervaloXEY(0,9);
                System.out.println(x+" ? "+y+" = "+(x*y));
                resultadoJogador = Operadores.menu(entrada);
                
                parcial(op,resultadoJogador,x,y);
            }
            
            if (op==4) {
                do
                    y = this.sortearNumeroDoIntervaloXEY(1,9);
                while(x%y!=0);
                System.out.println(x+" ? "+y+" = "+(x/y));
                resultadoJogador = Operadores.menu(entrada);
                
                parcial(op,resultadoJogador,x,y);
            }
            numeroJogadas++;
        }
        
        
        Operadores.resultado(acertos,numeroJogadas);
    }
    
    
    public static float sortearNumeroDoIntervaloXEY(int min, int max)
    {
        int numero = ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
        return (float) numero;
    }
    
    public static int sortearNumeroDoIntervaloOperadores(int min, int max)
    {
        return ((int)(java.lang.Math.random()*(max - min + 1)))+ min;
    }
    
    public static int menu(Scanner entrada1) {
        int opcao;
        
        System.out.println("Qual o operador utilizado nesta conta?");
        System.out.println("Digite 1 para ADICAO");
        System.out.println("Digite 2 para SUBTRACAO");
        System.out.println("Digite 3 para MULTIPLICACAO");
        System.out.println("Digite 4 para DIVISAO");
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
    
    public void parcial(int operador, int resultPlayer,float x,float y) {
        resultPlayer = this.verificaAmbiguidade(x,y,operador,resultPlayer);
        if(resultPlayer==operador) {
            acertos++;
            System.out.println("Correto!");
        }
        else {
            System.out.println("Resposta incorreta. O resultado correto eh "+operadores[operador-1]);
            erro++;
        }
    }
    
    public int verificaAmbiguidade(float X,float Y,int OP,int resPlayer) {
        if(((OP==3)&&(X==0))||((OP==3)&&(Y==1)))
            return OP;
        else
            if(((OP==4)&&(X==0))||((OP==4)&&(Y==1)))
                return OP;
            else
                if((OP==1)&&(Y==0))
                    return OP;
                else
                    if((OP==2)&&(Y==0))
                        return OP;
                    else
                        return resPlayer;
    }
    
    public int getAcertos()
    {
        int a = acertos;
        return a;
    }
}
