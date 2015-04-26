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
public class Math {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean continuar=true;
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do
        {
            System.out.println("\t\tMenu de jogos de Matematica");
            System.out.println("\tSelecione seu jogo:");
            System.out.println("\t1. Jogo da Tabuada");
            System.out.println("\t2. Jogo dos Operadores");
            System.out.println("\t3. Jogo da Comparação");
            System.out.println("\t4. Ranking da Tabuada");
            System.out.println("\t5. Ranking dos Operadores");
            System.out.println("\t6. Ranking da Comparacao");
            System.out.println("\t0. Sair");
            
            System.out.print("\nInsira sua opção: ");
            opcao = entrada.nextInt();
            
            if(opcao == 0){
                continuar = false;
                System.out.println("Programa finalizado.");
            }
            if(opcao==1){
                Tabuada tab = new Tabuada();
                int pont = tab.getAcertos();
                Ranking rankingTab = new Ranking(opcao,pont);
            }
            if(opcao==2){
                Operadores operacoes = new Operadores();
                int pont = operacoes.getAcertos();
                Ranking rankingOper = new Ranking(opcao,pont);
            }
            if(opcao==3)
            {
                Comparacao comparacao = new Comparacao();
                int pont = comparacao.getAcertos();
                Ranking rankingComp = new Ranking(opcao,pont);
            }
            if(opcao==4)
            {
                Ranking rankingTabuada = new Ranking(opcao,0);
            }
            if(opcao==5)
            {
                Ranking rankingOperadores = new Ranking(opcao,0);
            }
            if(opcao==6)
            {
                Ranking rankingComparacao = new Ranking(opcao,0);
            }
        } while( continuar );

    }
 }
    

