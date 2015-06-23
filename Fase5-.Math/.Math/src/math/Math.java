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
        new JFrame().setVisible(true);
        /*boolean continuar=true;
        int opcao,resFinal,matriculaAluno;
        String nomeAluno;
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        Scanner entrada3 = new Scanner(System.in);
       
        
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
            System.out.println("\t7. Relembrar ultimo acesso");
            System.out.println("\t0. Sair");
            
            System.out.print("\nInsira sua opção: ");
            opcao = entrada.nextInt();
            
            
            
            if(opcao == 0){
                continuar = false;
                System.out.println("Programa finalizado.");
            }
            if(opcao==1){
                System.out.println("Insira seu nome: ");
                nomeAluno = entrada2.nextLine();
                System.out.println("Insira sua matricula: ");
                matriculaAluno = entrada3.nextInt();
                Aluno al1 = new Aluno(nomeAluno,matriculaAluno);
                int resposta,nosJogadas=0;
                Tabuada tab = new Tabuada();
                while(tab.getErro()==0) {
                    tab.setX(tab.sortearNumeroDoIntervaloXEY(0,9));
                    tab.setY(tab.sortearNumeroDoIntervaloXEY(0,9));
                    System.out.print(""+tab.getX()+" X "+tab.getY()+" = ");
                    resposta = entrada.nextInt();
                    tab.setResultadoJogador(resposta);
                    if (tab.parcial(tab.getX(),tab.getY(),tab.getResultadoJogador())==1)
                        System.out.println("Correto!");
                    else
                        System.out.println("Resposta incorreta. O resultado correto eh "+((tab.getX())*(tab.getY())));
                    nosJogadas++;
                }
                tab.setNumeroJogadas(nosJogadas);
                resFinal=tab.resultado(tab.getAcertos(),tab.getNumeroJogadas());
                System.out.print("Voce acertou "+tab.getAcertos()+" de "+tab.getNumeroJogadas()+" contas. ");
                if(tab.resultado(tab.getAcertos(),tab.getNumeroJogadas())==5)
                    System.out.println("Parabens! Voce eh fera!");
                if(tab.resultado(tab.getAcertos(),tab.getNumeroJogadas())==4)
                    System.out.println("Excelente!");
                if(tab.resultado(tab.getAcertos(),tab.getNumeroJogadas())==3)
                    System.out.println("Muito Bom! Continue estudando!");
                if(tab.resultado(tab.getAcertos(),tab.getNumeroJogadas())==2)
                    System.out.println("Legal, mas voce pode ficar melhor! Estude mais um pouco!");
                if(tab.resultado(tab.getAcertos(),tab.getNumeroJogadas())==1)
                    System.out.println("Voce precisa estudar um pouco mais! Nao desanime!");
                Partida part = new Partida(al1,tab.getAcertos(),tab.getErro(),tab.resultado(tab.getAcertos(),tab.getNumeroJogadas()),tab.getNome());
                Arquivo arq = new Arquivo();
                arq.escreveTXT(part, "saida");
                Ranking rankingTab = new Ranking(opcao,tab.getAcertos(),nomeAluno);
            }
            if(opcao==2){
                System.out.println("Insira seu nome: ");
                nomeAluno = entrada2.nextLine();
                System.out.println("Insira sua matricula: ");
                matriculaAluno = entrada3.nextInt();
                Aluno al1 = new Aluno(nomeAluno,matriculaAluno);
                int escolha,numeroDeJogadas=0;
                Operadores operacoes = new Operadores();
                while(operacoes.getErro()==0) {
                    operacoes.setX(operacoes.sortearNumeroDoIntervaloXEY(0,9));
                    operacoes.setOperador(operacoes.sortearNumeroDoIntervaloXEY(1,4));
           
                    if (operacoes.getOperador()==1) {
                        operacoes.setY(operacoes.sortearNumeroDoIntervaloXEY(0,9));
                        System.out.println(operacoes.getX()+" ? "+operacoes.getY()+" = "+(operacoes.getX()+operacoes.getY()));
                        System.out.println("Qual o operador utilizado nesta conta?");
                        System.out.println("Digite 1 para ADICAO");
                        System.out.println("Digite 2 para SUBTRACAO");
                        System.out.println("Digite 3 para MULTIPLICACAO");
                        System.out.println("Digite 4 para DIVISAO");
                        System.out.print(">>> ");
                        escolha = entrada.nextInt();
                        operacoes.setResultadoJogador(escolha);
                        if(operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY())==1)
                            System.out.println("Correto!");
                        else
                            System.out.println("Resposta incorreta.");
                        operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY());
                    }
            
                    if (operacoes.getOperador()==2) {
                        do
                            operacoes.setY(operacoes.sortearNumeroDoIntervaloXEY(0,9));
                        while (operacoes.getY()>operacoes.getX());
                
                        System.out.println(operacoes.getX()+" ? "+operacoes.getY()+" = "+(operacoes.getX()-operacoes.getY()));
                        System.out.println("Qual o operador utilizado nesta conta?");
                        System.out.println("Digite 1 para ADICAO");
                        System.out.println("Digite 2 para SUBTRACAO");
                        System.out.println("Digite 3 para MULTIPLICACAO");
                        System.out.println("Digite 4 para DIVISAO");
                        System.out.print(">>> ");
                        escolha = entrada.nextInt();
                        operacoes.setResultadoJogador(escolha);
                        if(operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY())==1)
                            System.out.println("Correto!");
                        else
                            System.out.println("Resposta incorreta.");
                        operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY());
                    }
            
                    if (operacoes.getOperador()==3) {
                        operacoes.setY(operacoes.sortearNumeroDoIntervaloXEY(0,9));
                        System.out.println(operacoes.getX()+" ? "+operacoes.getY()+" = "+(operacoes.getX()*operacoes.getY()));
                        System.out.println("Qual o operador utilizado nesta conta?");
                        System.out.println("Digite 1 para ADICAO");
                        System.out.println("Digite 2 para SUBTRACAO");
                        System.out.println("Digite 3 para MULTIPLICACAO");
                        System.out.println("Digite 4 para DIVISAO");
                        System.out.print(">>> ");
                        escolha = entrada.nextInt();
                        operacoes.setResultadoJogador(escolha);
                        if(operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY())==1)
                            System.out.println("Correto!");
                        else
                            System.out.println("Resposta incorreta.");
                        operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY());
                    }
            
                    if (operacoes.getOperador()==4) {
                        do
                            operacoes.setY(operacoes.sortearNumeroDoIntervaloXEY(1,9));
                        while(operacoes.getX()%operacoes.getY()!=0);
                        System.out.println(operacoes.getX()+" ? "+operacoes.getY()+" = "+(operacoes.getX()/operacoes.getY()));
                        System.out.println("Qual o operador utilizado nesta conta?");
                        System.out.println("Digite 1 para ADICAO");
                        System.out.println("Digite 2 para SUBTRACAO");
                        System.out.println("Digite 3 para MULTIPLICACAO");
                        System.out.println("Digite 4 para DIVISAO");
                        System.out.print(">>> ");
                        escolha = entrada.nextInt();
                        operacoes.setResultadoJogador(escolha);
                        if(operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY())==1)
                            System.out.println("Correto!");
                        else
                            System.out.println("Resposta incorreta.");
                        operacoes.parcial(operacoes.getOperador(),operacoes.getResultadoJogador(),operacoes.getX(),operacoes.getY());
                    }
                numeroDeJogadas++;
            }
                operacoes.setNumeroJogadas(numeroDeJogadas);
                numeroDeJogadas=0;
                System.out.print("Voce acertou "+operacoes.getAcertos()+" de "+operacoes.getNumeroJogadas()+" contas. ");
                if(operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas())==5)
                    System.out.println("Parabens! Voce eh fera!");
                if(operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas())==4)
                    System.out.println("Excelente!");
                if(operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas())==3)
                    System.out.println("Muito Bom! Continue estudando!");
                if(operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas())==2)
                    System.out.println("Legal, mas voce pode ficar melhor! Estude mais um pouco!");
                if(operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas())==1)
                    System.out.println("Voce precisa estudar um pouco mais! Nao desanime!");
                Partida part = new Partida(al1,operacoes.getAcertos(),operacoes.getErro(),operacoes.resultado(operacoes.getAcertos(),operacoes.getNumeroJogadas()),operacoes.getNome());
                Arquivo arq = new Arquivo();
                arq.escreveTXT(part, "saida");
                Ranking rankingOper = new Ranking(opcao,operacoes.getAcertos(),nomeAluno);
            }
            if(opcao==3)
            {
                System.out.println("Insira seu nome: ");
                nomeAluno = entrada2.nextLine();
                System.out.println("Insira sua matricula: ");
                matriculaAluno = entrada3.nextInt();
                Aluno al1 = new Aluno(nomeAluno,matriculaAluno);
                int resposta,numeroDeJogadas=0;
                Comparacao comparacao = new Comparacao();
                while(comparacao.getErro()==0) {
                    comparacao.setX(comparacao.sortearNumeroDoIntervaloXEY(0,9));
                    comparacao.setComp(comparacao.sortearNumeroDoIntervaloXEY(1,2));
           
                    if (comparacao.getComp()==1) {
                        do
                            comparacao.setY(comparacao.sortearNumeroDoIntervaloXEY(0,9));
                        while (comparacao.getY()>=comparacao.getX());
                
                    System.out.println(comparacao.getX()+" ? "+comparacao.getY());
                    System.out.println("Qual o operador utilizado nesta comparação?");
                    System.out.println("Digite 1 para MAIOR QUE");
                    System.out.println("Digite 2 para MENOR QUE");
                    System.out.print(">>> ");
                    resposta=entrada.nextInt();
                    comparacao.setResultadoJogador(resposta);
                    if(comparacao.parcial(comparacao.getComp(),comparacao.getResultadoJogador())==1)
                        System.out.println("Correto!");
                    else
                        System.out.println("Resposta incorreta...");
                    }
            
                    if (comparacao.getComp()==2) {
                        do
                            comparacao.setY(comparacao.sortearNumeroDoIntervaloXEY(0,9));
                        while (comparacao.getY()<=comparacao.getX());
                
                    System.out.println(comparacao.getX()+" ? "+comparacao.getY());
                    System.out.println("Qual o operador utilizado nesta comparação?");
                    System.out.println("Digite 1 para MAIOR QUE");
                    System.out.println("Digite 2 para MENOR QUE");
                    System.out.print(">>> ");
                    resposta=entrada.nextInt();
                    comparacao.setResultadoJogador(resposta);
                    if(comparacao.parcial(comparacao.getComp(),comparacao.getResultadoJogador())==1)
                        System.out.println("Correto!");
                    else
                        System.out.println("Resposta incorreta...");
                    }
                numeroDeJogadas++;
                }
                comparacao.setNumeroJogadas(numeroDeJogadas);
                numeroDeJogadas=0;
                System.out.print("Voce acertou "+comparacao.getAcertos()+" de "+comparacao.getNumeroJogadas()+" contas. ");
                if(comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas())==5)
                    System.out.println("Parabens! Voce eh fera!");
                if(comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas())==4)
                    System.out.println("Excelente!");
                if(comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas())==3)
                    System.out.println("Muito Bom! Continue estudando!");
                if(comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas())==2)
                    System.out.println("Legal, mas voce pode ficar melhor! Estude mais um pouco!");
                if(comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas())==1)
                    System.out.println("Voce precisa estudar um pouco mais! Nao desanime!");
                Partida part = new Partida(al1,comparacao.getAcertos(),comparacao.getErro(),comparacao.resultado(comparacao.getAcertos(),comparacao.getNumeroJogadas()),comparacao.getNome());
                Arquivo arq = new Arquivo();
                arq.escreveTXT(part, "saida");
                Ranking rankingComp = new Ranking(opcao,comparacao.getAcertos(),nomeAluno);
            }
            if(opcao==4)
            {
                Ranking rankingTabuada = new Ranking(opcao,0,"");
            }
            if(opcao==5)
            {
                Ranking rankingOperadores = new Ranking(opcao,0,"");
            }
            if(opcao==6)
            {
                Ranking rankingComparacao = new Ranking(opcao,0,"");
            }
            if(opcao==7)
            {
                Arquivo arq = new Arquivo();
                arq.leTXT("saida");
            }
        } while( continuar );

    }*/
 }}
    

