/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author Victor
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ranking {
    
    Ranking(int opcao, int pontuacao, String nomeAluno)
    {
        if(opcao==1)
        {
            Ranking.entradaRanking("rankingTabuada.txt", pontuacao,nomeAluno);
        }
        if(opcao==2)
        {
            Ranking.entradaRanking("rankingOperadores.txt", pontuacao,nomeAluno);
        }
        if(opcao==3)
        {
            Ranking.entradaRanking("rankingComparacao.txt", pontuacao,nomeAluno);
        }
        if(opcao==4)
        {
            Ranking.acessarRanking("rankingTabuada.txt");
            
        }
        if(opcao==5)
        {
            Ranking.acessarRanking("rankingOperadores.txt");
        }
        if(opcao==6)
        {
            Ranking.acessarRanking("rankingComparacao.txt");
        }
    }
    
    public static void acessarRanking(String pathArquivo) 
    {
        try
        {
            FileReader fileR = new FileReader(pathArquivo);
            BufferedReader buff = new BufferedReader(fileR);
            int i =1;
            while(buff.ready())
            {
                System.out.print(""+i+" ");
                System.out.println(buff.readLine());
                i++;
            }
            buff.close();
        }
        catch (FileNotFoundException ex)
        {}
        catch (IOException er)
        {}
    }
    
    public static void entradaRanking(String pathArquivo, int pontuacao, String nome)
    {
        Scanner ent = new Scanner(System.in);
        String nomeEntrada;
        int vetorPontuacao[] = new int[12];
        String vetorNomes[] = new String[12];
        int n=0;
        int h=0;
        int r=0;
        try {
            FileWriter fileW = new FileWriter(pathArquivo,true);
            BufferedWriter buff = new BufferedWriter(fileW);
            FileReader fileR = new FileReader(pathArquivo);
            BufferedReader buff2 = new BufferedReader(fileR);
            if(nome.length()<3)
                nome = (nome+"  ");
            nomeEntrada = nome.substring(0, 3);
            //buff.append(""+nomeEntrada+" "+pontuacao);
            //buff.newLine();
            while((buff2.ready())&&(r<10))
            {
                String isto = buff2.readLine();
                String isto2 = isto.substring(0, 3);
                vetorNomes[r]=isto2;
                r++;
            }
            vetorNomes[r]=nomeEntrada; 
            buff2.close();
            FileReader fileR2 = new FileReader(pathArquivo);
            BufferedReader buff3 = new BufferedReader(fileR2);
            while(buff3.ready()&&(h<10))
            {
                buff3.skip(4);
                String algo = buff3.readLine();
                int algo2 = Integer.parseInt(algo);
                vetorPontuacao[h]=algo2;
                h++;
                n++;
            }
            vetorPontuacao[h]=pontuacao;
            bubbleSort(vetorPontuacao,n+1,vetorNomes,pathArquivo);
            
            buff.close();
            buff3.close();
        } 
        catch (IOException ex) {
            
        }
    }
    
    public static void bubbleSort(int vetor[],int tamanho, String nomes[],String pathArquivo)
    {
        int aux = 0;
        int i=0;
        String auxiliar;
        for(i=0;i<tamanho;i++)
        {
            for(int j=0;j<tamanho;j++)
            {
                if(vetor[j]<vetor[j+1])
                {
                    aux = vetor[j];
                    vetor[j]=vetor[j+1];
                    vetor[j+1]=aux;
                    auxiliar = nomes[j];
                    nomes[j]=nomes[j+1];
                    nomes[j+1]=auxiliar;
                }
            }
        }
        try {
            FileWriter fileW = new FileWriter(pathArquivo);
            BufferedWriter buff = new BufferedWriter(fileW);
            buff.write(nomes[0]+" "+vetor[0]);
            buff.newLine();
            buff.close();
            FileWriter fileW2 = new FileWriter(pathArquivo,true);
            BufferedWriter buff2 = new BufferedWriter(fileW2);
            for(int m=1;((m<10)&&(m<tamanho));m++)
            {
                buff2.append(nomes[m]+" "+vetor[m]);
                buff2.newLine();
            }
            buff2.close();
        } catch (IOException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

   
}

   

